# Spring Cloud Circuit Breaker

This is a basic example of the use of Netflix Hystrix from Spring Cloud.
It has four modules:

* [Discovery-server module](https://github.com/geraldoms/spring-cloud-circuit-breaker/tree/master/discovery-server):
This module contains the service discovery using the Netflix Eureka.

* [Hystrix-dashboard module](https://github.com/geraldoms/spring-cloud-circuit-breaker/tree/master/hystrix-dashboard): 
 This module contains the Hystrix dashboard to monitor the Hystrix metrics in real time.

* [Time-app module](https://github.com/geraldoms/spring-cloud-circuit-breaker/tree/master/time-app): 
This module contains a simple API using the Hytrix Command with a fallBack method to call the time-service.

* [Time-service module](https://github.com/geraldoms/spring-cloud-circuit-breaker/tree/master/time-service): 
This module contains the time service which returns the current date and time.

To run this example you need to execute Discovery-server module first. The order of the remaining services are not really important.

## Requirements
* JDK 8 or later
* Maven 3.2+

## Installation 
`$ mvn package`

## Usage 

After running the command above (in the installation section), you can start the application by running the following commands:   
 
 1. `java -jar discovery-server/target/discovery-server-0.0.1-SNAPSHOT.jar`;
 2. `java -jar time-service/target/time-service-0.0.1-SNAPSHOT.jar`
 3. `java -jar time-app/target/time-app-0.0.1-SNAPSHOT.jar`;
 4. `java -jar hystrix-dashboard/target/hystrix-dashboard-0.0.1-SNAPSHOT.jar`;

After that, you can start generating some metrics accessing `http://localhost:8000/time`.
The Hystrix dashboard is accessible by accessing `http://localhost:8080/hystrix`. Some fields need to be filled, 
as shown in the image below.

<p align="center">
  <img width="540" height="400" src="https://user-images.githubusercontent.com/13106549/43150469-020934b4-8f38-11e8-92f7-e97e8e21445a.png">
</p>

The image below shown some metrics from the Hystrix dashboard in real time.

<p align="center">
  <img width="540" height="400" src="https://user-images.githubusercontent.com/13106549/43150494-126256a6-8f38-11e8-88d4-bdad67c2ea33.png">
</p>

## Request samples 

Request:
```bash
curl http://localhost:8000/time
```
Response:
```json
Hello, today is Tuesday, the date is 7-24-2018 and the time right now is 11:50:28.
```
