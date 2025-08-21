package com.emass.emass_backend.service.mapper;

import com.emass.emass_backend.model.dto.listing.ListingCreateRequest;
import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.entity.Listing;
import com.emass.emass_backend.model.entity.details.HousingDetails;
import com.emass.emass_backend.model.entity.details.WorkplaceDetails;
import com.emass.emass_backend.model.entity.details.LandDetails;
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
        return listing;
    }

    /** HOUSING detayıyla birlikte response üretir. */
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

                // HousingDetailsResponse - Basit yapı
                d == null ? null : new ListingResponse.HousingDetailsResponse(
                        /* subtype       */ d.getSubtype(),
                        /* roomPlan      */ d.getRoomPlan(),
                        /* netArea       */ d.getNetArea(),
                        /* floorNo       */ d.getFloorNo(),
                        /* totalFloors   */ d.getTotalFloors(),
                        /* buildingAge   */ d.getBuildingAge(),
                        /* furnished     */ d.getFurnished(),
                        /* balcony       */ d.getBalcony(),
                        /* parking       */ d.getParking(),
                        /* heatingType   */ d.getHeatingType(),
                        /* siteName      */ d.getSiteName(),
                        /* siteFee       */ d.getSiteFee()
                ),
                null,
                null
        );
    }

    /** WORKPLACE detayıyla birlikte response üretir. */
    public ListingResponse toResponse(Listing l, WorkplaceDetails d) {
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

                null,
                d == null ? null : new ListingResponse.WorkplaceDetailsResponse(
                        /* subtype         */ d.getSubtype(),
                        /* netArea         */ d.getNetArea(),
                        /* floorNo         */ d.getFloorNo(),
                        /* buildingAge     */ d.getBuildingAge(),
                        /* furnished       */ d.getFurnished(),
                        /* parking         */ d.getParking(),
                        /* airConditioning */ d.getAirConditioning(),
                        /* kitchen         */ d.getKitchen(),
                        /* seatingCapacity */ d.getSeatingCapacity(),
                        /* maintenanceFee  */ d.getMaintenanceFee()
                ),
                null
        );
    }

    /** LAND detayıyla birlikte response üretir. */
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

                null,
                null,
                d == null ? null : new ListingResponse.LandDetailsResponse(
                        /* subtype         */ d.getSubtype(),
                        /* totalArea       */ d.getTotalArea(),
                        /* zoningStatus    */ d.getZoningStatus(),
                        /* electricity     */ d.getElectricity(),
                        /* water           */ d.getWater(),
                        /* roadAccess      */ d.getRoadAccess(),
                        /* titleDeedStatus */ d.getTitleDeedStatus()
                )
        );
    }
}
