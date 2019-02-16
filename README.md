# Eureka Server

Starts up an Eureka Server that functions as the service registry. 

This server will allow other micro-services (Eureka clients) to register and enable automatic service discovery.


# Zuul Proxy

Starts up a Zuul server that will connect to the Eureka server to discover services.

HTTP request are sent to the Zuul server, which will forward requests onto an instance of the respective service

# Eureka Discovery Client

Starts up a simple web server that exposes a "hello" endpoint and returns which port it is running on.

There are 3 of these running on different ports, with the same application name.

Our Zuul requests will get forwarded to one of these 3 instances.

## Getting Started

Open and run each module independently.

### Prerequisites

IntelliJ or any other IDE

Java 8

### Running

1. Run the Eureka Server application.

2. Run the 3 Eureka Discovery Client applications.
 
3. Run the Zuul Proxy application.

4. Eureka Server logs should show the following, indicating that all services have successfully registered
```
Registered instance ZUUL-GATEWAY/localhost:zuul-gateway:307062988 with status UP (replication=false)
Registered instance EUREKA-CLIENT-1/localhost:eureka-client-1:80095928 with status UP (replication=false)
Registered instance EUREKA-CLIENT-2/localhost:eureka-client-2:-1921096401 with status UP (replication=false)
Registered instance EUREKA-CLIENT-3/localhost:eureka-client-3:242279279 with status UP (replication=false)
```

5.Access the Eureka server page: http://localhost:8080/
```
EUREKA-CLIENT	n/a (3)	(3)	UP (3) - localhost:eureka-client:1884578812 , localhost:eureka-client:-946713006 , localhost:eureka-client:-732605393
ZUUL-GATEWAY	n/a (1)	(1)	UP (1) - localhost:zuul-gateway:645588532
```

6.Send GET request to Zuul-Gateway against the eureka-client path: http://localhost:8085/eureka-client/hello. 

Repeat the request several times, and you should see the request hitting a different instance:
```
Hello from 8083
Hello from 8082
Hello from 8081
```

### Useful Documentation
https://www.baeldung.com/spring-cloud-netflix-eureka
https://www.baeldung.com/zuul-load-balancing
https://cloud.spring.io/spring-cloud-netflix/multi/multi__service_discovery_eureka_clients.html
https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-eureka-server.html