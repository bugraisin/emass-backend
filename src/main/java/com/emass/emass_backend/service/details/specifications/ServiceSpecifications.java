package com.emass.emass_backend.service.details.specifications;

import com.emass.emass_backend.model.dto.listing.details.search.ServiceSearchRequest;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.ServiceDetails;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ServiceSpecifications {

    public static Specification<ServiceDetails> filterByRequest(ServiceSearchRequest request) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // 1. ServiceDetails alanları
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
            if(request.minVehicleCapacity() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("vehicleCapacity"), request.minVehicleCapacity()));
            if(request.maxVehicleCapacity() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("vehicleCapacity"), request.maxVehicleCapacity()));
            if(request.coverType() != null)
                predicates.add(cb.like(cb.lower(root.get("coverType")), "%" + request.coverType().toLowerCase() + "%"));
            if(request.minHeightLimit() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("heightLimit"), request.minHeightLimit()));
            if(request.maxHeightLimit() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("heightLimit"), request.maxHeightLimit()));
            if(request.valetService() != null)
                predicates.add(cb.equal(root.get("valetService"), request.valetService()));
            if(request.equipmentIncluded() != null)
                predicates.add(cb.equal(root.get("equipmentIncluded"), request.equipmentIncluded()));
            if(request.minChangingRoomCount() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("changingRoomCount"), request.minChangingRoomCount()));
            if(request.maxChangingRoomCount() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("changingRoomCount"), request.maxChangingRoomCount()));
            if(request.minShowerCount() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("showerCount"), request.minShowerCount()));
            if(request.maxShowerCount() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("showerCount"), request.maxShowerCount()));
            if(request.sauna() != null)
                predicates.add(cb.equal(root.get("sauna"), request.sauna()));
            if(request.minWashBayCount() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("washBayCount"), request.minWashBayCount()));
            if(request.maxWashBayCount() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("washBayCount"), request.maxWashBayCount()));
            if(request.automaticSystem() != null)
                predicates.add(cb.equal(root.get("automaticSystem"), request.automaticSystem()));
            if(request.minLiftCount() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("liftCount"), request.minLiftCount()));
            if(request.maxLiftCount() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("liftCount"), request.maxLiftCount()));
            if(request.minLiftCapacity() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("liftCapacity"), request.minLiftCapacity()));
            if(request.maxLiftCapacity() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("liftCapacity"), request.maxLiftCapacity()));
            if(request.paintBooth() != null)
                predicates.add(cb.equal(root.get("paintBooth"), request.paintBooth()));
            if(request.minPumpCount() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("pumpCount"), request.minPumpCount()));
            if(request.maxPumpCount() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("pumpCount"), request.maxPumpCount()));
            if(request.fuelTypes() != null)
                predicates.add(cb.like(cb.lower(root.get("fuelTypes")), "%" + request.fuelTypes().toLowerCase() + "%"));
            if(request.convenienceStore() != null)
                predicates.add(cb.equal(root.get("convenienceStore"), request.convenienceStore()));
            if(request.security() != null)
                predicates.add(cb.equal(root.get("security"), request.security()));
            if(request.lighting() != null)
                predicates.add(cb.equal(root.get("lighting"), request.lighting()));
            if(request.minOperatingCost() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("operatingCost"), request.minOperatingCost()));
            if(request.maxOperatingCost() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("operatingCost"), request.maxOperatingCost()));

            // 2. Listing alanları (join ile)
            Join<ServiceDetails, Listing> listingJoin = root.join("listing", JoinType.INNER);
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