package com.emass.emass_backend.service.details.specifications;

import com.emass.emass_backend.model.dto.listing.details.search.OfficeSearchRequest;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.OfficeDetails;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class OfficeSpecifications {

    public static Specification<OfficeDetails> filterByRequest(OfficeSearchRequest request) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 1. OfficeDetails alanları
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
            if(request.minRoomCount() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("roomCount"), request.minRoomCount()));
            if(request.maxRoomCount() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("roomCount"), request.maxRoomCount()));
            if(request.minMeetingRoomCount() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("meetingRoomCount"), request.minMeetingRoomCount()));
            if(request.maxMeetingRoomCount() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("meetingRoomCount"), request.maxMeetingRoomCount()));
            if(request.furnished() != null)
                predicates.add(cb.equal(root.get("furnished"), request.furnished()));
            if(request.airConditioning() != null)
                predicates.add(cb.equal(root.get("airConditioning"), request.airConditioning()));
            if(request.parking() != null)
                predicates.add(cb.equal(root.get("parking"), request.parking()));
            if(request.businessCenter() != null)
                predicates.add(cb.like(cb.lower(root.get("businessCenter")), "%" + request.businessCenter().toLowerCase() + "%"));
            if(request.reception() != null)
                predicates.add(cb.equal(root.get("reception"), request.reception()));
            if(request.minDeskCount() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("deskCount"), request.minDeskCount()));
            if(request.maxDeskCount() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("deskCount"), request.maxDeskCount()));
            if(request.minPrivateOfficeCount() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("privateOfficeCount"), request.minPrivateOfficeCount()));
            if(request.maxPrivateOfficeCount() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("privateOfficeCount"), request.maxPrivateOfficeCount()));
            if(request.minWorkstationCount() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("workstationCount"), request.minWorkstationCount()));
            if(request.maxWorkstationCount() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("workstationCount"), request.maxWorkstationCount()));
            if(request.soundIsolation() != null)
                predicates.add(cb.equal(root.get("soundIsolation"), request.soundIsolation()));
            if(request.minMaintenanceFee() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("maintenanceFee"), request.minMaintenanceFee()));
            if(request.maxMaintenanceFee() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("maintenanceFee"), request.maxMaintenanceFee()));
            if(request.internetIncluded() != null)
                predicates.add(cb.equal(root.get("internetIncluded"), request.internetIncluded()));

            // 2. Listing alanları (join ile)
            Join<OfficeDetails, Listing> listingJoin = root.join("listing", JoinType.INNER);
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