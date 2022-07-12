import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
@ContextConfiguration(classes = Runner.class, initializers = {Crud_scenarios_spring_context.Initializer.class})
public class Crud_scenarios_spring_context {

    // https://www.baeldung.com/spring-boot-testcontainers-integration-test

    @ClassRule
    public static JdbcDatabaseContainer postgreSQLContainer = DbProvider.defaultDb();

    @Autowired
    AccountInsertRepository accountInsertRepository;

    @Autowired
    AccountReadRepository accountReadRepository;


    @Test
    void create_and_read_simple_entities() {
        accountInsertRepository.insertWithEntityManager(AccountObjectMother.simpleAccount());
        List<Account> actualAccount = accountReadRepository.findAll();
        then(actualAccount).hasSize(1);
        then(actualAccount.get(0)).isEqualTo(AccountObjectMother.simpleAccount());
    }

    @Test
    void create_delete_and_try_to_read_simple_entities() {
    }

    @Test
    void create_read_update_read_simple_entities() {

    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword(),
                    "spring.datasource.driverClassName=org.testcontainers.jdbc.ContainerDatabaseDriver"
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}
