package com.antkorwin.integrationtestutils;

import org.springframework.test.context.TestPropertySource;

/**
 * Created on 14.07.2018.
 * <p>
 * Run an entire application context,
 * with MySQL bindings to making integration tests with docker
 * (by test-containers)
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
                                  "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect",
                                  // tracing:
                                  "spring.jpa.properties.hibernate.type=trace",
                                  "spring.jpa.properties.hibernate.format_sql=true",
                                  "spring.jpa.properties.hibernate.use_sql_comments=true",
                                  "logging.level.org.hibernate.type.descriptor.sql=trace",
                                  // sql assert:
                                  "spring.jpa.properties.hibernate.session_factory.statement_inspector=com.antkorwin.integrationtestutils.sqltracker.StatementInspectorImpl"})
public abstract class BaseMySqlIT extends BaseIT {
}
