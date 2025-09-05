package com.emass.emass_backend.service.details.specifications;

import com.emass.emass_backend.model.dto.listing.details.search.ServiceSearchRequest;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.HousingDetails;
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

            // 1. Listing alanları
            Join<HousingDetails, Listing> listingJoin = root.join("listing", JoinType.INNER);

            if(request.listingType() != null)
                predicates.add(cb.equal(listingJoin.get("listingType"), request.listingType()));

            if(request.city() != null)
                predicates.add(cb.equal(listingJoin.get("city"), request.city()));

            if(request.district() != null && !request.district().isEmpty())
                predicates.add(listingJoin.get("district").in(request.district()));

            if(request.neighborhood() != null && !request.neighborhood().isEmpty())
                predicates.add(listingJoin.get("neighborhood").in(request.neighborhood()));

            if(request.minPrice() != null)
                predicates.add(cb.greaterThanOrEqualTo(listingJoin.get("price"), request.minPrice()));
            if(request.maxPrice() != null)
                predicates.add(cb.lessThanOrEqualTo(listingJoin.get("price"), request.maxPrice()));
            if(request.status() != null)
                predicates.add(cb.equal(listingJoin.get("status"), request.status()));

            // 2. HousingDetails alanları
            if(request.subtype() != null)
                predicates.add(cb.equal(root.get("subtype"), request.subtype()));

            if(request.minNetArea() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("netArea"), request.minNetArea()));
            if(request.maxNetArea() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("netArea"), request.maxNetArea()));

            if(request.minCapacity() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("capacity"), request.minCapacity()));
            if(request.maxCapacity() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("capacity"), request.maxCapacity()));

            if(request.spaceTypes() != null && !request.spaceTypes().isEmpty())
                predicates.add(root.get("spaceType").in(request.spaceTypes()));

            // Deposit aralığı
            if(request.minDeposit() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("deposit"), request.minDeposit()));
            if(request.maxDeposit() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("deposit"), request.maxDeposit()));

            // Temel Altyapı
            if(request.security() != null)
                predicates.add(cb.equal(root.get("furnished"), request.security()));
            if(request.lighting() != null)
                predicates.add(cb.equal(root.get("lighting"), request.lighting()));
            if(request.cctv() != null)
                predicates.add(cb.equal(root.get("cctv"), request.cctv()));
            if(request.internet() != null)
                predicates.add(cb.equal(root.get("internet"), request.internet()));

            // Hizmet Alanları
            if(request.reception() != null)
                predicates.add(cb.equal(root.get("reception"), request.reception()));
            if(request.restRoom() != null)
                predicates.add(cb.equal(root.get("restRoom"), request.restRoom()));
            if(request.kitchen() != null)
                predicates.add(cb.equal(root.get("kitchen"), request.kitchen()));

            // Teknik Donanım
            if(request.washingArea() != null)
                predicates.add(cb.equal(root.get("washingArea"), request.washingArea()));
            if(request.maintenanceArea() != null)
                predicates.add(cb.equal(root.get("maintenanceArea"), request.maintenanceArea()));
            if(request.airConditioning() != null)
                predicates.add(cb.equal(root.get("airConditioning"), request.airConditioning()));
            if(request.ventilationSystem() != null)
                predicates.add(cb.equal(root.get("ventilationSystem"), request.ventilationSystem()));

            // Ek Hizmetler
            if(request.storage() != null)
                predicates.add(cb.equal(root.get("storage"), request.storage()));
            if(request.officeArea() != null)
                predicates.add(cb.equal(root.get("officeArea"), request.officeArea()));
            if(request.customerParking() != null)
                predicates.add(cb.equal(root.get("customerParking"), request.customerParking()));

            // Tüm filtreleri AND ile birleştir
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}