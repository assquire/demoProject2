package com.example.demoproject2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @SequenceGenerator(name = "my_seq", sequenceName = "my_seq", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    private Long id;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String desc;

    @Column(name = "Created")
    private Date createdAt;

    @Column(name = "Price")
    private int price;

    @Column(name = "Enabled")
    private Boolean isEnabled;

}
