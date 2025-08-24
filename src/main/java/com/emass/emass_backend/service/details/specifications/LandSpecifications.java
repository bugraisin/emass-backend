package com.emass.emass_backend.service.details.specifications;

import com.emass.emass_backend.model.dto.listing.details.search.LandSearchRequest;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.LandDetails;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class LandSpecifications {

    public static Specification<LandDetails> filterByRequest(LandSearchRequest request) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 1. LandDetails alanları
            if(request.subtype() != null)
                predicates.add(cb.equal(root.get("subtype"), request.subtype()));
            if(request.minTotalArea() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("totalArea"), request.minTotalArea()));
            if(request.maxTotalArea() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("totalArea"), request.maxTotalArea()));
            if(request.zoningStatus() != null)
                predicates.add(cb.like(cb.lower(root.get("zoningStatus")), "%" + request.zoningStatus().toLowerCase() + "%"));
            if(request.electricity() != null)
                predicates.add(cb.equal(root.get("electricity"), request.electricity()));
            if(request.water() != null)
                predicates.add(cb.equal(root.get("water"), request.water()));
            if(request.roadAccess() != null)
                predicates.add(cb.equal(root.get("roadAccess"), request.roadAccess()));
            if(request.titleDeedStatus() != null)
                predicates.add(cb.like(cb.lower(root.get("titleDeedStatus")), "%" + request.titleDeedStatus().toLowerCase() + "%"));

            // 2. Listing alanları (join ile)
            Join<LandDetails, Listing> listingJoin = root.join("listing", JoinType.INNER);
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