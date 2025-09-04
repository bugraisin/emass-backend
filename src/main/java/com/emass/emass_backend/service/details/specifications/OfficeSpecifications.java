package com.emass.emass_backend.service.details.specifications;

import com.emass.emass_backend.model.dto.listing.details.search.OfficeSearchRequest;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.HousingDetails;
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

            // 2. OfficeDetails alanları
            if(request.subtype() != null)
                predicates.add(cb.equal(root.get("subtype"), request.subtype()));

            if(request.minNetArea() != null)
                predicates.add(cb.greaterThanOrEqualTo(root.get("netArea"), request.minNetArea()));
            if(request.maxNetArea() != null)
                predicates.add(cb.lessThanOrEqualTo(root.get("netArea"), request.maxNetArea()));

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

            // buildingAges listesi kontrolü
            if(request.buildingAges() != null && !request.buildingAges().isEmpty()) {
                List<Predicate> buildingAgePredicates = new ArrayList<>();
                for(String buildingAge : request.buildingAges()) {
                    String processedBuildingAge = buildingAge.replace(" ", "+"); // URL decode sorunu için
                    switch(processedBuildingAge) {
                        case "0+(Yeni)", "0 (Yeni)" -> buildingAgePredicates.add(cb.equal(root.get("buildingAge"), "0"));
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

            // roomCount olarak düzeltildi
            if(request.roomCount() != null && !request.roomCount().isEmpty()) {
                List<String> processedRooms = new ArrayList<>(request.roomCount());
                predicates.add(root.get("roomCount").in(processedRooms));
            }

            // meetingRooms olarak düzeltildi
            if(request.meetingRooms() != null && !request.meetingRooms().isEmpty()) {
                List<String> processedMeetingRooms = new ArrayList<>(request.meetingRooms());
                predicates.add(root.get("meetingRooms").in(processedMeetingRooms));
            }
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

            if(request.furnished() != null)
                predicates.add(cb.equal(root.get("furnished"), request.furnished()));
            if(request.parking() != null)
                predicates.add(cb.equal(root.get("parking"), request.parking()));
            if(request.elevator() != null)
                predicates.add(cb.equal(root.get("elevator"), request.elevator()));
            if(request.security() != null)
                predicates.add(cb.equal(root.get("security"), request.security()));
            if(request.generator() != null)
                predicates.add(cb.equal(root.get("generator"), request.generator()));

            if(request.airConditioning() != null)
                predicates.add(cb.equal(root.get("airConditioning"), request.airConditioning()));
            if(request.internet() != null)
                predicates.add(cb.equal(root.get("internet"), request.internet()));
            if(request.kitchen() != null)
                predicates.add(cb.equal(root.get("kitchen"), request.kitchen()));
            if(request.fireSystem() != null)
                predicates.add(cb.equal(root.get("fireSystem"), request.fireSystem()));

            if(request.reception() != null)
                predicates.add(cb.equal(root.get("reception"), request.reception()));
            if(request.waitingArea() != null)
                predicates.add(cb.equal(root.get("waitingArea"), request.waitingArea()));
            if(request.meetingRoom() != null)
                predicates.add(cb.equal(root.get("meetingRoom"), request.meetingRoom()));
            if(request.archive() != null)
                predicates.add(cb.equal(root.get("archive"), request.archive()));
            if(request.library() != null)
                predicates.add(cb.equal(root.get("library"), request.library()));

            if(request.serverRoom() != null)
                predicates.add(cb.equal(root.get("serverRoom"), request.serverRoom()));
            if(request.accessControl() != null)
                predicates.add(cb.equal(root.get("accessControl"), request.accessControl()));
            if(request.fiberInternet() != null)
                predicates.add(cb.equal(root.get("fiberInternet"), request.fiberInternet()));
            if(request.soundproof() != null)
                predicates.add(cb.equal(root.get("soundproof"), request.soundproof()));

            // Tüm filtreleri AND ile birleştir
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}