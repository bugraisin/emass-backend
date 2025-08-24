package com.emass.emass_backend.service.details.specifications;

import com.emass.emass_backend.model.dto.listing.details.search.IndustrialSearchRequest;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.IndustrialDetails;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class IndustrialSpecifications {

    public static Specification<IndustrialDetails> filterByRequest(IndustrialSearchRequest request) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 1. IndustrialDetails alanları
            if(request.subtype() != null)
                predicates.add(cb.equal(root.get("subtype"), request.subtype()));
            if(request.minTotalArea() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("totalArea"), request.minTotalArea()));
            if(request.maxTotalArea() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("totalArea"), request.maxTotalArea()));
            if(request.minCoveredArea() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("coveredArea"), request.minCoveredArea()));
            if(request.maxCoveredArea() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("coveredArea"), request.maxCoveredArea()));
            if(request.minBuildingAge() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("buildingAge"), request.minBuildingAge()));
            if(request.maxBuildingAge() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("buildingAge"), request.maxBuildingAge()));
            if(request.minCeilingHeight() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("ceilingHeight"), request.minCeilingHeight()));
            if(request.maxCeilingHeight() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("ceilingHeight"), request.maxCeilingHeight()));
            if(request.minPowerCapacity() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("powerCapacity"), request.minPowerCapacity()));
            if(request.maxPowerCapacity() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("powerCapacity"), request.maxPowerCapacity()));
            if(request.crane() != null)
                predicates.add(cb.equal(root.get("crane"), request.crane()));
            if(request.minCraneCapacity() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("craneCapacity"), request.minCraneCapacity()));
            if(request.maxCraneCapacity() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("craneCapacity"), request.maxCraneCapacity()));
            if(request.loadingDock() != null)
                predicates.add(cb.equal(root.get("loadingDock"), request.loadingDock()));
            if(request.minLoadingDockCount() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("loadingDockCount"), request.minLoadingDockCount()));
            if(request.maxLoadingDockCount() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("loadingDockCount"), request.maxLoadingDockCount()));
            if(request.truckAccess() != null)
                predicates.add(cb.equal(root.get("truckAccess"), request.truckAccess()));
            if(request.coldStorage() != null)
                predicates.add(cb.equal(root.get("coldStorage"), request.coldStorage()));
            if(request.temperatureRange() != null)
                predicates.add(cb.like(cb.lower(root.get("temperatureRange")), "%" + request.temperatureRange().toLowerCase() + "%"));
            if(request.minProductionLineCount() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("productionLineCount"), request.minProductionLineCount()));
            if(request.maxProductionLineCount() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("productionLineCount"), request.maxProductionLineCount()));
            if(request.laboratory() != null)
                predicates.add(cb.equal(root.get("laboratory"), request.laboratory()));
            if(request.minOfficeArea() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("officeArea"), request.minOfficeArea()));
            if(request.maxOfficeArea() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("officeArea"), request.maxOfficeArea()));
            if(request.fireSystem() != null)
                predicates.add(cb.equal(root.get("fireSystem"), request.fireSystem()));
            if(request.security() != null)
                predicates.add(cb.equal(root.get("security"), request.security()));
            if(request.minOperatingCost() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("operatingCost"), request.minOperatingCost()));
            if(request.maxOperatingCost() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("operatingCost"), request.maxOperatingCost()));

            // 2. Listing alanları (join ile)
            Join<IndustrialDetails, Listing> listingJoin = root.join("listing", JoinType.INNER);
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