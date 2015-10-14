# WORKSHOP

----
15.10.2015, TALLINN
----
Slides: https://docs.google.com/presentation/d/1tqE27a9Q3YB3nvWPW74XRYhnQ0Ky775f3Z09fSJdsqA/edit?usp=sharing


Create new Maven project:
```
$ mvn -B archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=com.cgi.workshop -DartifactId=configuration-server
```


# WORKSHOP
## Setup environment - git clone, maven, jdk1.8
## Introduction
## RabbitMQ topologies
- DirectExchange
- FanoutExchenge
- TopicExchange

GOAL:
Get those topologies working end-to-end.

## Integration patterns
- Routing
- PubSub
- Request-Response
- Filter
- Aggregate
- Split
- Sprint Integration comes to rescue!

## Configurations
http://localhost:8888/configuration/projectName

Start also app2
## Service discovery
[service-discovery]
http://localhost:8761/

Start also app2


# ADDITIONAL READINGS

* [http://docs.spring.io/spring-amqp/reference/htmlsingle/] Spring AMQP
* [https://github.com/spring-projects/spring-integration-java-dsl/wiki/Spring-Integration-Java-DSL-Reference] Spring Integration Java DSL Reference
* [http://docs.spring.io/spring-integration/reference/html/amqp.html] Spring Integration AMQP Support
* [https://github.com/spring-projects/spring-integration-samples] Spring Integration Samples
* [https://github.com/spring-projects/spring-boot] Spring Boot and samples
* [http://12factor.net/]
* [https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance] Eureka
* [https://github.com/spring-cloud/spring-cloud-config] Sprign Cloud Config
