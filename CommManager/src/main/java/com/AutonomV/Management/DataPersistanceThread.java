package com.AutonomV.Management;

import com.AutonomV.Communication.ComController;
import com.AutonomV.Communication.DBController;
import com.AutonomV.Entity.Lidar;
import com.AutonomV.Entity.OS.CPU;
import com.AutonomV.Entity.OS.Network.NetworkInfo;
import com.AutonomV.Entity.OS.Network.Received;
import com.AutonomV.Entity.OS.Network.Transmitted;
import com.AutonomV.Entity.OS.RealTimeData;
import com.AutonomV.Entity.OS.VehicleOS;
import com.AutonomV.Entity.Passengers.Driver;
import com.AutonomV.Entity.Passengers.Passenger;
import com.AutonomV.Entity.Sensor;
import com.AutonomV.Entity.Vehicle;
import com.AutonomV.Util.Converter;
import sun.java2d.pipe.DrawImage;
import sun.jvm.hotspot.jdi.ConcreteMethodImpl;

/**
 * This Class extends the Thread Class and runs an infinite loop if not interrupted.
 * The Interval can be changed depending on the State from the ManagementThread.
 * It retrievs the Data from the Redis DB, format it to JSON and pass it to the ComController to send it over MQTT.
 */
public class DataPersistanceThread extends Thread {

    private int interval_ms;
    private DBController dbController;
    private ComController comController;

    public DataPersistanceThread(int interval_ms, ComController comController) {
        this.interval_ms = interval_ms;
        this.comController = comController;
        dbController = DBController.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            sendVehicle();
            sendVehicleOS();

            if (ManagementThread.getManagementState() == ManagementThread.NO_DRIVER) {
                interval_ms = 30000; // 30s
            } else {
                interval_ms = 5000; // 5s
            }

            try {
                Thread.sleep(interval_ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private void sendVehicle() {
        Vehicle vehicle = getVehicleData();
        String vehicleJson = Converter.pojo2json(vehicle);

        comController.publish("/V1/Sensors/", vehicleJson, 2);
    }

    private Vehicle getVehicleData() {
        Sensor tempSensor = new Sensor("Temperature",dbController.get("Sensors:TempValue"),"°C",dbController.get("Sensors:TempState"),dbController.get("Sensors:TempTimestamp"));
        Sensor humiditySensor = new Sensor("Humidity",dbController.get("Sensors:HumidityValue"),"%",dbController.get("Sensors:HumidityState"),dbController.get("Sensors:HumidityTimestamp"));
        Sensor speedSensor = new Sensor("Speed",dbController.get("Sensors:SpeedValue"),"km/h",dbController.get("Sensors:SpeedState"),dbController.get("Sensors:SpeedTimestamp"));
        Passenger driverPassenger = new Passenger("Driver",dbController.get("Driver:isPresent"),"timestamp"); // TODO: Timestamp
        Passenger frontSeatPassenger = new Passenger("front-seat passenger",dbController.get("Passenger:isPresent"),"timestamp"); // TODO: Timestamp
        Lidar lidarSensor = new Lidar(dbController.get("Sensors:Lidar:angles"),"°",dbController.get("Sensors:Lidar:distances"),"cm", dbController.get("management:threads:collisonAvoidanceRunnable"),dbController.get("sensors:lidar:timestamp"));

        Vehicle vehicle = new Vehicle();
        vehicle.addSensors(tempSensor);
        vehicle.addSensors(humiditySensor);
        vehicle.addSensors(speedSensor);
        vehicle.addPassengers(driverPassenger);
        vehicle.addPassengers(frontSeatPassenger);
        vehicle.setLidar(lidarSensor);
        return vehicle;
    }

    private void sendVehicleOS() {

        VehicleOS vehicleOS = getVehicleOS();
        String oSJson = Converter.pojo2json(vehicleOS);

        comController.publish("/V1/OS/", oSJson, 2);
    }

    private VehicleOS getVehicleOS() {
        Sensor CPUtempSensor = new Sensor();
        CPUtempSensor.setName("CPUtemperature");
        CPUtempSensor.setUnit("°C");
        CPUtempSensor.setState(dbController.get("CPUtempState"));
        CPUtempSensor.setValue(dbController.get("CPUtempValue"));
        CPUtempSensor.setTimestamp(dbController.get("CPU:CPUtempTimestamp"));
        Integer cpuLoad = 100 - Integer.parseInt(dbController.get("os:top:cpu_idle"));
        CPU cpu = new CPU(CPUtempSensor, cpuLoad.toString(), dbController.get("CPU:CPUactiveCores"));

        Sensor jitterSensor = new Sensor("Jitter", dbController.get("os:thread:collionControll:diffTimeNano"), "ns", dbController.get("RT:JitterStater"), dbController.get("os:thread:collionControll:JitterTimestamp"));
        RealTimeData realTimeData = new RealTimeData(jitterSensor, dbController.get("RT:numOfRTThreads"));

        Received received = new Received(dbController.get("rx_bytes"), dbController.get("rx_packages"), dbController.get("rx_errors"), dbController.get("rx_dropped"), dbController.get("rx_overrun"), dbController.get("rx_mcast"));
        Transmitted transmitted = new Transmitted(dbController.get("tx_bytes"), dbController.get("tx_packages"), dbController.get("tx_errors"), dbController.get("tx_dropped"), dbController.get("tx_carrier"), dbController.get("tx_collsns"));
        NetworkInfo networkInfo = new NetworkInfo(received, transmitted);

        return new VehicleOS(cpu, networkInfo, realTimeData);
    }

    public int getInterval_ms() {
        return interval_ms;
    }

    public void setInterval_ms(int interval_ms) {
        this.interval_ms = interval_ms;
    }
}
