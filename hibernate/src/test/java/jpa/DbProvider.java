package jpa;

import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.time.Duration;

class DbProvider {

    static PostgreSQLContainer defaultDb() {
        PostgreSQLContainer db = new PostgreSQLContainer<>("postgres:11.1")
                .withDatabaseName("itsb")
                .withInitScript("init.sql")
                .withUsername("user")
                .withPassword("pass")
                ;
        db.start();
        db.getJdbcDriverInstance();
        return db;


    }
}
