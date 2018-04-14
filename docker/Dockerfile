FROM java:9
ADD build/libs/link-aggregator-backend.jar link-aggregator-backend.jar
ADD config/aws/application.properties application.properties
EXPOSE 8080
CMD java -jar link-aggregator-backend.jar --spring.config.location=file:application.properties