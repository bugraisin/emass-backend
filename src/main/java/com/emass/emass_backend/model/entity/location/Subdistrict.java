package com.emass.emass_backend.model.entity.location;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "subdistricts")
@Data
public class Subdistrict {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "district_id")
    private Long districtId;

}
