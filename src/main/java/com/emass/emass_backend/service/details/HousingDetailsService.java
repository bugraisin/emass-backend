package com.emass.emass_backend.service.details;

import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.details.search.HouseSearchRequest;
import com.emass.emass_backend.model.entity.listing.details.HousingDetails;
import com.emass.emass_backend.repository.details.HousingDetailsRepository;
import com.emass.emass_backend.service.details.specifications.HousingSpecifications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousingDetailsService {

    private final HousingDetailsRepository housingDetailsRepository;

    public HousingDetailsService(HousingDetailsRepository housingDetailsRepository) {
        this.housingDetailsRepository = housingDetailsRepository;
    }

    public List<ListingResponse> search(HouseSearchRequest request) {
        List<HousingDetails> detailsList = housingDetailsRepository.findAll(
                HousingSpecifications.filterByRequest(request)
        );

        return detailsList.stream().map(details -> new ListingResponse(
                details.getListing().getId(),
                details.getListing().getOwner().getId(),
                details.getListing().getTitle(),
                details.getListing().getDescription(),
                details.getListing().getListingType(),
                details.getListing().getPropertyType(),
                details.getListing().getStatus(),
                details.getListing().getPrice(),
                details.getListing().getCity(),
                details.getListing().getDistrict(),
                details.getListing().getNeighborhood(),
                details.getListing().getAddressText(),
                details.getListing().getLatitude(),
                details.getListing().getLongitude(),
                details.getListing().getCreatedAt(),
                details.getListing().getUpdatedAt(),

                new ListingResponse.HousingDetailsResponse(
                        details.getSubtype(),
                        details.getRoomPlan(),
                        details.getNetArea(),
                        details.getFloorNo(),
                        details.getTotalFloors(),
                        details.getBuildingAge(),
                        details.getFurnished(),
                        details.getBalcony(),
                        details.getParking(),
                        details.getHeatingType(),
                        details.getSiteName(),
                        details.getSiteFee()
                ),
                null, null, null, null, null
        )).toList();
    }
}
