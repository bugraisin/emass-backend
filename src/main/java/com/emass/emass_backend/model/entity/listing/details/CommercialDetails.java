package com.emass.emass_backend.model.entity.listing.details;

import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.enums.CommercialSubtype;
import com.emass.emass_backend.model.entity.enums.details.HeatingType;
import com.emass.emass_backend.model.entity.enums.details.BuildingType;
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

    @Column(name = "gross_area")
    private Integer grossArea;

    @Column(name = "building_age")
    private String buildingAge;

    @Column(name = "floor_no")
    private Integer floorNo;

    @Column(name = "floor_count")
    private Integer floorCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "heating_type")
    private HeatingType heatingType;

    @Column(name = "site_fee")
    private BigDecimal siteFee;

    @Column(name = "deposit")
    private BigDecimal deposit;

    @Enumerated(EnumType.STRING)
    @Column(name = "building_type")
    private BuildingType buildingType;

    // Temel Özellikler
    @Column(name = "furnished")
    private Boolean furnished;

    @Column(name = "parking")
    private Boolean parking;

    @Column(name = "security")
    private Boolean security;

    @Column(name = "elevator")
    private Boolean elevator;

    @Column(name = "generator")
    private Boolean generator;

    // Konfor & Sistem
    @Column(name = "air_conditioning")
    private Boolean airConditioning;

    @Column(name = "internet")
    private Boolean internet;

    @Column(name = "kitchen")
    private Boolean kitchen;

    @Column(name = "toilet")
    private Boolean toilet;

    // Ticari Özel Alanlar
    @Column(name = "showcase")
    private Boolean showcase;

    @Column(name = "warehouse")
    private Boolean warehouse;

    @Column(name = "loading_dock")
    private Boolean loadingDock;

    @Column(name = "cash_register")
    private Boolean cashRegister;

    // Müşteri Alanları
    @Column(name = "outdoor_seating")
    private Boolean outdoorSeating;

    @Column(name = "waiting_area")
    private Boolean waitingArea;

    @Column(name = "changing_room")
    private Boolean changingRoom;
}