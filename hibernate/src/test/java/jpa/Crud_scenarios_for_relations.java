package jpa;

import jpa.relation.BarDAO;
import jpa.relation.BarUserInsertRepository;
import jpa.relation.UserDAO;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
@ContextConfiguration(classes = Runner.class)
class Crud_scenarios_for_relations {

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = DbProvider.defaultDb();

    @Autowired
    BarDAO barDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    BarUserInsertRepository barUserInsertRepository;

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> postgreSQLContainer.getJdbcUrl());
        registry.add("spring.datasource.username", () -> postgreSQLContainer.getUsername());
        registry.add("spring.datasource.password", () -> postgreSQLContainer.getPassword());
    }

    @BeforeEach
    void cleanDb() {
        barDAO.deleteAll();
        userDAO.deleteAll();
    }


}
