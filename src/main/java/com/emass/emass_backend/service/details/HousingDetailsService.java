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
                details.getListing().getLatitude(),
                details.getListing().getLongitude(),
                details.getListing().getCreatedAt(),
                details.getListing().getUpdatedAt(),

                new ListingResponse.HousingDetailsResponse(
                        details.getSubtype(),
                        details.getRoomCount(),
                        details.getGrossArea(),
                        details.getNetArea(),
                        details.getFloorNo(),
                        details.getTotalFloors(),
                        details.getBuildingAge(),
                        details.getBathroomCount(),
                        details.getHeatingType(),
                        details.getFacadeDirection(),
                        details.getTitleDeedStatus(),
                        details.getUsageStatus(),
                        details.getSiteName(),
                        details.getSiteFee(),
                        details.getDeposit(),
                        details.getFurnished(),
                        details.getBalcony(),
                        details.getTerrace(),
                        details.getGarden(),
                        details.getWithinSite(),
                        details.getOpenPark(),
                        details.getClosedPark(),
                        details.getGaragePark(),
                        details.getElevator(),
                        details.getSecurity(),
                        details.getConcierge(),
                        details.getGenerator(),
                        details.getAirConditioning(),
                        details.getFloorHeating(),
                        details.getFireplace(),
                        details.getBuiltinKitchen(),
                        details.getSeparateKitchen(),
                        details.getAmericanKitchen(),
                        details.getLaundryRoom(),
                        details.getPool(),
                        details.getGym(),
                        details.getChildrenPlayground(),
                        details.getSportsArea()
                ),
                null, null, null, null, null
        )).toList();
    }
}
