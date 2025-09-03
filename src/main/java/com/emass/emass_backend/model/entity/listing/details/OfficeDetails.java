package com.emass.emass_backend.model.entity.listing.details;

import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.enums.OfficeSubtype;
import com.emass.emass_backend.model.entity.enums.details.HeatingType;
import com.emass.emass_backend.model.entity.enums.details.BuildingType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "office_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor@Builder
public class OfficeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Enumerated(EnumType.STRING)
    @Column(name = "subtype")
    private OfficeSubtype subtype;

    @Column(name = "net_area")
    private Integer netArea;

    @Column(name = "gross_area")
    private Integer grossArea;

    @Column(name = "building_age")
    private String buildingAge;

    @Column(name = "room_count")
    private Integer roomCount;

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

    @Column(name = "elevator")
    private Boolean elevator;

    @Column(name = "security")
    private Boolean security;

    @Column(name = "generator")
    private Boolean generator;

    // Ofis Konfor
    @Column(name = "air_conditioning")
    private Boolean airConditioning;

    @Column(name = "internet")
    private Boolean internet;

    @Column(name = "kitchen")
    private Boolean kitchen;

    @Column(name = "fire_system")
    private Boolean fireSystem;

    // Çalışma Alanları
    @Column(name = "reception")
    private Boolean reception;

    @Column(name = "waiting_area")
    private Boolean waitingArea;

    @Column(name = "meeting_room")
    private Boolean meetingRoom;

    @Column(name = "archive")
    private Boolean archive;

    @Column(name = "library")
    private Boolean library;

    // Teknik Altyapı
    @Column(name = "server_room")
    private Boolean serverRoom;

    @Column(name = "access_control")
    private Boolean accessControl;

    @Column(name = "fiber_internet")
    private Boolean fiberInternet;

    @Column(name = "soundproof")
    private Boolean soundproof;
}