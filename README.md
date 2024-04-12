# Spring Rest Michelli Brito 2022
This application is a Java REST backend for a parking control system. Parking CRUD
- API
   - https://jvrss.tplinkdns.com:32000/swagger-ui/index.html

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
-e DB_SERVER= \
-e DB_PORT=3306 \
-e DB_NAME= \
-e DB_USERNAME= \
-e DB_PASSWORD= \
-e KEY_STORE_NAME= \
-e KEY_STORE_PASSWORD= \
-e KEY_STORE_ALIAS= \
-d soldierjvx/parking_control_db:latest

Where:
 - DB_SERVER: IP from MYSQL server
 - DB_NAME: Name of database in MYSQL
 - DB_USERNAME: Database username
 - DB_PASSWORD: Database password
 - KEY_STORE_NAME: Name of Key Store File
 - KEY_STORE_PASSWORD: Password Keystore
 - KEY_STORE_ALIAS: Alias Key Store

# How to use
Through the web interface, manage parking lots such as:
- List parking
- Search for a parking lot
- Register a parking lot
- Update a parking lot
- Delete a parking lot

# Links
 - API
   - https://jvrss.tplinkdns.com:32000/swagger-ui/index.html
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
1.1.0

# Authors
 - João Vitor Ramos de Souza Silva

Please follow github and join us! Thanks to visiting me and good coding!
