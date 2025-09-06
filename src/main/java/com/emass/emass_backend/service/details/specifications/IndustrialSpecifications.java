package com.emass.emass_backend.service.details.specifications;

import com.emass.emass_backend.model.dto.listing.details.search.IndustrialSearchRequest;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.HousingDetails;
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

            // 1. Listing alanları
            Join<IndustrialDetails, Listing> listingJoin = root.join("listing", JoinType.INNER);

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

            // buildingAges listesi kontrolü
            if(request.buildingAges() != null && !request.buildingAges().isEmpty()) {
                List<Predicate> buildingAgePredicates = new ArrayList<>();
                for(String buildingAge : request.buildingAges()) {
                    String processedBuildingAge = buildingAge.replace(" ", "+"); // URL decode sorunu için
                    switch(processedBuildingAge) {
                        case "0+(Yeni)", "0 (Yeni)" -> buildingAgePredicates.add(cb.equal(root.get("buildingAge"), "0 (Yeni)"));
                        case "1-5" -> buildingAgePredicates.add(cb.equal(root.get("buildingAge"), "1-5"));
                        case "6-10" -> buildingAgePredicates.add(cb.equal(root.get("buildingAge"), "6-10"));
                        case "11-15" -> buildingAgePredicates.add(cb.equal(root.get("buildingAge"), "11-15"));
                        case "16-20" -> buildingAgePredicates.add(cb.equal(root.get("buildingAge"), "16-20"));
                        case "21-25" -> buildingAgePredicates.add(cb.equal(root.get("buildingAge"), "21-25"));
                        case "26-30" -> buildingAgePredicates.add(cb.equal(root.get("buildingAge"), "26-30"));
                        case "31+" -> buildingAgePredicates.add(cb.equal(root.get("buildingAge"), "31+"));
                    }
                }
                if(!buildingAgePredicates.isEmpty()) {
                    predicates.add(cb.or(buildingAgePredicates.toArray(new Predicate[0])));
                }
            }

            if(request.minCeilingHeight() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("ceilingHeight"), request.minCeilingHeight()));
            if(request.maxNetArea() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("ceilingHeight"), request.maxCeilingHeight()));

            // Altyapı & Enerji
            if(request.threephaseElectricity() != null)
                predicates.add(cb.equal(root.get("threephaseElectricity"), request.threephaseElectricity()));
            if(request.naturalGasLine() != null)
                predicates.add(cb.equal(root.get("naturalGasLine"), request.naturalGasLine()));
            if(request.steamLine() != null)
                predicates.add(cb.equal(root.get("steamLine"), request.steamLine()));
            if(request.waterSystem() != null)
                predicates.add(cb.equal(root.get("waterSystem"), request.waterSystem()));
            if(request.wasteWaterSystem() != null)
                predicates.add(cb.equal(root.get("wasteWaterSystem"), request.wasteWaterSystem()));

            // Üretim & İmalat
            if(request.craneSystem() != null)
                predicates.add(cb.equal(root.get("craneSystem"), request.craneSystem()));
            if(request.ventilationSystem() != null)
                predicates.add(cb.equal(root.get("ventilationSystem"), request.ventilationSystem()));
            if(request.airConditioning() != null)
                predicates.add(cb.equal(root.get("airConditioning"), request.airConditioning()));
            if(request.wideOpenArea() != null)
                predicates.add(cb.equal(root.get("wideOpenArea"), request.wideOpenArea()));
            if(request.machineMountingSuitable() != null)
                predicates.add(cb.equal(root.get("machineMountingSuitable"), request.machineMountingSuitable()));

            // Depolama & Lojistik
            if(request.loadingRamp() != null)
                predicates.add(cb.equal(root.get("loadingRamp"), request.loadingRamp()));
            if(request.truckEntrance() != null)
                predicates.add(cb.equal(root.get("truckEntrance"), request.truckEntrance()));
            if(request.forkliftTraffic() != null)
                predicates.add(cb.equal(root.get("forkliftTraffic"), request.forkliftTraffic()));
            if(request.rackingSystem() != null)
                predicates.add(cb.equal(root.get("rackingSystem"), request.rackingSystem()));
            if(request.coldStorage() != null)
                predicates.add(cb.equal(root.get("coldStorage"), request.coldStorage()));

            // Güvenlik & Sistem
            if(request.fireExtinguishingSystem() != null)
                predicates.add(cb.equal(root.get("fireExtinguishingSystem"), request.fireExtinguishingSystem()));
            if(request.securityCameras() != null)
                predicates.add(cb.equal(root.get("securityCameras"), request.securityCameras()));
            if(request.alarmSystem() != null)
                predicates.add(cb.equal(root.get("alarmSystem"), request.alarmSystem()));
            if(request.fencedArea() != null)
                predicates.add(cb.equal(root.get("fencedArea"), request.fencedArea()));
            if(request.security() != null)
                predicates.add(cb.equal(root.get("security"), request.security()));

            // Tüm filtreleri AND ile birleştir
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}