package com.emass.emass_backend.service.details.specifications;

import com.emass.emass_backend.model.dto.listing.details.search.HouseSearchRequest;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.HousingDetails;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class HousingSpecifications {

    public static Specification<HousingDetails> filterByRequest(HouseSearchRequest request) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 1. HousingDetails alanları
            if(request.subtype() != null)
                predicates.add(cb.equal(root.get("subtype"), request.subtype()));
            if(request.roomPlans() != null && !request.roomPlans().isEmpty())
                predicates.add(root.get("roomPlan").in(request.roomPlans()));
            if(request.minNetArea() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("netArea"), request.minNetArea()));
            if(request.maxNetArea() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("netArea"), request.maxNetArea()));
            if(request.floorNo() != null)
                predicates.add(cb.equal(root.get("floorNo"), request.floorNo()));
            if(request.totalFloors() != null)
                predicates.add(cb.equal(root.get("totalFloors"), request.totalFloors()));
            if(request.buildingAge() != null)
                predicates.add(cb.equal(root.get("buildingAge"), request.buildingAge()));
            if(request.furnished() != null)
                predicates.add(cb.equal(root.get("furnished"), request.furnished()));
            if(request.balcony() != null)
                predicates.add(cb.equal(root.get("balcony"), request.balcony()));
            if(request.parking() != null)
                predicates.add(cb.equal(root.get("parking"), request.parking()));
            if(request.heatingType() != null)
                predicates.add(cb.equal(root.get("heatingType"), request.heatingType()));
            if(request.siteName() != null)
                predicates.add(cb.like(cb.lower(root.get("siteName")), "%" + request.siteName().toLowerCase() + "%"));
            if(request.minSiteFee() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("siteFee"), request.minSiteFee()));
            if(request.maxSiteFee() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("siteFee"), request.maxSiteFee()));

            // 2. Listing alanları (join ile)
            Join<HousingDetails, Listing> listingJoin = root.join("listing", JoinType.INNER);
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