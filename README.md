# Lab-06 ARSW

This programm allow the user to deploy a server that allows for a client side multi-user drawing program
2024/06/30

IN ORDER FOR THIS PROGRAM TO WORK PROPERLY, PLEASE USE THE FOLLOWING CLIENT:

[LAB 06 CLIENT](https://github.com/Parralol/Lab06ARSW-Client/tree/main)

## Architecture 

![Architecture](https://github.com/Parralol/Lab06ARSW/assets/110953563/e703ab22-b119-4165-8fab-f84a9e4474e2)

As seen by the following diagram the user connects via browser to use the program, then he must connect via http using the 8080 port (tomcat), the program is deployed in a EC2 instance which runs the program with the Spring framework, this program is running two java classes, the main one being Lab05Application and the controller being Lab05Controller, the way the main class comunicates with the controller is via paths, the main path being _/calculator_ is the first one to be run, then the responses the controller gives are being delivered as infomation in the post type paths _/case_ & _/calculate_

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

First you need the following java version (command to see your current java version below)

```
java -version
```

![image](https://github.com/Parralol/Lab05ARSW/assets/110953563/87192abf-bebd-4d74-ad1e-e62a94405c43)

to see the maven version we are using we need to enter the following command, also this is the version of Maven this programm uses

```
mvn -version
```

![image](https://github.com/Parralol/Lab05ARSW/assets/110953563/8711cee6-e4ba-47ae-b46c-8984142890bb)


### Installing

First clone this proyect into your own system, then 

```
mvn clean package
```

### Acceptance test


https://github.com/Parralol/Lab06ARSW/assets/110953563/cac2d4bf-4d8c-4023-9336-6d97e072d54e

in case the video does not load, simply press F5 to refresh the github tab so that the video downloads as intended

In the video we can see the EC2 instance hosting the server with various instances of the client running locally, as seen in the video the drawing updates and allows for multiple people drawing at the same time.

https://github.com/Parralol/Lab06ARSW/assets/110953563/664d7a14-1329-4660-9d1d-5fe338c549bb

in this video we test that the delete button works properly

https://github.com/Parralol/Lab06ARSW/assets/110953563/9d18ef29-ee58-404e-b1ad-3f8d30913548

here we can see the client and the server both deployed in EC2.


## Generating javadoc

Simply enter the following commands

```
mvn javadoc:javadoc
```

```
mvn javadoc:jar
```

```
mvn javadoc:aggregate
```

```
mvn javadoc:aggregate-jar
```

```
mvn javadoc:test-javadoc 
```

## Deployment

**IN ORDER FOR THIS PROGRAM TO WORK, YOU'LL NEED TO EXECUTE THE PROGRAM ON THE FOLDER YOU WANT TO WORK WITH, WITH THE FILES YOU WANT TO WORK WITH**

if you want to use the programm after using the package command we use

```
mvn spring-boot:run
```

after the server has initialized, you'll have to use the client to properly see the server working, but even then you can enter to the following URLS to ensure that your server is working properly.

http://localhost:8080/points   --> allows ato see all the stored points

http://localhost:8080/getpoints  --> returns all points in a Json format

http://localhost:8080/status  --> to know if the server is running

http://localhost:8080/setpoints?xval=145&yval=6516 --> minor example of how data is being sent to the server, being xval the X position of the point and yval the Y position of the point.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Java](https://www.oracle.com/java/technologies/) - Programming Language
* [HTML 5](https://html.spec.whatwg.org/multipage/) - HiperText Markup Lenguaje
* [Spring](https://spring.io/) - Framework

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Santiago Parra** - *Initial work* - [Parralol](https://github.com/Parralol)
