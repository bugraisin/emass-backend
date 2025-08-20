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

        // DTO alan isimleri ile entity alanlarını eşleştiriyoruz:
        // record: subtype, roomPlan, floorNo, totalFloors, buildingAge, furnished, netAreaM2, grossAreaM2
        d.setRooms(req.roomPlan());
        d.setFloor(req.floorNo());
        d.setTotalFloors(req.totalFloors());
        d.setBuildingAge(req.buildingAge());
        d.setIsFurnished(req.furnished());
        // net/gross area entity’de yok → atlanır
        return d;
    }

    public WorkplaceDetails toEntity(Listing listing, WorkplaceDetailsRequest req) {
        if (listing == null || req == null) return null;
        var d = new WorkplaceDetails();
        d.setListing(listing);

        // record: subtype, usableAreaM2, floorNo, frontageM, ceilingHM
        d.setAreaM2(req.usableAreaM2());
        // entity’de floorNo/frontage/ceiling alanları yok → atlanır
        // isFurnished/hasParking DTO’da yok; gerekirse ayrı uçtan yönetirsiniz
        return d;
    }

    public LandDetails toEntity(Listing listing, LandDetailsRequest req) {
        if (listing == null || req == null) return null;
        var d = new LandDetails();
        d.setListing(listing);

        // record: subtype, areaM2, zoning, parcelNo, blockNo
        d.setLandAreaM2(req.areaM2());
        d.setZoningStatus(req.zoning());
        d.setParcelNo(req.parcelNo());
        // entity’de blockNo yok → atlanır
        return d;
    }
}
