package com.emass.emass_backend.model.entity.location;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "districts")
@Data
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "name")
    private String name;
}
