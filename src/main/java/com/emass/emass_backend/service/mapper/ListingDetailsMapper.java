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
                .roomCount(req.roomCount())
                .grossArea(req.grossArea())
                .netArea(req.netArea())
                .floorNo(req.floorNo())
                .totalFloors(req.totalFloors())
                .buildingAge(req.buildingAge())
                .bathroomCount(req.bathroomCount())
                .heatingType(req.heatingType())
                .facadeDirection(req.facadeDirection())
                .titleDeedStatus(req.titleDeedStatus())
                .usageStatus(req.usageStatus())
                .siteName(req.siteName())
                .siteFee(req.siteFee())
                .deposit(req.deposit())
                .furnished(req.furnished())
                .balcony(req.balcony())
                .terrace(req.terrace())
                .garden(req.garden())
                .withinSite(req.withinSite())
                .openPark(req.openPark())
                .closedPark(req.closedPark())
                .garagePark(req.garagePark())
                .elevator(req.elevator())
                .security(req.security())
                .concierge(req.concierge())
                .generator(req.generator())
                .airConditioning(req.airConditioning())
                .floorHeating(req.floorHeating())
                .fireplace(req.fireplace())
                .builtinKitchen(req.builtinKitchen())
                .separateKitchen(req.separateKitchen())
                .americanKitchen(req.americanKitchen())
                .laundryRoom(req.laundryRoom())
                .pool(req.pool())
                .gym(req.gym())
                .childrenPlayground(req.childrenPlayground())
                .sportsArea(req.sportsArea())
                .build();
    }

    public CommercialDetails toEntity(Listing listing, CommercialDetailsRequest req) {
        if (listing == null || req == null) return null;

        return CommercialDetails.builder()
                .listing(listing)
                .subtype(req.subtype())
                .grossArea(req.grossArea())
                .netArea(req.netArea())
                .buildingAge(req.buildingAge())
                .floorNo(req.floorNo())
                .floorCount(req.floorCount())
                .heatingType(req.heatingType())
                .siteFee(req.siteFee())
                .deposit(req.deposit())
                .buildingType(req.buildingType())
                .furnished(req.furnished())
                .parking(req.parking())
                .security(req.security())
                .elevator(req.elevator())
                .generator(req.generator())
                .airConditioning(req.airConditioning())
                .internet(req.internet())
                .kitchen(req.kitchen())
                .toilet(req.toilet())
                .showcase(req.showcase())
                .warehouse(req.warehouse())
                .loadingDock(req.loadingDock())
                .cashRegister(req.cashRegister())
                .outdoorSeating(req.outdoorSeating())
                .waitingArea(req.waitingArea())
                .changingRoom(req.changingRoom())
                .build();
    }

    public OfficeDetails toEntity(Listing listing, OfficeDetailsRequest req) {
        if (listing == null || req == null) return null;

        return OfficeDetails.builder()
                .listing(listing)
                .subtype(req.subtype())
                .grossArea(req.grossArea())
                .netArea(req.netArea())
                .buildingAge(req.buildingAge())
                .roomCount(req.roomCount())
                .floorNo(req.floorNo())
                .floorCount(req.floorCount())
                .heatingType(req.heatingType())
                .siteFee(req.siteFee())
                .deposit(req.deposit())
                .buildingType(req.buildingType())
                .furnished(req.furnished())
                .parking(req.parking())
                .elevator(req.elevator())
                .security(req.security())
                .generator(req.generator())
                .airConditioning(req.airConditioning())
                .internet(req.internet())
                .kitchen(req.kitchen())
                .fireSystem(req.fireSystem())
                .reception(req.reception())
                .waitingArea(req.waitingArea())
                .meetingRoom(req.meetingRoom())
                .archive(req.archive())
                .library(req.library())
                .serverRoom(req.serverRoom())
                .accessControl(req.accessControl())
                .fiberInternet(req.fiberInternet())
                .soundproof(req.soundproof())
                .build();
    }

    public IndustrialDetails toEntity(Listing listing, IndustrialDetailsRequest req) {
        if (listing == null || req == null) return null;

        return IndustrialDetails.builder()
                .listing(listing)
                .subtype(req.subtype())
                .grossArea(req.grossArea())
                .netArea(req.netArea())
                .buildingAge(req.buildingAge())
                .roomCount(req.roomCount())
                .floorCount(req.floorCount())
                .ceilingHeight(req.ceilingHeight())
                .deposit(req.deposit())
                .threephaseElectricity(req.threephaseElectricity())
                .naturalGasLine(req.naturalGasLine())
                .steamLine(req.steamLine())
                .waterSystem(req.waterSystem())
                .wasteWaterSystem(req.wasteWaterSystem())
                .craneSystem(req.craneSystem())
                .ventilationSystem(req.ventilationSystem())
                .airConditioning(req.airConditioning())
                .wideOpenArea(req.wideOpenArea())
                .machineMountingSuitable(req.machineMountingSuitable())
                .loadingRamp(req.loadingRamp())
                .truckEntrance(req.truckEntrance())
                .forkliftTraffic(req.forkliftTraffic())
                .rackingSystem(req.rackingSystem())
                .coldStorage(req.coldStorage())
                .fireExtinguishingSystem(req.fireExtinguishingSystem())
                .securityCameras(req.securityCameras())
                .alarmSystem(req.alarmSystem())
                .fencedArea(req.fencedArea())
                .security(req.security())
                .build();
    }

    public ServiceDetails toEntity(Listing listing, ServiceDetailsRequest req) {
        if (listing == null || req == null) return null;

        return ServiceDetails.builder()
                .listing(listing)
                .subtype(req.subtype())
                .grossArea(req.grossArea())
                .netArea(req.netArea())
                .capacity(req.capacity())
                .spaceType(req.spaceType())
                .deposit(req.deposit())
                .security(req.security())
                .lighting(req.lighting())
                .cctv(req.cctv())
                .internet(req.internet())
                .reception(req.reception())
                .restRoom(req.restRoom())
                .kitchen(req.kitchen())
                .washingArea(req.washingArea())
                .maintenanceArea(req.maintenanceArea())
                .airConditioning(req.airConditioning())
                .ventilationSystem(req.ventilationSystem())
                .storage(req.storage())
                .officeArea(req.officeArea())
                .customerParking(req.customerParking())
                .build();
    }

    public LandDetails toEntity(Listing listing, LandDetailsRequest req) {
        if (listing == null || req == null) return null;

        return LandDetails.builder()
                .listing(listing)
                .subtype(req.subtype())
                .landArea(req.landArea())
                .zoningStatus(req.zoningStatus())
                .adaNo(req.adaNo())
                .parcelNo(req.parcelNo())
                .paftaNo(req.paftaNo())
                .kaks(req.kaks())
                .gabari(req.gabari())
                .titleLandDeedStatus(req.titleLandDeedStatus())
                .electricity(req.electricity())
                .water(req.water())
                .naturalGas(req.naturalGas())
                .sewerage(req.sewerage())
                .roadAccess(req.roadAccess())
                .cornerLot(req.cornerLot())
                .seaView(req.seaView())
                .cityView(req.cityView())
                .forestView(req.forestView())
                .mountainView(req.mountainView())
                .flat(req.flat())
                .slope(req.slope())
                .fenced(req.fenced())
                .agricultural(req.agricultural())
                .buildingPermit(req.buildingPermit())
                .vineyard(req.vineyard())
                .orchard(req.orchard())
                .oliveTrees(req.oliveTrees())
                .greenhouse(req.greenhouse())
                .well(req.well())
                .build();
    }
}
