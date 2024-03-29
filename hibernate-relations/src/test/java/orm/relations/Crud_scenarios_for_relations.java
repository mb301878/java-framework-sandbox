package orm.relations;

import orm.relations.transaction.BarUserTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Set;

import static org.assertj.core.api.BDDAssertions.then;

@Testcontainers
@SpringBootTest
@ContextConfiguration(classes = Runner.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
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

    @Test
    void save_and_read_users_and_bar() {
        BarUserTransaction transaction = BarUserTransaction
                .builder()
                .bar(10)
                .users(Set.of(1, 2, 3))
                .build();

        barUserInsertRepository.insert(transaction);

        then(userDAO.getBarByIdd(1L).getUserId()).isEqualTo(1L);
        then(userDAO.getBarByIdd(2L).getUserId()).isEqualTo(2L);
        then(userDAO.getBarByIdd(3L).getUserId()).isEqualTo(3L);
        then(barDAO.getBarByIdd(10L).getBarId()).isEqualTo(10L);
    }
}
