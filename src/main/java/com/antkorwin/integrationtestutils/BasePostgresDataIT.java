package com.antkorwin.integrationtestutils;


import org.springframework.test.context.TestPropertySource;

/**
 * Created by Korovin A. on 20.11.2017.
 * <p>
 * Run PostgresSQL docker container for testing DataJpa layer
 * <p>
 * Run only JPA context!
 * Does not load entire context configuration!
 *
 * @author Korovin Anatoliy
 * @version 1.0
 */
@TestPropertySource(properties = {"spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver",
                                  "spring.datasource.type=com.zaxxer.hikari.HikariDataSource",
                                  "spring.datasource.username=user",
                                  "spring.datasource.password=password",
                                  "spring.datasource.url=jdbc:tc:postgresql://hostname/databasename",
                                  "spring.jpa.generate-ddl=true",
                                  "spring.jpa.hibernate.ddl-auto=create-drop",
                                  "spring.jpa.show-sql=true",
                                  "spring.jpa.properties.hibernate.hbm2ddl.auto=create-drop",
                                  "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect"})
public abstract class BasePostgresDataIT extends BaseDataIT {

}