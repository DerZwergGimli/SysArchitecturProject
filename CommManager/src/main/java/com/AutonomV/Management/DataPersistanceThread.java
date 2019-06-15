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
    }

    @Override
    public void run() {

        sendVehicle();
        sendVehicleOS();


        try {
            Thread.sleep(interval_ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void sendVehicle() {
        Vehicle vehicle = getVehicleData();
        String vehicleJson = Converter.pojo2json(vehicle);

        comController.publish("/V1/Sensors/", vehicleJson, 2);
    }

    private Vehicle getVehicleData() {
        // TODO: set the attributes of the sensors and ..
        Sensor tempSensor = new Sensor();
        Sensor humiditySensor = new Sensor();
        Sensor speedSensor = new Sensor();
        Passenger driverPassenger = new Passenger();
        Passenger frontSeatPassenger = new Passenger();
        Lidar lidarSensor = new Lidar();

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
        CPU cpu = new CPU(CPUtempSensor, dbController.get("CPU:CPUload"), dbController.get("CPU:CPUactiveCores"));

        Sensor jitterSensor = new Sensor("Jitter", dbController.get("RT:JitterValue"), "ms", dbController.get("RT:JitterStater"), dbController.get("RT:JitterTimestamp"));
        RealTimeData realTimeData = new RealTimeData(jitterSensor, dbController.get("RT:numOfRTThreads"));

        Received received = new Received(dbController.get("rx_bytes"), dbController.get("rx_packages"), dbController.get("rx_errors"), dbController.get("rx_dropped"), dbController.get("rx_overrun"), dbController.get("rx_mcast"));
        Transmitted transmitted = new Transmitted(dbController.get("received:bytes"), dbController.get("received:packages"), dbController.get("received:errors"), dbController.get("received:dropped"), dbController.get("received:carrier"), dbController.get("received:collsns"));
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
