package com.antkorwin.integrationtestutils;
import com.github.database.rider.core.DBUnitRule;
import org.assertj.core.api.Assertions;
import org.junit.AfterClass;
import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created on 27.11.2017.
 *
 * инициализация правила для работы DatabaseRider'а
 *
 * @author Korovin Anatoliy
 */
public abstract class BaseDataBaseRiderIT {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Connection instance = null;

    @Rule
    public DBUnitRule dbUnitRule = DBUnitRule.instance(() -> {
        // Пока не пофиксили в DatabaseRider'е, боремся руками с connection leak
        return (instance != null) ? instance : getConnectionInst();
    });

    @Override
    protected void finalize() throws Throwable {
        if (instance != null) {
            instance.close();
            instance = null;
        }
        super.finalize();
    }

    private Connection getConnectionInst() {
        try {
            instance = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            Assertions.fail("Error: get database connection");
        }
        return instance;
    }
}
