package com.emass.emass_backend.model.entity.listing.details;

import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.enums.OfficeSubtype;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "office_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    // Temel bilgiler
    @Column(name = "net_area")
    private Integer netArea;

    @Column(name = "floor_no")
    private Integer floorNo;

    @Column(name = "building_age")
    private Integer buildingAge;

    // Oda yapısı
    @Column(name = "room_count")
    private Integer roomCount;

    @Column(name = "meeting_room_count")
    private Integer meetingRoomCount;

    // Özellikler
    @Column(name = "furnished")
    private Boolean furnished;

    @Column(name = "air_conditioning")
    private Boolean airConditioning;

    @Column(name = "parking")
    private Boolean parking;

    // İş merkezi özellikleri
    @Column(name = "business_center", length = 100)
    private String businessCenter;

    @Column(name = "reception")
    private Boolean reception;

    // Coworking özellikleri
    @Column(name = "desk_count")
    private Integer deskCount;

    @Column(name = "private_office_count")
    private Integer privateOfficeCount;

    // Call center özellikleri
    @Column(name = "workstation_count")
    private Integer workstationCount;

    @Column(name = "sound_isolation")
    private Boolean soundIsolation;

    // Maliyet
    @Column(name = "maintenance_fee")
    private BigDecimal maintenanceFee;

    @Column(name = "internet_included")
    private Boolean internetIncluded;
}