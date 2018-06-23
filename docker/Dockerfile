FROM java:10
ADD build/libs/link-aggregator-build.jar link-aggregator-backend.jar
ADD config/aws/application.properties application.properties
EXPOSE 8080
CMD java -jar link-aggregator-backend.jar --spring.config.location=file:application.properties