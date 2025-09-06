package com.emass.emass_backend.model.entity.listing.details;

import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.enums.IndustrialSubtype;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "industrial_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IndustrialDetails implements PropertyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Enumerated(EnumType.STRING)
    @Column(name = "subtype")
    private IndustrialSubtype subtype;

    // Temel bilgiler
    @Column(name = "net_area")
    private Integer netArea;

    @Column(name = "gross_area")
    private Integer grossArea;

    @Column(name = "building_age", length = 30)
    private String buildingAge;

    @Column(name = "room_count")
    private Integer roomCount;

    @Column(name = "floor_count")
    private Integer floorCount;

    @Column(name = "ceiling_height")
    private BigDecimal ceilingHeight;

    @Column(name = "deposit")
    private BigDecimal deposit;

    // Altyapı & Enerji
    @Column(name = "threephase_electricity")
    private Boolean threephaseElectricity;

    @Column(name = "natural_gas_line")
    private Boolean naturalGasLine;

    @Column(name = "steam_line")
    private Boolean steamLine;

    @Column(name = "water_system")
    private Boolean waterSystem;

    @Column(name = "waste_water_system")
    private Boolean wasteWaterSystem;

    // Üretim & İmalat
    @Column(name = "crane_system")
    private Boolean craneSystem;

    @Column(name = "ventilation_system")
    private Boolean ventilationSystem;

    @Column(name = "air_conditioning")
    private Boolean airConditioning;

    @Column(name = "wide_open_area")
    private Boolean wideOpenArea;

    @Column(name = "machine_mounting_suitable")
    private Boolean machineMountingSuitable;

    // Depolama & Lojistik
    @Column(name = "loading_ramp")
    private Boolean loadingRamp;

    @Column(name = "truck_entrance")
    private Boolean truckEntrance;

    @Column(name = "forklift_traffic")
    private Boolean forkliftTraffic;

    @Column(name = "racking_system")
    private Boolean rackingSystem;

    @Column(name = "cold_storage")
    private Boolean coldStorage;

    // Güvenlik & Sistem
    @Column(name = "fire_extinguishing_system")
    private Boolean fireExtinguishingSystem;

    @Column(name = "security_cameras")
    private Boolean securityCameras;

    @Column(name = "alarm_system")
    private Boolean alarmSystem;

    @Column(name = "fenced_area")
    private Boolean fencedArea;

    @Column(name = "security")
    private Boolean security;
}