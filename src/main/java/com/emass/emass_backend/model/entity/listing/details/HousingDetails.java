package com.emass.emass_backend.model.entity.listing.details;

import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.enums.HeatingType;
import com.emass.emass_backend.model.entity.enums.HousingSubtype;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "housing_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HousingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Enumerated(EnumType.STRING)
    @Column(name = "subtype", nullable = false)
    private HousingSubtype subtype;

    // Temel bilgiler
    @Column(name = "room_plan", length = 10)
    private String roomPlan;

    @Column(name = "net_area")
    private Integer netArea;

    @Column(name = "floor_no")
    private Integer floorNo;

    @Column(name = "total_floors")
    private Integer totalFloors;

    @Column(name = "building_age")
    private Integer buildingAge;

    // Özellikler
    @Column(name = "furnished")
    private Boolean furnished;

    @Column(name = "balcony")
    private Boolean balcony;

    @Column(name = "parking")
    private Boolean parking;

    @Enumerated(EnumType.STRING)
    @Column(name = "heating_type")
    private HeatingType heatingType;

    // Site bilgisi
    @Column(name = "site_name", length = 100)
    private String siteName;

    @Column(name = "site_fee")
    private BigDecimal siteFee;
}
