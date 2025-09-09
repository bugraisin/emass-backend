package com.emass.emass_backend.model.entity.listing.details;

import com.emass.emass_backend.model.entity.enums.details.land.TitleLandDeedStatus;
import com.emass.emass_backend.model.entity.enums.details.land.ZoningStatus;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.enums.LandSubtype;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "land_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LandDetails implements PropertyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Enumerated(EnumType.STRING)
    @Column(name = "subtype")
    private LandSubtype subtype;

    // Temel bilgiler
    @Column(name = "land_area")
    private Integer landArea;

    @Enumerated(EnumType.STRING)
    @Column(name = "zoning_status")
    private ZoningStatus zoningStatus;

    @Column(name = "ada_no")
    private Integer adaNo;

    @Column(name = "parcel_no")
    private Integer parcelNo;

    @Column(name = "pafta_no")
    private String paftaNo;

    @Column(name = "kaks")
    private BigDecimal kaks;

    @Column(name = "gabari")
    private BigDecimal gabari;

    @Enumerated(EnumType.STRING)
    @Column(name = "title_land_deed_status")
    private TitleLandDeedStatus titleLandDeedStatus;

    // Altyapı
    @Column(name = "electricity")
    private Boolean electricity;

    @Column(name = "water")
    private Boolean water;

    @Column(name = "natural_gas")
    private Boolean naturalGas;

    @Column(name = "sewerage")
    private Boolean sewerage;

    @Column(name = "road_access")
    private Boolean roadAccess;

    // Konum & Manzara
    @Column(name = "corner_lot")
    private Boolean cornerLot;

    @Column(name = "sea_view")
    private Boolean seaView;

    @Column(name = "city_view")
    private Boolean cityView;

    @Column(name = "forest_view")
    private Boolean forestView;

    @Column(name = "mountain_view")
    private Boolean mountainView;

    // Arazi Özellikler
    @Column(name = "flat")
    private Boolean flat;

    @Column(name = "slope")
    private Boolean slope;

    @Column(name = "fenced")
    private Boolean fenced;

    @Column(name = "agricultural")
    private Boolean agricultural;

    @Column(name = "building_permit")
    private Boolean buildingPermit;

    // Tarım & Bahçe
    @Column(name = "vineyard")
    private Boolean vineyard;

    @Column(name = "orchard")
    private Boolean orchard;

    @Column(name = "olive_trees")
    private Boolean oliveTrees;

    @Column(name = "greenhouse")
    private Boolean greenhouse;

    @Column(name = "well")
    private Boolean well;
}