# Redis Server Topic Structure


##REDIS topics in ASCII
```shell
.
+-- management
|   +-- threads
|       +-- managementRunnable 			(true/false)
|       +-- collisonAvoidanceRunnable		(true/false)
|       +-- databaseReaderRunnable		(true/false)
|       +-- databaseWriterRunnable		(true/false)
|
+-- sensors
|   +-- lidar
|       +-- angles 		(all values are seperated by a semicolon)
|       +-- distances 		(all values are seperated by a semicolon)
|   +-- os
|       +-- network
|           +-- wlp2s0
|               +-- rx_bytes
|               +-- rx_dropped
|               +-- rx_errors
|               +-- rx_mcast
|               +-- rx_overrun
|               +-- rx_packages
|               +-- tx_bytes
|               +-- tx_carrier
|               +-- tx_collsns
|               +-- tx_droppped
|               +-- tx_errors
|               +-- tx_packages
|      +-- temperatur
|          +-- cpu0
|          +-- unit
|      +-- top
|           +-- timestamp
|           +-- systemTime
|           +-- uptime
|           +-- uptimeUnit
|           +-- users_active
|           +-- loadAverage_1min
|           +-- loadAverage_5min
|           +-- loadAverage_15min
|           +-- cpu_user
|           +-- cpu_system
|           +-- cpu_nice
|           +-- cpu_idle
|           +-- cpu_wait
|           +-- cpu_hardwareInterrupts
|           +-- cpu_softwareInterrupts
|           +-- cpu_stolenTimeByHypervisor
|           +-- memory_total
|           +-- memory_free
|           +-- memory_used
|           +-- memory_bufferCache
|           +-- memory_unit
|           +-- swap_total
|           +-- swap_free
|           +-- swap_used
|           +-- swap_bufferCache
|           +-- swap_unit
|       +-- thread
|           +-- collionControll
|               +-- startTimeNano
|               +-- endTimeNano
|               +-- diffTimeNano
```