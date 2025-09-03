package com.emass.emass_backend.model.entity.listing.details;

import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.enums.details.HeatingType;
import com.emass.emass_backend.model.entity.enums.HousingSubtype;
import com.emass.emass_backend.model.entity.enums.details.FacadeDirection;
import com.emass.emass_backend.model.entity.enums.details.TitleDeedStatus;
import com.emass.emass_backend.model.entity.enums.details.UsageStatus;
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
    @Column(name = "room_count")
    private String roomCount;

    @Column(name = "gross_area")
    private Integer grossArea;

    @Column(name = "net_area")
    private Integer netArea;

    @Column(name = "floor_no")
    private Integer floorNo;

    @Column(name = "total_floors")
    private Integer totalFloors;

    @Column(name = "building_age")
    private String buildingAge;

    // Sayısal özellikler
    @Column(name = "bathroom_count")
    private Integer bathroomCount;

    // Enum özellikler
    @Enumerated(EnumType.STRING)
    @Column(name = "heating_type")
    private HeatingType heatingType;

    @Enumerated(EnumType.STRING)
    @Column(name = "facade_direction")
    private FacadeDirection facadeDirection;

    @Enumerated(EnumType.STRING)
    @Column(name = "title_deed_status")
    private TitleDeedStatus titleDeedStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "usage_status")
    private UsageStatus usageStatus;

    // Site bilgileri
    @Column(name = "site_name")
    private String siteName;

    @Column(name = "site_fee")
    private BigDecimal siteFee;

    @Column(name = "deposit")
    private BigDecimal deposit;

    // Temel Özellikler
    @Column(name = "furnished")
    private Boolean furnished;

    @Column(name = "balcony")
    private Boolean balcony;

    @Column(name = "terrace")
    private Boolean terrace;

    @Column(name = "garden")
    private Boolean garden;

    @Column(name = "within_site")
    private Boolean withinSite;

    // Otopark
    @Column(name = "open_park")
    private Boolean openPark;

    @Column(name = "closed_park")
    private Boolean closedPark;

    @Column(name = "garage_park")
    private Boolean garagePark;

    // Bina & Güvenlik
    @Column(name = "elevator")
    private Boolean elevator;

    @Column(name = "security")
    private Boolean security;

    @Column(name = "concierge")
    private Boolean concierge;

    @Column(name = "generator")
    private Boolean generator;

    // Konfor & Isıtma
    @Column(name = "air_conditioning")
    private Boolean airConditioning;

    @Column(name = "floor_heating")
    private Boolean floorHeating;

    @Column(name = "fireplace")
    private Boolean fireplace;

    // Mutfak & İç Mekan
    @Column(name = "builtin_kitchen")
    private Boolean builtinKitchen;

    @Column(name = "separate_kitchen")
    private Boolean separateKitchen;

    @Column(name = "american_kitchen")
    private Boolean americanKitchen;

    @Column(name = "laundry_room")
    private Boolean laundryRoom;

    // Site İmkanları
    @Column(name = "pool")
    private Boolean pool;

    @Column(name = "gym")
    private Boolean gym;

    @Column(name = "children_playground")
    private Boolean childrenPlayground;

    @Column(name = "sports_area")
    private Boolean sportsArea;
}