package com.antkorwin.integrationtestutils;

import org.springframework.test.context.TestPropertySource;

/**
 * Created by Korovin Anatolii on 14.07.2018.
 * <p>
 * Run an entire application context,
 * with PostgreSQL bindings to making integration tests with docker
 * (by test-containers)
 *
 * @author Korovin Anatolii
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
                                  "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect",
                                  // tracing:
                                  "spring.jpa.properties.hibernate.type=trace",
                                  "spring.jpa.properties.hibernate.format_sql=true",
                                  "spring.jpa.properties.hibernate.use_sql_comments=true",
                                  "logging.level.org.hibernate.type.descriptor.sql=trace",
                                  // sql assert:
                                  "spring.jpa.properties.hibernate.session_factory.statement_inspector=com.antkorwin.integrationtestutils.sqltracker.StatementInspectorImpl"})
public class BasePostgresIT extends BaseIT {
}
