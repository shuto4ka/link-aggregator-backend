package my.own.linkaggregator;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbstractIntegrationTest {

    public static GenericContainer mongo = new GenericContainer("mongo:4.0.3")
            .withExposedPorts(27017);

    static {
        mongo.start();

        System.setProperty("spring.data.mongodb.host", mongo.getContainerIpAddress());
        System.setProperty("spring.data.mongodb.port", String.valueOf(mongo.getFirstMappedPort()));
    }
}
