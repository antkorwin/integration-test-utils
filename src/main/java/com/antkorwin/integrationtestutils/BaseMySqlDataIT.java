package com.antkorwin.integrationtestutils;

import org.springframework.test.context.TestPropertySource;

/**
 * Created on 14.07.2018.
 * <p>
 * Run MySQL docker container for a testing DataJpa layer
 * <p>
 * Run only the JPA context!
 * Does not load entire context configuration!
 *
 * @author Korovin Anatoliy
 */
@TestPropertySource(properties = {"spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver",
                                  "spring.datasource.type=com.zaxxer.hikari.HikariDataSource",
                                  "spring.datasource.username=user",
                                  "spring.datasource.password=password",
                                  "spring.datasource.url=jdbc:tc:mysql://somehostname:port/databasename",
                                  "spring.jpa.generate-ddl=true",
                                  "spring.jpa.hibernate.ddl-auto=create-drop",
                                  "spring.jpa.show-sql=true",
                                  "spring.jpa.properties.hibernate.hbm2ddl.auto=create-drop",
                                  "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect"})
public abstract class BaseMySqlDataIT extends BaseDataIT {

}
