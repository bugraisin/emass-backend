package com.emass.emass_backend.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "neighborhoods")
@Data
public class Neighborhood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "subdistrict_id")
    private Long subdistrictId;

    @Column(name = "postal_code")
    private String postalCode;

}
