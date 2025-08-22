package com.emass.emass_backend.model.entity.listing.details;

import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.enums.CommercialSubtype;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "commercial_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommercialDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Enumerated(EnumType.STRING)
    @Column(name = "subtype")
    private CommercialSubtype subtype;

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

    @Column(name = "air_conditioning")
    private Boolean airConditioning;

    @Column(name = "parking")
    private Boolean parking;

    // Vitrin özellikleri (dükkan, mağaza için)
    @Column(name = "showcase")
    private Boolean showcase;

    @Column(name = "street_frontage")
    private Integer streetFrontage; // metre

    // Restaurant/Kafe özellikleri
    @Column(name = "kitchen")
    private Boolean kitchen;

    @Column(name = "seating_capacity")
    private Integer seatingCapacity;

    @Column(name = "outdoor_seating")
    private Boolean outdoorSeating;

    @Column(name = "liquor_license")
    private Boolean liquorLicense;

    // Güzellik salonu özellikleri
    @Column(name = "treatment_room_count")
    private Integer treatmentRoomCount;

    @Column(name = "waiting_area")
    private Boolean waitingArea;

    // Maliyet
    @Column(name = "maintenance_fee")
    private BigDecimal maintenanceFee;
}