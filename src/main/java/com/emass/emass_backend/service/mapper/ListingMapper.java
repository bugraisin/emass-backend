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

                // HousingDetailsResponse — entity’de birebir olmayan alanlar null bırakıldı
                d == null ? null : new ListingResponse.HousingDetailsResponse(
                        /* subtype       */ null,
                        /* roomPlan      */ d.getRooms(),
                        /* floorNo       */ d.getFloor(),
                        /* totalFloors   */ d.getTotalFloors(),
                        /* buildingAge   */ d.getBuildingAge(),
                        /* furnished     */ d.getIsFurnished(),
                        /* netAreaM2     */ null,
                        /* grossAreaM2   */ null
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
                        /* subtype       */ null,
                        /* usableAreaM2  */ d.getAreaM2(),
                        /* floorNo       */ null,
                        /* frontageM     */ null,
                        /* ceilingHM     */ null
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
                        /* subtype   */ null,
                        /* areaM2    */ d.getLandAreaM2(),
                        /* zoning    */ d.getZoningStatus(),
                        /* parcelNo  */ d.getParcelNo(),
                        /* blockNo   */ null
                )
        );
    }
}
