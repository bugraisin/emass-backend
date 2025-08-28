package com.emass.emass_backend.model.entity.listing.details;

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
public class ServiceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Enumerated(EnumType.STRING)
    @Column(name = "subtype")
    private ServiceSubtype subtype;

    // Temel bilgiler
    @Column(name = "area")
    private Integer area; // Alan (m²)

    @Column(name = "capacity")
    private Integer capacity; // Kapasite/Araç Sayısı

    @Column(name = "space_type", length = 30)
    private String spaceType; // KAPALI, ACIK, YARI_KAPALI, KARISIK

    @Column(name = "deposit")
    private BigDecimal deposit; // Depozito

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

    // Maliyet
    @Column(name = "operating_cost")
    private BigDecimal operatingCost;
}