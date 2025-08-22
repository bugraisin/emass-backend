package com.emass.emass_backend.model.entity.listing.details;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.enums.LandSubtype;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "land_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LandDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Enumerated(EnumType.STRING)
    @Column(name = "subtype")
    private LandSubtype subtype;

    // Alan bilgileri
    @Column(name = "total_area")
    private Integer totalArea; // m²

    @Column(name = "zoning_status", length = 100)
    private String zoningStatus;

    // Altyapı
    @Column(name = "electricity")
    private Boolean electricity;

    @Column(name = "water")
    private Boolean water;

    @Column(name = "road_access")
    private Boolean roadAccess;

    // Sahiplik
    @Column(name = "title_deed_status", length = 50)
    private String titleDeedStatus;
}
