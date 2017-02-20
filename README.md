# SpringBoot_Rest_Docker

This is a simple Rest service application(HTTP GET Request) using Spring Boot and Docker. This application can be run with/without creating a docker container.

##Steps to build and run this application

Download and Unzip the file

Execute the below command from the command line by changing to the project directory(Use Gradle to build the project)
1. ./gradlew build 
then execute the following command
2. java -jar build/libs/gs-spring-boot-docker-0.1.0.jar

3.go to localhost:8080 to check for successful execution

4. go to http://localhost:8080/greeting and it responds with a JSON String as below

{"id":1,"content":"Hi, User"} where 1 indicated the number of persons visited this page till now.

5.Provide a name query string parameter with http://localhost:8080/greeting?name=Spring and observe how the content object cnaged from Hi, User to Hi, Spring.

6. To build the Docker image run the folllowing command after building the Jar from 2nd step

$ ./gradlew build buildDocker  

if the above command doesnt work please execute below command

$ docker run -p 8080:8080 -t springio/gs-spring-boot-docker

7. go to http://localhost:8080/greeting and it responds with a JSON String as below

{"id":1,"content":"Hi, User"} where 1 indicated the number of persons visited this page till now.

8. To check docker containers available plese check with below command

$ docker ps

