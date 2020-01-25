package io.delivery.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@NoArgsConstructor
@AllArgsConstructor
public class CreateTable {
    private JdbcTemplate jdbcTemplate;

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
