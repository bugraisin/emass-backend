package com.emass.emass_backend.model.entity.details;

import com.emass.emass_backend.model.entity.Listing;
import com.emass.emass_backend.model.entity.enums.WorkplaceSubtype;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "workplace_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkplaceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Enumerated(EnumType.STRING)
    @Column(name = "subtype")
    private WorkplaceSubtype subtype;

    // Temel bilgiler
    @Column(name = "net_area")
    private Integer netArea;

    @Column(name = "floor_no")
    private Integer floorNo;

    @Column(name = "building_age")
    private Integer buildingAge;

    // Temel özellikler
    @Column(name = "furnished")
    private Boolean furnished;

    @Column(name = "parking")
    private Boolean parking;

    @Column(name = "air_conditioning")
    private Boolean airConditioning;

    // İş yeri özel (sadece restaurant/kafe için dolu olur)
    @Column(name = "kitchen")
    private Boolean kitchen;

    @Column(name = "seating_capacity")
    private Integer seatingCapacity;

    // Maliyet
    @Column(name = "maintenance_fee")
    private BigDecimal maintenanceFee;
}