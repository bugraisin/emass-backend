package com.emass.emass_backend.model.entity.details;
import com.emass.emass_backend.model.entity.Listing;
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

    @Column(name = "zoning_status", length = 100) // imar durumu
    private String zoningStatus;

    @Column(name = "parcel_no")
    private String parcelNo;

    @Column(name = "land_area_m2")
    private Integer landAreaM2;
}
