package io.delivery.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="companies")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


    private String title;
}
