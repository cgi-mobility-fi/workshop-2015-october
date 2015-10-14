# WORKSHOP

----
15.10.2015, TALLINN
----
Slides: https://docs.google.com/presentation/d/1tqE27a9Q3YB3nvWPW74XRYhnQ0Ky775f3Z09fSJdsqA/edit?usp=sharing

# WORKSHOP
## Setup environment - git clone, maven, jdk1.8
Projects:
* __publisher__: publishing logic for the queues
* __consumer__: consumer logic for the queues
* __domain__: common classes to be used across projects
* __spring-integration__: spring integration Java DSL for working with messaging
* __service-discovery__: provides service discovery with Eureka
* __configuration-server__: provides configurations to connected nodes
* __app2__: sample application that registers itself with Eureka and uses distributed configuration server

## Introduction
## RabbitMQ topologies
- DirectExchange
- FanoutExchange
- TopicExchange

RabbitMQ management URL: http://52.19.152.171:15672/ (guest/{password will be provided})

__GOALS__:
* Get those topologies implemented end-to-end.
* Use Java 8 where it's possible

## Integration patterns
- Routing
- PubSub
- Request-Response
- Filter
- Aggregate
- Split
- Sprint Integration comes to rescue!

__GOALS__:
* Get hands-on experience
* Use Java 8 where it's possible
* Come up with ideas where to apply those in current applications

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

