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
public class IndustrialDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Enumerated(EnumType.STRING)
    @Column(name = "subtype")
    private IndustrialSubtype subtype;

    // Alan bilgileri
    @Column(name = "total_area")
    private Integer totalArea;

    @Column(name = "covered_area")
    private Integer coveredArea;

    @Column(name = "building_age")
    private Integer buildingAge;

    @Column(name = "ceiling_height")
    private Integer ceilingHeight;

    // Teknik özellikler
    @Column(name = "power_capacity")
    private Integer powerCapacity; // kW

    @Column(name = "crane")
    private Boolean crane;

    @Column(name = "crane_capacity")
    private Integer craneCapacity; // ton

    // Lojistik özellikler
    @Column(name = "loading_dock")
    private Boolean loadingDock;

    @Column(name = "loading_dock_count")
    private Integer loadingDockCount;

    @Column(name = "truck_access")
    private Boolean truckAccess;

    // Depo özellikleri
    @Column(name = "cold_storage")
    private Boolean coldStorage;

    @Column(name = "temperature_range", length = 50)
    private String temperatureRange;

    // Fabrika özellikleri
    @Column(name = "production_line_count")
    private Integer productionLineCount;

    @Column(name = "laboratory")
    private Boolean laboratory;

    @Column(name = "office_area")
    private Integer officeArea;

    // Güvenlik
    @Column(name = "fire_system")
    private Boolean fireSystem;

    @Column(name = "security")
    private Boolean security;

    // Maliyet
    @Column(name = "operating_cost")
    private BigDecimal operatingCost;
}