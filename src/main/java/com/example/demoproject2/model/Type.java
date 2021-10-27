package com.example.demoproject2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Type {

    @Id
    @SequenceGenerator(name = "my_type_seq", sequenceName = "my_type_seq", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_type_seq")
    private Long id;

    @Column(name = "Type")
    private String name;

}
