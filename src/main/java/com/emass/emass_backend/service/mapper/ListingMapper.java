package com.emass.emass_backend.service.mapper;

import com.emass.emass_backend.model.dto.listing.ListingCreateRequest;
import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.*;
import org.springframework.stereotype.Component;

@Component
public class ListingMapper {

    public Listing toListingEntity(ListingCreateRequest req) {
        if (req == null) return null;

        var listing = new Listing();
        listing.setTitle(req.title());
        listing.setDescription(req.description());
        listing.setListingType(req.listingType());
        listing.setPropertyType(req.propertyType());
        listing.setPrice(req.price());

        listing.setCity(req.city());
        listing.setDistrict(req.district());
        listing.setNeighborhood(req.neighborhood());
        listing.setAddressText(req.addressText());
        listing.setLatitude(req.latitude());
        listing.setLongitude(req.longitude());
        return listing;
    }

    /** KONUT detayıyla birlikte response üretir. */
    public ListingResponse toResponse(Listing l, HousingDetails d) {
        if (l == null) return null;

        return new ListingResponse(
                l.getId(),
                l.getOwner() != null ? l.getOwner().getId() : null,
                l.getTitle(),
                l.getDescription(),
                l.getListingType(),
                l.getPropertyType(),
                l.getStatus(),
                l.getPrice(),
                l.getCity(),
                l.getDistrict(),
                l.getNeighborhood(),
                l.getAddressText(),
                l.getLatitude(),
                l.getLongitude(),
                l.getCreatedAt(),
                l.getUpdatedAt(),

                // HousingDetailsResponse
                d == null ? null : new ListingResponse.HousingDetailsResponse(
                        d.getSubtype(),
                        d.getRoomPlan(),
                        d.getNetArea(),
                        d.getFloorNo(),
                        d.getTotalFloors(),
                        d.getBuildingAge(),
                        d.getFurnished(),
                        d.getBalcony(),
                        d.getParking(),
                        d.getHeatingType(),
                        d.getSiteName(),
                        d.getSiteFee()
                ),
                null, // commercialDetails
                null, // officeDetails
                null, // industrialDetails
                null, // serviceDetails
                null  // landDetails
        );
    }

    /** TİCARİ detayıyla birlikte response üretir. */
    public ListingResponse toResponse(Listing l, CommercialDetails d) {
        if (l == null) return null;

        return new ListingResponse(
                l.getId(),
                l.getOwner() != null ? l.getOwner().getId() : null,
                l.getTitle(),
                l.getDescription(),
                l.getListingType(),
                l.getPropertyType(),
                l.getStatus(),
                l.getPrice(),
                l.getCity(),
                l.getDistrict(),
                l.getNeighborhood(),
                l.getAddressText(),
                l.getLatitude(),
                l.getLongitude(),
                l.getCreatedAt(),
                l.getUpdatedAt(),

                null, // housingDetails
                // CommercialDetailsResponse
                d == null ? null : new ListingResponse.CommercialDetailsResponse(
                        d.getSubtype(),
                        d.getNetArea(),
                        d.getFloorNo(),
                        d.getBuildingAge(),
                        d.getFurnished(),
                        d.getAirConditioning(),
                        d.getParking(),
                        d.getShowcase(),
                        d.getStreetFrontage(),
                        d.getKitchen(),
                        d.getSeatingCapacity(),
                        d.getOutdoorSeating(),
                        d.getLiquorLicense(),
                        d.getTreatmentRoomCount(),
                        d.getWaitingArea(),
                        d.getMaintenanceFee()
                ),
                null, // officeDetails
                null, // industrialDetails
                null, // serviceDetails
                null  // landDetails
        );
    }

    /** OFİS detayıyla birlikte response üretir. */
    public ListingResponse toResponse(Listing l, OfficeDetails d) {
        if (l == null) return null;

        return new ListingResponse(
                l.getId(),
                l.getOwner() != null ? l.getOwner().getId() : null,
                l.getTitle(),
                l.getDescription(),
                l.getListingType(),
                l.getPropertyType(),
                l.getStatus(),
                l.getPrice(),
                l.getCity(),
                l.getDistrict(),
                l.getNeighborhood(),
                l.getAddressText(),
                l.getLatitude(),
                l.getLongitude(),
                l.getCreatedAt(),
                l.getUpdatedAt(),

                null, // housingDetails
                null, // commercialDetails
                // OfficeDetailsResponse
                d == null ? null : new ListingResponse.OfficeDetailsResponse(
                        d.getSubtype(),
                        d.getNetArea(),
                        d.getFloorNo(),
                        d.getBuildingAge(),
                        d.getRoomCount(),
                        d.getMeetingRoomCount(),
                        d.getFurnished(),
                        d.getAirConditioning(),
                        d.getParking(),
                        d.getBusinessCenter(),
                        d.getReception(),
                        d.getDeskCount(),
                        d.getPrivateOfficeCount(),
                        d.getWorkstationCount(),
                        d.getSoundIsolation(),
                        d.getMaintenanceFee(),
                        d.getInternetIncluded()
                ),
                null, // industrialDetails
                null, // serviceDetails
                null  // landDetails
        );
    }

    /** ENDÜSTRİYEL detayıyla birlikte response üretir. */
    public ListingResponse toResponse(Listing l, IndustrialDetails d) {
        if (l == null) return null;

        return new ListingResponse(
                l.getId(),
                l.getOwner() != null ? l.getOwner().getId() : null,
                l.getTitle(),
                l.getDescription(),
                l.getListingType(),
                l.getPropertyType(),
                l.getStatus(),
                l.getPrice(),
                l.getCity(),
                l.getDistrict(),
                l.getNeighborhood(),
                l.getAddressText(),
                l.getLatitude(),
                l.getLongitude(),
                l.getCreatedAt(),
                l.getUpdatedAt(),

                null, // housingDetails
                null, // commercialDetails
                null, // officeDetails
                // IndustrialDetailsResponse
                d == null ? null : new ListingResponse.IndustrialDetailsResponse(
                        d.getSubtype(),
                        d.getTotalArea(),
                        d.getCoveredArea(),
                        d.getBuildingAge(),
                        d.getCeilingHeight(),
                        d.getPowerCapacity(),
                        d.getCrane(),
                        d.getCraneCapacity(),
                        d.getLoadingDock(),
                        d.getLoadingDockCount(),
                        d.getTruckAccess(),
                        d.getColdStorage(),
                        d.getTemperatureRange(),
                        d.getProductionLineCount(),
                        d.getLaboratory(),
                        d.getOfficeArea(),
                        d.getFireSystem(),
                        d.getSecurity(),
                        d.getOperatingCost()
                ),
                null, // serviceDetails
                null  // landDetails
        );
    }

    /** HİZMET detayıyla birlikte response üretir. */
    public ListingResponse toResponse(Listing l, ServiceDetails d) {
        if (l == null) return null;

        return new ListingResponse(
                l.getId(),
                l.getOwner() != null ? l.getOwner().getId() : null,
                l.getTitle(),
                l.getDescription(),
                l.getListingType(),
                l.getPropertyType(),
                l.getStatus(),
                l.getPrice(),
                l.getCity(),
                l.getDistrict(),
                l.getNeighborhood(),
                l.getAddressText(),
                l.getLatitude(),
                l.getLongitude(),
                l.getCreatedAt(),
                l.getUpdatedAt(),

                null, // housingDetails
                null, // commercialDetails
                null, // officeDetails
                null, // industrialDetails
                // ServiceDetailsResponse
                d == null ? null : new ListingResponse.ServiceDetailsResponse(
                        d.getSubtype(),
                        d.getTotalArea(),
                        d.getCoveredArea(),
                        d.getVehicleCapacity(),
                        d.getCoverType(),
                        d.getHeightLimit(),
                        d.getValetService(),
                        d.getEquipmentIncluded(),
                        d.getChangingRoomCount(),
                        d.getShowerCount(),
                        d.getSauna(),
                        d.getWashBayCount(),
                        d.getAutomaticSystem(),
                        d.getLiftCount(),
                        d.getLiftCapacity(),
                        d.getPaintBooth(),
                        d.getPumpCount(),
                        d.getFuelTypes(),
                        d.getConvenienceStore(),
                        d.getSecurity(),
                        d.getLighting(),
                        d.getOperatingCost()
                ),
                null  // landDetails
        );
    }

    /** ARSA detayıyla birlikte response üretir. */
    public ListingResponse toResponse(Listing l, LandDetails d) {
        if (l == null) return null;

        return new ListingResponse(
                l.getId(),
                l.getOwner() != null ? l.getOwner().getId() : null,
                l.getTitle(),
                l.getDescription(),
                l.getListingType(),
                l.getPropertyType(),
                l.getStatus(),
                l.getPrice(),
                l.getCity(),
                l.getDistrict(),
                l.getNeighborhood(),
                l.getAddressText(),
                l.getLatitude(),
                l.getLongitude(),
                l.getCreatedAt(),
                l.getUpdatedAt(),

                null, // housingDetails
                null, // commercialDetails
                null, // officeDetails
                null, // industrialDetails
                null, // serviceDetails
                // LandDetailsResponse
                d == null ? null : new ListingResponse.LandDetailsResponse(
                        d.getSubtype(),
                        d.getTotalArea(),
                        d.getZoningStatus(),
                        d.getElectricity(),
                        d.getWater(),
                        d.getRoadAccess(),
                        d.getTitleDeedStatus()
                )
        );
    }
}

