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

            // 1. Listing alanları (join ile)
            Join<HousingDetails, Listing> listingJoin = root.join("listing", JoinType.INNER);
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

            // roomCount olarak düzeltildi
            if(request.roomCount() != null && !request.roomCount().isEmpty()) {
                List<String> processedRooms = new ArrayList<>(request.roomCount());
                predicates.add(root.get("roomCount").in(processedRooms));
            }

            if(request.minNetArea() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("netArea"), request.minNetArea()));
            if(request.maxNetArea() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("netArea"), request.maxNetArea()));

            // floors listesi için floorNo kontrolü (tek katlar için)
            if(request.floors() != null && !request.floors().isEmpty()) {
                List<Predicate> floorPredicates = new ArrayList<>();
                for(String floor : request.floors()) {
                    String processedFloor = floor.replace(" ", "+"); // URL decode sorunu için
                    switch(processedFloor) {
                        case "-1" -> floorPredicates.add(cb.equal(root.get("floorNo"), -1));
                        case "0" -> floorPredicates.add(cb.equal(root.get("floorNo"), 0));
                        case "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" ->
                                floorPredicates.add(cb.equal(root.get("floorNo"), Integer.parseInt(processedFloor)));
                        case "11-15" -> floorPredicates.add(cb.between(root.get("floorNo"), 11, 15));
                        case "16-20" -> floorPredicates.add(cb.between(root.get("floorNo"), 16, 20));
                        case "21+" -> floorPredicates.add(cb.greaterThanOrEqualTo(root.get("floorNo"), 21));
                    }
                }
                if(!floorPredicates.isEmpty()) {
                    predicates.add(cb.or(floorPredicates.toArray(new Predicate[0])));
                }
            }

            // totalFloors listesi kontrolü
            if(request.totalFloors() != null && !request.totalFloors().isEmpty()) {
                List<Predicate> totalFloorPredicates = new ArrayList<>();
                for(String totalFloor : request.totalFloors()) {
                    String processedTotalFloor = totalFloor.replace(" ", "+"); // URL decode sorunu için
                    switch(processedTotalFloor) {
                        case "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" ->
                                totalFloorPredicates.add(cb.equal(root.get("totalFloors"), Integer.parseInt(processedTotalFloor)));
                        case "11-15" -> totalFloorPredicates.add(cb.between(root.get("totalFloors"), 11, 15));
                        case "16-20" -> totalFloorPredicates.add(cb.between(root.get("totalFloors"), 16, 20));
                        case "21-25" -> totalFloorPredicates.add(cb.between(root.get("totalFloors"), 21, 25));
                        case "26-30" -> totalFloorPredicates.add(cb.between(root.get("totalFloors"), 26, 30));
                        case "31+" -> totalFloorPredicates.add(cb.greaterThanOrEqualTo(root.get("totalFloors"), 31));
                    }
                }
                if(!totalFloorPredicates.isEmpty()) {
                    predicates.add(cb.or(totalFloorPredicates.toArray(new Predicate[0])));
                }
            }

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

            // Site fee aralığı
            if(request.minSiteFee() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("siteFee"), request.minSiteFee()));
            if(request.maxSiteFee() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("siteFee"), request.maxSiteFee()));

            // Deposit aralığı
            if(request.minDeposit() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("deposit"), request.minDeposit()));
            if(request.maxDeposit() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("deposit"), request.maxDeposit()));

            // heatingTypes listesi kontrolü
            if(request.heatingTypes() != null && !request.heatingTypes().isEmpty())
                predicates.add(root.get("heatingType").in(request.heatingTypes()));

            // facadeDirections listesi kontrolü
            if(request.facadeDirections() != null && !request.facadeDirections().isEmpty())
                predicates.add(root.get("facadeDirection").in(request.facadeDirections()));

            // Boolean özellikler
            if(request.furnished() != null)
                predicates.add(cb.equal(root.get("furnished"), request.furnished()));
            if(request.balcony() != null)
                predicates.add(cb.equal(root.get("balcony"), request.balcony()));
            if(request.terrace() != null)
                predicates.add(cb.equal(root.get("terrace"), request.terrace()));
            if(request.garden() != null)
                predicates.add(cb.equal(root.get("garden"), request.garden()));
            if(request.withinSite() != null)
                predicates.add(cb.equal(root.get("withinSite"), request.withinSite()));

            // Otopark
            if(request.openPark() != null)
                predicates.add(cb.equal(root.get("openPark"), request.openPark()));
            if(request.closedPark() != null)
                predicates.add(cb.equal(root.get("closedPark"), request.closedPark()));
            if(request.garagePark() != null)
                predicates.add(cb.equal(root.get("garagePark"), request.garagePark()));

            // Bina & Güvenlik
            if(request.elevator() != null)
                predicates.add(cb.equal(root.get("elevator"), request.elevator()));
            if(request.security() != null)
                predicates.add(cb.equal(root.get("security"), request.security()));
            if(request.concierge() != null)
                predicates.add(cb.equal(root.get("concierge"), request.concierge()));
            if(request.generator() != null)
                predicates.add(cb.equal(root.get("generator"), request.generator()));

            // Konfor & Isıtma
            if(request.airConditioning() != null)
                predicates.add(cb.equal(root.get("airConditioning"), request.airConditioning()));
            if(request.floorHeating() != null)
                predicates.add(cb.equal(root.get("floorHeating"), request.floorHeating()));
            if(request.fireplace() != null)
                predicates.add(cb.equal(root.get("fireplace"), request.fireplace()));

            // Mutfak & İç Mekan
            if(request.builtinKitchen() != null)
                predicates.add(cb.equal(root.get("builtinKitchen"), request.builtinKitchen()));
            if(request.separateKitchen() != null)
                predicates.add(cb.equal(root.get("separateKitchen"), request.separateKitchen()));
            if(request.americanKitchen() != null)
                predicates.add(cb.equal(root.get("americanKitchen"), request.americanKitchen()));
            if(request.laundryRoom() != null)
                predicates.add(cb.equal(root.get("laundryRoom"), request.laundryRoom()));

            // Site İmkanları
            if(request.pool() != null)
                predicates.add(cb.equal(root.get("pool"), request.pool()));
            if(request.gym() != null)
                predicates.add(cb.equal(root.get("gym"), request.gym()));
            if(request.childrenPlayground() != null)
                predicates.add(cb.equal(root.get("childrenPlayground"), request.childrenPlayground()));
            if(request.sportsArea() != null)
                predicates.add(cb.equal(root.get("sportsArea"), request.sportsArea()));

            // Tüm filtreleri AND ile birleştir
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}