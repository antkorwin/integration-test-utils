package com.antkorwin.integrationtestutils;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created on 16.07.2018.
 *
 * Base abstract test for an Integration testing
 * with REST API level, but without DB level.
 *
 * @author Korovin Anatoliy
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public abstract class BaseRestIT {

    @Autowired
    protected MockMvc mockMvc;

    protected ObjectMapper mapper = new ObjectMapper();
}
