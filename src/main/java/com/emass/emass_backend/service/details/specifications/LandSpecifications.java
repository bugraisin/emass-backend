package com.emass.emass_backend.service.details.specifications;

import com.emass.emass_backend.model.dto.listing.details.search.LandSearchRequest;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.HousingDetails;
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

            // 2. HousingDetails alanlarıüğ
            if(request.subtype() != null)
                predicates.add(cb.equal(root.get("subtype"), request.subtype()));

            if(request.minNetArea() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("landArea"), request.minNetArea()));
            if(request.maxNetArea() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("landArea"), request.maxNetArea()));

            if(request.zoningStatus() != null && !request.zoningStatus().isEmpty())
                predicates.add(root.get("zoningStatus").in(request.zoningStatus()));

            if(request.titleLandDeedStatus() != null && !request.titleLandDeedStatus().isEmpty())
                predicates.add(root.get("titleLandDeedStatus").in(request.zoningStatus()));

            if(request.electricity() != null)
                predicates.add(cb.equal(root.get("electricity"), request.electricity()));
            if(request.water() != null)
                predicates.add(cb.equal(root.get("water"), request.water()));
            if(request.naturalGas() != null)
                predicates.add(cb.equal(root.get("naturalGas"), request.naturalGas()));
            if(request.sewerage() != null)
                predicates.add(cb.equal(root.get("sewerage"), request.sewerage()));
            if(request.roadAccess() != null)
                predicates.add(cb.equal(root.get("roadAccess"), request.roadAccess()));

            if(request.cornerLot() != null)
                predicates.add(cb.equal(root.get("cornerLot"), request.cornerLot()));
            if(request.seaView() != null)
                predicates.add(cb.equal(root.get("seaView"), request.seaView()));
            if(request.cityView() != null)
                predicates.add(cb.equal(root.get("cityView"), request.cityView()));
            if(request.forestView() != null)
                predicates.add(cb.equal(root.get("forestView"), request.forestView()));
            if(request.mountainView() != null)
                predicates.add(cb.equal(root.get("mountainView"), request.mountainView()));

            if(request.flat() != null)
                predicates.add(cb.equal(root.get("flat"), request.flat()));
            if(request.slope() != null)
                predicates.add(cb.equal(root.get("slope"), request.slope()));
            if(request.fenced() != null)
                predicates.add(cb.equal(root.get("fenced"), request.fenced()));
            if(request.agricultural() != null)
                predicates.add(cb.equal(root.get("agricultural"), request.agricultural()));
            if(request.buildingPermit() != null)
                predicates.add(cb.equal(root.get("buildingPermit"), request.buildingPermit()));

            if(request.vineyard() != null)
                predicates.add(cb.equal(root.get("vineyard"), request.vineyard()));
            if(request.orchard() != null)
                predicates.add(cb.equal(root.get("orchard"), request.orchard()));
            if(request.oliveTrees() != null)
                predicates.add(cb.equal(root.get("oliveTrees"), request.oliveTrees()));
            if(request.greenhouse() != null)
                predicates.add(cb.equal(root.get("greenhouse"), request.greenhouse()));
            if(request.well() != null)
                predicates.add(cb.equal(root.get("well"), request.well()));

            // Tüm filtreleri AND ile birleştir
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}