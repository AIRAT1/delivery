package io.delivery.service.impl;

import io.delivery.service.CreateTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.log4j.Logger;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateTableImpl implements CreateTable {
    private static final Logger LOG = Logger.getLogger(CreateTableImpl.class);
    private JdbcTemplate jdbcTemplate;

    @Override
    public String createCompany() {
        String preQuery = "DROP TABLE IF EXISTS companies";
        String query = ("CREATE TABLE companies (\n" +
                " id int CONSTRAINT firstkey PRIMARY KEY, \n" +
                " name varchar(255) NOT NULL, \n" +
                " size integer NOT NULL" +
                ");");
        try {
            jdbcTemplate.execute(preQuery);
            jdbcTemplate.execute(query);
        }catch (Exception e) {
            LOG.error("something going wrong " + e);
        }

        return "table created";
    }

    public String delete() {
        return "done";
    }
}
