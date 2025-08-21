package com.emass.emass_backend.service.mapper;

import com.emass.emass_backend.model.dto.listing.HousingDetailsRequest;
import com.emass.emass_backend.model.dto.listing.WorkplaceDetailsRequest;
import com.emass.emass_backend.model.dto.listing.LandDetailsRequest;
import com.emass.emass_backend.model.entity.Listing;
import com.emass.emass_backend.model.entity.details.HousingDetails;
import com.emass.emass_backend.model.entity.details.WorkplaceDetails;
import com.emass.emass_backend.model.entity.details.LandDetails;
import org.springframework.stereotype.Component;

@Component
public class ListingDetailsMapper {

    public HousingDetails toEntity(Listing listing, HousingDetailsRequest req) {
        if (listing == null || req == null) return null;

        var d = new HousingDetails();
        d.setListing(listing);
        d.setSubtype(req.subtype());
        d.setRoomPlan(req.roomPlan());
        d.setNetArea(req.netArea());
        d.setFloorNo(req.floorNo());
        d.setTotalFloors(req.totalFloors());
        d.setBuildingAge(req.buildingAge());
        d.setFurnished(req.furnished());
        d.setBalcony(req.balcony());
        d.setParking(req.parking());
        d.setHeatingType(req.heatingType());
        d.setSiteName(req.siteName());
        d.setSiteFee(req.siteFee());
        return d;
    }

    public WorkplaceDetails toEntity(Listing listing, WorkplaceDetailsRequest req) {
        if (listing == null || req == null) return null;

        var d = new WorkplaceDetails();
        d.setListing(listing);
        d.setSubtype(req.subtype());
        d.setNetArea(req.netArea());
        d.setFloorNo(req.floorNo());
        d.setBuildingAge(req.buildingAge());
        d.setFurnished(req.furnished());
        d.setParking(req.parking());
        d.setAirConditioning(req.airConditioning());
        d.setKitchen(req.kitchen());
        d.setSeatingCapacity(req.seatingCapacity());
        d.setMaintenanceFee(req.maintenanceFee());
        return d;
    }

    public LandDetails toEntity(Listing listing, LandDetailsRequest req) {
        if (listing == null || req == null) return null;

        var d = new LandDetails();
        d.setListing(listing);
        d.setSubtype(req.subtype());
        d.setTotalArea(req.totalArea());
        d.setZoningStatus(req.zoningStatus());
        d.setElectricity(req.electricity());
        d.setWater(req.water());
        d.setRoadAccess(req.roadAccess());
        d.setTitleDeedStatus(req.titleDeedStatus());
        return d;
    }
}
