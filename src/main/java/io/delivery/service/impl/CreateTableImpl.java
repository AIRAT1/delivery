package io.delivery.service.impl;

import io.delivery.service.CreateTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateTableImpl implements CreateTable {
    private JdbcTemplate jdbcTemplate;

    @Override
    public String createCompany() {
        String preQuery = "DROP TABLE IF EXISTS companies";
        String query = ("CREATE TABLE companies (\n" +
                " code char(5) CONSTRAINT firstkey PRIMARY KEY, \n" +
                " title varchar(40) NOT NULL, \n" +
                " did integer NOT NULL, \n" +
                " date_prod date, \n" +
                " kind varchar(10), \n" +
                " len interval hour to minute\n" +
                ");");
        jdbcTemplate.execute(preQuery);
        jdbcTemplate.execute(query);
        return "table created";
    }
}
