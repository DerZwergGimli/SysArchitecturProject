# Vehicle Doc
## using JamaicaVM

# Links to helpful webseites

* JamaicaVM - [API](http://www.aicas.com/jamaica/8.2/doc/jamaica_api/index.html)
* JamaicaVM - [MANUAL](https://www.aicas.com/cms/sites/default/files/JamaicaVM-8.2-manual-web.pdf)
* Redis - [Jedis](https://www.javadoc.io/doc/redis.clients/jedis/3.1.0-m1)

Some info about memory and GBC in JVM
http://www.aicas.com/jamaica/3.2/doc/html/x3672.html

-- SomeNiceSlides
https://slideplayer.com/slide/12774547/
 


### Logger-Info


The following lists the Log Levels in descending order:

    SEVERE (highest)
    WARNING
    INFO
    CONFIG
    FINE
    FINER
    FINEST

additionally you have OFF and ALL!


### Thread-Info

There are 3 static variables defined in Thread class for priority.

public static int MIN_PRIORITY		: 	This is minimum priority that a thread can have. Value for this is 1.
public static int NORM_PRIORITY		: 	This is default priority of a thread if do not explicitly define it. Value for this is 5.
public static int MAX_PRIORITY		: 	This is maximum priority of a thread. Value for this is 10.


### Memory config stuff
- TODO: work to do



### Data Structure
#### 1. Driver Info
* Driver
  * ID                (:int)
  * firstName         (:string) 
  * lastName          (:string) 
  * authLevel         (Authentification Level :int) 

#### 2. System Statics
* System
  * CPU              
    * CPUTemp        (in °C :int)
    * CPULoad        (in  % :int)
    * CPUActiveCores (:int, optional)
  * Net
    * tbd
  * RT
    * jitter
    * numOfRTThreads (int)
#### 3. Sensors States
* Sensors
  * LidarSensorState (ON/OFF: bool)
  * TempSensorState  (ON/OFF: bool)
  * MotorRPM         (Rotation/min: int)
