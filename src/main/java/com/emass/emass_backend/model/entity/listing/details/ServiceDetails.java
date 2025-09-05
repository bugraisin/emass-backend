package com.emass.emass_backend.model.entity.listing.details;

import com.emass.emass_backend.model.entity.enums.details.SpaceType;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.enums.ServiceSubtype;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "service_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDetails implements PropertyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Enumerated(EnumType.STRING)
    @Column(name = "subtype")
    private ServiceSubtype subtype;

    @Column(name = "net_area")
    private Integer netArea;

    @Column(name = "gross_area")
    private Integer grossArea;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "space_type")
    private SpaceType spaceType;

    @Column(name = "deposit")
    private BigDecimal deposit;

    // Temel Altyapı
    @Column(name = "security")
    private Boolean security;

    @Column(name = "lighting")
    private Boolean lighting;

    @Column(name = "cctv")
    private Boolean cctv;

    @Column(name = "internet")
    private Boolean internet;

    // Hizmet Alanları
    @Column(name = "reception")
    private Boolean reception;

    @Column(name = "rest_room")
    private Boolean restRoom;

    @Column(name = "kitchen")
    private Boolean kitchen;

    // Teknik Donanım
    @Column(name = "washing_area")
    private Boolean washingArea;

    @Column(name = "maintenance_area")
    private Boolean maintenanceArea;

    @Column(name = "air_conditioning")
    private Boolean airConditioning;

    @Column(name = "ventilation_system")
    private Boolean ventilationSystem;

    // Ek Hizmetler
    @Column(name = "storage")
    private Boolean storage;

    @Column(name = "office_area")
    private Boolean officeArea;

    @Column(name = "customer_parking")
    private Boolean customerParking;

}