package com.emass.emass_backend.model.entity.details;

import com.emass.emass_backend.model.entity.Listing;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "workplace_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkplaceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Column(name = "area_m2")
    private Integer areaM2;

    @Column(name = "has_parking")
    private Boolean hasParking;

    @Column(name = "is_furnished")
    private Boolean isFurnished;
}
