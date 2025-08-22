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

    // Alan bilgileri
    @Column(name = "total_area")
    private Integer totalArea;

    @Column(name = "covered_area")
    private Integer coveredArea;

    // Otopark özellikleri
    @Column(name = "vehicle_capacity")
    private Integer vehicleCapacity;

    @Column(name = "cover_type", length = 30)
    private String coverType; // KAPALI, ACIK, YARIMKAPALI

    @Column(name = "height_limit")
    private Integer heightLimit; // cm

    @Column(name = "valet_service")
    private Boolean valetService;

    // Spor salonu özellikleri
    @Column(name = "equipment_included")
    private Boolean equipmentIncluded;

    @Column(name = "changing_room_count")
    private Integer changingRoomCount;

    @Column(name = "shower_count")
    private Integer showerCount;

    @Column(name = "sauna")
    private Boolean sauna;

    // Yıkama özellikleri
    @Column(name = "wash_bay_count")
    private Integer washBayCount;

    @Column(name = "automatic_system")
    private Boolean automaticSystem;

    // Oto servis özellikleri
    @Column(name = "lift_count")
    private Integer liftCount;

    @Column(name = "lift_capacity")
    private Integer liftCapacity; // ton

    @Column(name = "paint_booth")
    private Boolean paintBooth;

    // Benzin istasyonu özellikleri
    @Column(name = "pump_count")
    private Integer pumpCount;

    @Column(name = "fuel_types", length = 100)
    private String fuelTypes;

    @Column(name = "convenience_store")
    private Boolean convenienceStore;

    // Ortak özellikler
    @Column(name = "security")
    private Boolean security;

    @Column(name = "lighting")
    private Boolean lighting;

    // Maliyet
    @Column(name = "operating_cost")
    private BigDecimal operatingCost;
}
