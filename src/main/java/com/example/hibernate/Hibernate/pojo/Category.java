package com.example.hibernate.Hibernate.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categoy")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
    // no need to create the column bc
    // the newest version can auto generated
    private int id;
//    @Column(name="name", length = 100, nullable = false)
    private String name;
//    @Column(name="description")
    private String description;
}
