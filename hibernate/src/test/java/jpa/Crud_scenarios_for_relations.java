package jpa;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
@ContextConfiguration(classes = Runner.class)
class Crud_scenarios_for_relations {

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = DbProvider.defaultDb();


}
