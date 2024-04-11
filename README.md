# Spring Rest Michelli Brito 2022
This application is a Java REST backend for a parking control system. Parking CRUD
- API
   - http://jvrss.tplinkdns.com:32000/swagger-ui/index.html

![image link](http://i3.ytimg.com/vi/LXRU-Z36GEU/hqdefault.jpg)

Code developed in the video:\
https://www.youtube.com/watch?v=LXRU-Z36GEU

# Technology
Here are the technologies used in this project.
 - Java 21
 - Spring Web
 - Spring JPA
 - Spring Validation
 - Lombok
 - Mysql
 - Swagger
 - Docker

# Services Used
 - Github

# Getting started
 - Dependency
   - Docker
 - To build the container:
> sudo docker build \
   -t soldierjvx/parking_control_db .
 - To run the container:
> docker run --name parking_control \
-p 32000:8080 \
-e DB_SERVER=<ip-dabatabase> \
-e DB_PORT=3306 \
-e DB_NAME=<db-name> \
-e DB_USERNAME=<db-username> \
-e DB_PASSWORD=<db-password> \
-d soldierjvx/parking_control_db:latest

Where:
 - <ip-dabatabase>: IP from MYSQL server
 - <db-name>: Name of database in MYSQL
 - <db-username>: Database username
 - <db-password>: Database password

# How to use
Through the web interface, manage parking lots such as:
- List parking
- Search for a parking lot
- Register a parking lot
- Update a parking lot
- Delete a parking lot

# Links
 - API
   - http://jvrss.tplinkdns.com:32000/swagger-ui/index.html
 - Repository
   - https://github.com/jvrss/spring-rest-michelli-brito-2022
     - In case of sensitive bugs like security vulnerabilities, please contact me directly instead of using issue tracker. We value your effort to improve the security and privacy of this project!

# Features
The main features of the application are:
 - List All Parking Spots
 - Get One Parking Spot
 - Save Parking Spot
 - Delete Parking Spot
 - Update Parking Spot

# Versioning
1.0.0

# Authors
 - João Vitor Ramos de Souza Silva

Please follow github and join us! Thanks to visiting me and good coding!
