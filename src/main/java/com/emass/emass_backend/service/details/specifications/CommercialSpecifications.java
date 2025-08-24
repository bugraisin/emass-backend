package com.emass.emass_backend.service.details.specifications;

import com.emass.emass_backend.model.dto.listing.details.search.CommercialSearchRequest;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.CommercialDetails;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CommercialSpecifications {

    public static Specification<CommercialDetails> filterByRequest(CommercialSearchRequest request) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 1. CommercialDetails alanları
            if(request.subtype() != null)
                predicates.add(cb.equal(root.get("subtype"), request.subtype()));
            if(request.minNetArea() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("netArea"), request.minNetArea()));
            if(request.maxNetArea() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("netArea"), request.maxNetArea()));
            if(request.floorNo() != null)
                predicates.add(cb.equal(root.get("floorNo"), request.floorNo()));
            if(request.minBuildingAge() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("buildingAge"), request.minBuildingAge()));
            if(request.maxBuildingAge() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("buildingAge"), request.maxBuildingAge()));
            if(request.furnished() != null)
                predicates.add(cb.equal(root.get("furnished"), request.furnished()));
            if(request.airConditioning() != null)
                predicates.add(cb.equal(root.get("airConditioning"), request.airConditioning()));
            if(request.parking() != null)
                predicates.add(cb.equal(root.get("parking"), request.parking()));
            if(request.showcase() != null)
                predicates.add(cb.equal(root.get("showcase"), request.showcase()));
            if(request.minStreetFrontage() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("streetFrontage"), request.minStreetFrontage()));
            if(request.maxStreetFrontage() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("streetFrontage"), request.maxStreetFrontage()));
            if(request.kitchen() != null)
                predicates.add(cb.equal(root.get("kitchen"), request.kitchen()));
            if(request.minSeatingCapacity() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("seatingCapacity"), request.minSeatingCapacity()));
            if(request.maxSeatingCapacity() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("seatingCapacity"), request.maxSeatingCapacity()));
            if(request.outdoorSeating() != null)
                predicates.add(cb.equal(root.get("outdoorSeating"), request.outdoorSeating()));
            if(request.liquorLicense() != null)
                predicates.add(cb.equal(root.get("liquorLicense"), request.liquorLicense()));
            if(request.minTreatmentRoomCount() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("treatmentRoomCount"), request.minTreatmentRoomCount()));
            if(request.maxTreatmentRoomCount() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("treatmentRoomCount"), request.maxTreatmentRoomCount()));
            if(request.waitingArea() != null)
                predicates.add(cb.equal(root.get("waitingArea"), request.waitingArea()));
            if(request.minMaintenanceFee() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("maintenanceFee"), request.minMaintenanceFee()));
            if(request.maxMaintenanceFee() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("maintenanceFee"), request.maxMaintenanceFee()));

            // 2. Listing alanları (join ile)
            Join<CommercialDetails, Listing> listingJoin = root.join("listing", JoinType.INNER);
            if(request.city() != null)
                predicates.add(cb.equal(listingJoin.get("city"), request.city()));
            if(request.district() != null)
                predicates.add(cb.equal(listingJoin.get("district"), request.district()));
            if(request.neighborhood() != null)
                predicates.add(cb.equal(listingJoin.get("neighborhood"), request.neighborhood()));
            if(request.minPrice() != null)
                predicates.add(cb.greaterThanOrEqualTo(listingJoin.get("price"), request.minPrice()));
            if(request.maxPrice() != null)
                predicates.add(cb.lessThanOrEqualTo(listingJoin.get("price"), request.maxPrice()));
            if(request.status() != null)
                predicates.add(cb.equal(listingJoin.get("status"), request.status()));

            // Tüm filtreleri AND ile birleştir
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}