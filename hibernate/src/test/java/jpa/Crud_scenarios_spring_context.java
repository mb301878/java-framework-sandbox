package jpa;

import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static jpa.AccountObjectMother.simpleAccount;
import static jpa.AccountObjectMother.simpleAccountUpdated;
import static org.assertj.core.api.BDDAssertions.then;

@Testcontainers
@SpringBootTest
@ContextConfiguration(classes = Runner.class, initializers = {Crud_scenarios_spring_context.Initializer.class})
public class Crud_scenarios_spring_context {

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = DbProvider.defaultDb();

    @Autowired
    AccountInsertRepository accountInsertRepository;

    @Autowired
    AccountDAO accountDAO;

    @BeforeEach
    void cleanDb() {
        // bad practise, I have to check with dynamic properties
        accountDAO.deleteAll();
    }

    @Test
    void create_and_read_simple_entities() {
        accountInsertRepository.insertWithEntityManager(simpleAccount());
        List<Account> actualAccount = accountDAO.findAll();
        then(actualAccount).hasSize(1);
        then(actualAccount.get(0)).isEqualTo(simpleAccount());
    }

    @Test
    void create_and_read_simple_entities_second_approach() {
        accountInsertRepository.insertWithQuery(simpleAccount());
        List<Account> actualAccount = accountDAO.findAll();
        then(actualAccount).hasSize(1);
        then(actualAccount.get(0)).isEqualTo(simpleAccount());
    }

    @Test
    void create_delete_and_try_to_read_simple_entities() {
        accountInsertRepository.insertWithEntityManager(simpleAccount());
        accountDAO.delete(simpleAccount());
        List<Account> actualAccount = accountDAO.findAll();
        then(actualAccount).isEmpty();
    }

    @Test
    void create_read_update_read_simple_entities() {
        accountInsertRepository.insertWithEntityManager(simpleAccount());
        accountDAO.save(simpleAccountUpdated());
        List<Account> actualAccount = accountDAO.findAll();
        then(actualAccount).hasSize(1);
        then(actualAccount.get(0)).isEqualTo(simpleAccountUpdated());
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}
