package io.delivery.config.application;

import io.delivery.service.CreateTable;
import io.delivery.service.impl.CreateTableImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = {"classpath:util.properties"})
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.posthresql.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.posthresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.posthresql.username"));
        dataSource.setPassword(environment.getProperty("jdbc.posthresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public CreateTable table() {
        return new CreateTableImpl(jdbcTemplate());
    }
}
