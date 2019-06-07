# Vehicle Doc

using JamaicaVM - Java Realtime

#### Links to helpful webseites

* JamaicaVM - [API](http://www.aicas.com/jamaica/8.2/doc/jamaica_api/index.html)
* JamaicaVM - [MANUAL](https://www.aicas.com/cms/sites/default/files/JamaicaVM-8.2-manual-web.pdf)
* Redis - [Jedis](https://www.javadoc.io/doc/redis.clients/jedis/3.1.0-m1)

Some info about memory and GBC in JVM
http://www.aicas.com/jamaica/3.2/doc/html/x3672.html

-- SomeNiceSlides
https://slideplayer.com/slide/12774547/



--RT Java Book (Google)
[Book](https://books.google.de/books?id=jzfhQ8Pb_k8C&pg=PP175&lpg=PP175&dq=ReleaseParameters+and+threads&source=bl&ots=d0hKz3xj2K&sig=ACfU3U1uLlaudSQ16nrQvaBtLA-eELlZQg&hl=de&sa=X&ved=2ahUKEwj-34zn1tTiAhXEUlAKHdpwCl8Q6AEwB3oECAYQAQ#v=onepage&q=overrun&f=false)



## MQTT public HTWG server

- user: 
- password:







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

## Scheduler

#### - Scheduler Sample

```java
RelativeTime rt = newRelativeTime(5000L, 0);
AperiodicParameters ap = newAperiodicParameters(rt, rt, null, null);
MemoryParameters mem= newMemoryParameters(60000L, 60000L);
PriorityScheduler ns = PriorityScheduler.instance();

Scheduler.setDefaultScheduler(ns);
PriorityParameters pp = newPriorityParameters(ns.getMinPriority()+10);
RealtimeThread rtt = newRealtimeThread(pp, ap);
boolean b = ns.setIfFeasible(rtt, ap, mem);
if(b)
    rtt.start();
```

## Thread Communication

3 Wait-Free Queues are used for communication between RT-Threads and Java-Threads

| Queue-Types        |                                                              |
| ------------------ | ------------------------------------------------------------ |
| WaitFreeWriteQueue | blocking free writing, synchronized reading                  |
| WaitFreeReadQueue  | blocking free reading, synchronized writing                  |
| WaitFreeDequeue    | blocking free reading and writing and synchronized reading and writing |



## Memory INFO

| Types                             |                                               |
| --------------------------------- | --------------------------------------------- |
| Standard Heap                     | all threads, with GC                          |
| Immortal Memory                   | all threads, without GC                       |
| Scoped Memory (VTMemory/LTMemory) | only RT-Threads, without GC, frees on fininsh |
| Physical Memory                   | access via Raw Memory Access                  |
| NoHeapRealtimeThread              | no access on Heap                             |

#### -Memory Sample1

```java
ScopedMemory ma = new LTMemory(60000L);Long size = ma.size();ma.enter(new Runnable(){public void run(){...}});

Object immortalObj = ImmortalMemory.instance().newInstance(Object.class);
```

#### - Memory Sample2

```java
Memory Beispiele2short s = 12;
long address = 015002;
long size= 2;
RawMemoryAccess rawMemory = new RawMemoryAccess(address, size);rawMemory.setShort(0, s);

short s2 = rawMemory.getShort(0);
```

http://www.devx.com/Java/Article/33475/0/page/2

## Time INFO

| HighResolutionTime |                                    |
| ------------------ | ---------------------------------- |
| AbsoluteTime       | absolute time since 01.01.1970 GMT |
| RelativeTime       | time relative to start time        |
| RationalTime       | used for sequences and periodes    |

| Timer         |                             |
| ------------- | --------------------------- |
| OneShotTimer  | invokes event once          |
| PeriodicTimer | invokes events periodically |

#### - Timer Sample1

```java
final Boolean stopLooping = false;
OneShotTimer timer2 = new OneShotTimer(
    new RelativeTime( 10000, 0), 
    new AsyncEventHandler(){
        public void handleAsyncEvent(){
            stopLooping = true;}
    });

timer.start();
while(!stopLooping){
    Thread.sleep(1000);
}
```

#### - Timer Sample2

```java
Timer Beipiel2PeriodicTimer timer = new PeriodicTimer(
    null, //start now
    new RelativeTime( 1500, 0),  // tick = 1.5 s
    new AsyncEventHandler(){
        public void handleAsyncEvent({
            System.out.println("Tick");
        };
	});
        
timer.start();
Thread.sleep(20000)
```



## AsyncEvent

- represents a internal or external Event

| EventHandler           |                                                              |
| ---------------------- | ------------------------------------------------------------ |
| AsyncEventHandler      | similar to RT-Threads but can only be blocked or scheduled, not waiting or sleeping |
| BoundAsyncEventHandler | bounded to a specific Thread                                 |

AsynchronouslyInterruptedException:

- must be thrown when interrupting methodes

- will be invoked by `throw` or `interrupted()`on a RT-Thread 

- can handle/stop Threads safely/clean

    

#### - Event Sample

```java
AsyncEvent Interrupt = newAsyncEvent();
SchedulingParameters priParams = new PriorityParameters(PriorityScheduler.instance().getMaxPriority());
ReleaseParameters releaseParams = newSporadicParameters(newRelativeTime(1,0));
AsyncEventHandler InterruptHandler = newBoundAsyncEventHandler(priParams, releaseParams, null, null, null, false, null);
Interrupt.addHandler(InterruptHandler);
Interrupt.bindTo("0177760");

ReleaseParameters.setDeadlineMissHandler(handler);
```



## Data Structure

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
