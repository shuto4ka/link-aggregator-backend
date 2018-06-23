FROM openjdk:10-slim
ADD build/libs/link-aggregator-backend-VERSION.jar link-aggregator-backend.jar
ADD config/aws/application.properties application.properties
EXPOSE 8080
CMD java -jar link-aggregator-backend.jar --spring.config.location=file:application.properties