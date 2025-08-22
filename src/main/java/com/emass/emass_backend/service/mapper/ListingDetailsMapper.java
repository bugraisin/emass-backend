package com.emass.emass_backend.service.mapper;

import com.emass.emass_backend.model.dto.listing.details.*;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.*;
import org.springframework.stereotype.Component;

@Component
public class ListingDetailsMapper {

    public HousingDetails toEntity(Listing listing, HousingDetailsRequest req) {
        if (listing == null || req == null) return null;

        return HousingDetails.builder()
                .listing(listing)
                .subtype(req.subtype())
                .roomPlan(req.roomPlan())
                .netArea(req.netArea())
                .floorNo(req.floorNo())
                .totalFloors(req.totalFloors())
                .buildingAge(req.buildingAge())
                .furnished(req.furnished())
                .balcony(req.balcony())
                .parking(req.parking())
                .heatingType(req.heatingType())
                .siteName(req.siteName())
                .siteFee(req.siteFee())
                .build();
    }

    public CommercialDetails toEntity(Listing listing, CommercialDetailsRequest req) {
        if (listing == null || req == null) return null;

        return CommercialDetails.builder()
                .listing(listing)
                .subtype(req.subtype())
                .netArea(req.netArea())
                .floorNo(req.floorNo())
                .buildingAge(req.buildingAge())
                .furnished(req.furnished())
                .airConditioning(req.airConditioning())
                .parking(req.parking())
                .showcase(req.showcase())
                .streetFrontage(req.streetFrontage())
                .kitchen(req.kitchen())
                .seatingCapacity(req.seatingCapacity())
                .outdoorSeating(req.outdoorSeating())
                .liquorLicense(req.liquorLicense())
                .treatmentRoomCount(req.treatmentRoomCount())
                .waitingArea(req.waitingArea())
                .maintenanceFee(req.maintenanceFee())
                .build();
    }

    public OfficeDetails toEntity(Listing listing, OfficeDetailsRequest req) {
        if (listing == null || req == null) return null;

        return OfficeDetails.builder()
                .listing(listing)
                .subtype(req.subtype())
                .netArea(req.netArea())
                .floorNo(req.floorNo())
                .buildingAge(req.buildingAge())
                .roomCount(req.roomCount())
                .meetingRoomCount(req.meetingRoomCount())
                .furnished(req.furnished())
                .airConditioning(req.airConditioning())
                .parking(req.parking())
                .businessCenter(req.businessCenter())
                .reception(req.reception())
                .deskCount(req.deskCount())
                .privateOfficeCount(req.privateOfficeCount())
                .workstationCount(req.workstationCount())
                .soundIsolation(req.soundIsolation())
                .maintenanceFee(req.maintenanceFee())
                .internetIncluded(req.internetIncluded())
                .build();
    }

    public IndustrialDetails toEntity(Listing listing, IndustrialDetailsRequest req) {
        if (listing == null || req == null) return null;

        return IndustrialDetails.builder()
                .listing(listing)
                .subtype(req.subtype())
                .totalArea(req.totalArea())
                .coveredArea(req.coveredArea())
                .buildingAge(req.buildingAge())
                .ceilingHeight(req.ceilingHeight())
                .powerCapacity(req.powerCapacity())
                .crane(req.crane())
                .craneCapacity(req.craneCapacity())
                .loadingDock(req.loadingDock())
                .loadingDockCount(req.loadingDockCount())
                .truckAccess(req.truckAccess())
                .coldStorage(req.coldStorage())
                .temperatureRange(req.temperatureRange())
                .productionLineCount(req.productionLineCount())
                .laboratory(req.laboratory())
                .officeArea(req.officeArea())
                .fireSystem(req.fireSystem())
                .security(req.security())
                .operatingCost(req.operatingCost())
                .build();
    }

    public ServiceDetails toEntity(Listing listing, ServiceDetailsRequest req) {
        if (listing == null || req == null) return null;

        return ServiceDetails.builder()
                .listing(listing)
                .subtype(req.subtype())
                .totalArea(req.totalArea())
                .coveredArea(req.coveredArea())
                .vehicleCapacity(req.vehicleCapacity())
                .coverType(req.coverType())
                .heightLimit(req.heightLimit())
                .valetService(req.valetService())
                .equipmentIncluded(req.equipmentIncluded())
                .changingRoomCount(req.changingRoomCount())
                .showerCount(req.showerCount())
                .sauna(req.sauna())
                .washBayCount(req.washBayCount())
                .automaticSystem(req.automaticSystem())
                .liftCount(req.liftCount())
                .liftCapacity(req.liftCapacity())
                .paintBooth(req.paintBooth())
                .pumpCount(req.pumpCount())
                .fuelTypes(req.fuelTypes())
                .convenienceStore(req.convenienceStore())
                .security(req.security())
                .lighting(req.lighting())
                .operatingCost(req.operatingCost())
                .build();
    }

    public LandDetails toEntity(Listing listing, LandDetailsRequest req) {
        if (listing == null || req == null) return null;

        return LandDetails.builder()
                .listing(listing)
                .subtype(req.subtype())
                .totalArea(req.totalArea())
                .zoningStatus(req.zoningStatus())
                .electricity(req.electricity())
                .water(req.water())
                .roadAccess(req.roadAccess())
                .titleDeedStatus(req.titleDeedStatus())
                .build();
    }
}
