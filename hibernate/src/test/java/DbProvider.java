import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;

class DbProvider {

    static JdbcDatabaseContainer defaultDb() {
        JdbcDatabaseContainer db = new PostgreSQLContainer("postgres:11.1")
                .withDatabaseName("itsb")
                .withUsername("user")
                .withPassword("pass")
                .withInitScript("init.sql");
        db.start();
        db.getJdbcDriverInstance();
        return db;
    }
}
