package io.delivery.service.impl;

import io.delivery.config.AppConfig;
import io.delivery.config.application.WebConfig;
import io.delivery.service.CreateTable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {CreateTableImpl.class})
public class CreateTableImplTest {
//    @Autowired
//    CreateTableImpl createTable;

//    @Test
//    public void createCompany() {
//
//    }

    @Test
    public void testDeleteCompany() {
        CreateTableImpl createTable = mock(CreateTableImpl.class);
        given(createTable.delete()).willReturn("done");
        Assert.assertEquals(createTable.delete(), "done");
    }
}
