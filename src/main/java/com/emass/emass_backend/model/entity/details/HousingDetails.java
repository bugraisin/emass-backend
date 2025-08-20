package com.emass.emass_backend.model.entity.details;

import com.emass.emass_backend.model.entity.Listing;
import jakarta.persistence.*;
import lombok.*;

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

    // 1-1 ilişki Listing ile
    @OneToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Column(name = "rooms", length = 10)  // "3+1" gibi
    private String rooms;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "total_floors")
    private Integer totalFloors;

    @Column(name = "building_age")
    private Integer buildingAge;

    @Column(name = "is_furnished")
    private Boolean isFurnished;
}
