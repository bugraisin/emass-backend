package com.emass.emass_backend.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "provinces")
@Data
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment id ise
    private Long id;

    @Column(name = "name")
    private String name;
}
