#Creating the Cent OS docker image having java
FROM java:7
#Let's volume mount the tmp dir
VOLUME /tmp
#Adding/ copying the jar to docker
ADD gs-spring-boot-docker-0.1.0.jar app.jar
#Giving the jar permission to all
RUN sh -c 'chmod 777 /app.jar'
#Checking the jar permission
RUN sh -c 'touch /app.jar'
#THis is the Entrypoint as soon the docker starts
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
