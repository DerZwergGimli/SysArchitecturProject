# Redis Server Topic Structure


##REDIS topics in ASCII
```shell
.
+-- management
|   +-- threads
|       +-- managementRunnable 			(true/false)
|       +-- collisonAvoidanceRunnable	(true/false)
|       +-- databaseReaderRunnable		(true/false)
|       +-- databaseWriterRunnable		(true/false)
|
+-- sensors
|   +-- lidar
|       +-- angles 		(all values are seperated by a semicolon)
|       +-- distances 	(all values are seperated by a semicolon)
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
|      +-- temperature
|          +-- cpu0
|          +-- unit
```