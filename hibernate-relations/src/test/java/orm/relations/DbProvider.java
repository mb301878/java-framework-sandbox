package orm.relations;

import org.testcontainers.containers.PostgreSQLContainer;

class DbProvider {

    static PostgreSQLContainer defaultDb() {
        PostgreSQLContainer db = new PostgreSQLContainer<>("postgres:11.1")
                .withDatabaseName("itsb")
                .withInitScript("init.sql")
                .withUsername("user")
                .withPassword("pass");
        db.start();
        db.getJdbcDriverInstance();
        return db;

    }
}
