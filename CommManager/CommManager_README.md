## com.AutonomV.Communication Manager
#### Abstact
This Application will run on the normal JVM to communicate with the Webserver com.AutonomV.Management System.
It has an interface to the MQTT Broker and an interface to the Redis Local DB.

#### Dependencies
This Application uses Maven to manage Dependencies.
The folowing  Dependencies are needed for the Implementation: 
##### Eclipse Paho MQTT Client
```
  <repositories>
        <repository>
            <id>Eclipse Paho Repo</id>
            <url>https://repo.eclipse.org/content/repositories/paho-releases/</url>
        </repository>
   </repositories>
  <dependency>
      <groupId>org.eclipse.paho</groupId>
      <artifactId>org.eclipse.paho.client.mqttv3</artifactId>
      <version>1.2.0</version>
  </dependency>
```  
  ##### JUnit for Testing
```
  <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.10</version>
  </dependency>
```
