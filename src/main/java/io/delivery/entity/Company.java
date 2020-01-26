package io.delivery.entity;

import lombok.Data;

//@Entity
//@Table(name="companies")
@Data
public class Company {
    private int id;
    private String title;
//    @Id
//    @GeneratedValue(strategy=GenerationType.Auto)
//    private int id;
}
