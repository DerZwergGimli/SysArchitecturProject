package com.AutonomV.Management;

import com.AutonomV.Communication.ComController;
import com.AutonomV.Communication.DBController;
import com.AutonomV.Entity.OS.CPU;
import com.AutonomV.Entity.OS.Network.NetworkInfo;
import com.AutonomV.Entity.OS.Network.Received;
import com.AutonomV.Entity.OS.Network.Transmitted;
import com.AutonomV.Entity.OS.RealTimeData;
import com.AutonomV.Entity.OS.VehicleOS;
import com.AutonomV.Entity.Passengers.Passenger;
import com.AutonomV.Entity.Sensor;
import com.AutonomV.Entity.Vehicle;
import com.AutonomV.Util.Converter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This Class extends the Thread Class and runs an infinite loop if not interrupted.
 * The Interval can be changed depending on the State from the ManagementThread.
 * It retrievs the Data from the Redis DB, format it to JSON and pass it to the ComController to send it over MQTT.
 *
 * @author Mgsair
 */
public class DataPersistanceThread extends Thread {
    private static final String TAG = "DataPersistanccyThread";

    private int interval_ms;
    private int noDriverSendingInterval = 10000;
    private int driverSendingInterval = 5000;
    private DBController dbController;
    private ComController comController;
    private Logger logger;
    private String networkDBentry = "sensors:os:network:eth0:";
    private String jitterDBentry = "sensors:lidar:timing:";

    public DataPersistanceThread(int interval_ms, ComController comController, Logger logger) {
        this.interval_ms = interval_ms;
        this.comController = comController;
        this.logger = logger;
        dbController = DBController.getInstance();

    }

    /**
     * This method initializes the properties of this class by opening the config file and getting the properties from it
     */
    public void initProperties() {
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            this.networkDBentry = properties.getProperty("networkDBentry", "sensors:os:network:eth0:");
            this.jitterDBentry = properties.getProperty("jedisDBentry", "sensors:collsionAvoidance:timing:collionControllExecutionTime:");
            this.noDriverSendingInterval = Integer.valueOf(properties.getProperty("noDriverSendingInterval", "10000"));
            this.driverSendingInterval = Integer.valueOf(properties.getProperty("driverSendingInterval", "5000"));

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error while trying to read config of DataPersistancy", ex);
        }
    }

    /**
     * This is the runnable method for this thread, it calls getVehicleData() and getVehicleOS() to retrieve Data from
     * the Database, and sends it over MQTT by calling CommController's publish method
     */
    @Override
    public void run() {
        while (true) {
            sendVehicle();
            sendVehicleOS();

            if (ManagementThread.getManagementState() == ManagementThread.NO_DRIVER) {
                interval_ms = noDriverSendingInterval; // 10s
            } else {
                interval_ms = driverSendingInterval; // 5s
            }

            try {
                Thread.sleep(interval_ms);
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, "Error while calling Thread.sleep() ", e);
            }

        }

    }

    private void sendVehicle() {
        Vehicle vehicle = getVehicleData();
        String vehicleJson = Converter.pojo2json(vehicle);

        comController.publish("/SysArch/V1/Sensors/", vehicleJson, 2);
    }

    /**
     * This method retrieves the Vehicle Data and puts it into the Vehicle instance
     * @return Vehicle the vehicle instance with all the data retrieved
     */
    public Vehicle getVehicleData() {
        logger.entering(TAG,"getVehicleData");

        Sensor tempSensor = new Sensor("Temperature",
                dbController.get("sensors:temperature:data"),
                " Degree Celsius",
                "On",
                dbController.get("sensors:temperature:timestamp"));
        Sensor pressureSensor = new Sensor("Pressure",
                dbController.get("sensors:barometer:data"),
                dbController.get("sensors:barometer:unit"),
                dbController.exists("sensors:temperature:data"),
                dbController.get("sensors:barometer:timestamp"));
        Sensor accelSensor = new Sensor("Acceleration",
                dbController.get("sensors:accelerometer:accelerometer_x")
                        + "," + dbController.get("sensors:accelerometer:accelerometer_y")
                        + "," + dbController.get("sensors:accelerometer:accelerometer_z"),
                dbController.get("sensors:accelerometer:unit"),
                dbController.exists("sensors:accelerometer:accelerometer_x"),
                dbController.get("sensors:accelerometer:timestamp"));
        Sensor gyroSensor = new Sensor("Gyro",
                dbController.get("sensors:gyro:gyro_x")
                        + "," + dbController.get("sensors:gyro:gyro_y")
                        + "," + dbController.get("sensors:gyro:agyro_z"),
                dbController.get("sensors:gyro:unit"),
                dbController.exists("sensors:gyro:gyro_x"),
                dbController.get("sensors:gyro:timestamp"));
        Sensor lidarSensor = new Sensor("LidarDistances",
                dbController.get("sensors:lidar:distances"),
                "mm",
                dbController.get("management:threads:lidarDataCollectionThreadRunnable"),
                dbController.get("sensors:lidar:timestamp"));
        Passenger driverPassenger = new Passenger("Driver",
                dbController.get("sensors:rfid:present"),
                dbController.get("sensors:rfid:timestamp"));
//        Passenger frontSeatPassenger = new Passenger("front-seat passenger",
//                dbController.get("Passenger:isPresent"),
//                "20190624T005155Z"); // TODO: Timestamp

        Vehicle vehicle = new Vehicle();
        vehicle.addSensors(tempSensor);
        vehicle.addSensors(pressureSensor);
        vehicle.addSensors(accelSensor);
        vehicle.addSensors(gyroSensor);
        vehicle.addSensors(lidarSensor);
        vehicle.addPassengers(driverPassenger);
//        vehicle.addPassengers(frontSeatPassenger);

        logger.exiting(TAG,"getVehicleData");
        return vehicle;
    }

    private void sendVehicleOS() {

        VehicleOS vehicleOS = getVehicleOS();
        String oSJson = Converter.pojo2json(vehicleOS);

        comController.publish("/SysArch/V1/OS/", oSJson, 2);
    }

    /**
     * This method retrieves the VehicleOS Data and puts it into the VehicleOS instance
     * @return VehicleOS the vehicleOS instance with all the data retrieved
     */
    public VehicleOS getVehicleOS() {
        logger.entering(TAG,"getVehicleOS");
        Sensor CPUtempSensor = new Sensor();
        CPUtempSensor.setName("CPUtemperature");
        CPUtempSensor.setUnit("Degree Celsius");
        CPUtempSensor.setState(dbController.get("CPUtempState"));
        CPUtempSensor.setValue(dbController.get("sensors:os:temperature:cpu0"));
        CPUtempSensor.setTimestamp(dbController.get("sensors:os:temperature:timestamp"));
        Float cpuLoad = (float) 0;
        try {
            cpuLoad = 100 - Float.parseFloat(dbController.get("sensors:os:top:cpu_idle"));
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Error while trying to parse Float from String", ex);
        }

        CPU cpu = new CPU(CPUtempSensor, cpuLoad.toString(), dbController.get("CPU:CPUactiveCores"));

        Sensor jitterSensor = new Sensor("Jitter",
                dbController.get(jitterDBentry + "diffTimeNano"),
                "ns",
                dbController.get("management:threads:collisonAvoidanceRunnable"),
                dbController.get(jitterDBentry + "timestamp"));
        RealTimeData realTimeData = new RealTimeData(jitterSensor, dbController.get("RT:numOfRTThreads"));

        Received received = new Received(dbController.get(networkDBentry + "rx_bytes"),
                dbController.get(networkDBentry + "rx_packages"),
                dbController.get(networkDBentry + "rx_errors"),
                dbController.get(networkDBentry + "rx_dropped"),
                dbController.get(networkDBentry + "rx_overrun"),
                dbController.get(networkDBentry + "rx_mcast"));
        Transmitted transmitted = new Transmitted(dbController.get(networkDBentry + "tx_bytes"),
                dbController.get(networkDBentry + "tx_packages"),
                dbController.get(networkDBentry + "tx_errors"),
                dbController.get(networkDBentry + "tx_dropped"),
                dbController.get(networkDBentry + "tx_carrier"),
                dbController.get(networkDBentry + "tx_collsns"));
        NetworkInfo networkInfo = new NetworkInfo(received, transmitted);

        logger.exiting(TAG,"getVehicleOS");

        return new VehicleOS(cpu, networkInfo, realTimeData);
    }

    public int getInterval_ms() {
        return interval_ms;
    }

    public void setInterval_ms(int interval_ms) {
        this.interval_ms = interval_ms;
    }
}
