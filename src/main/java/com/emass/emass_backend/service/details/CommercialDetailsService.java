package com.emass.emass_backend.service.details;

import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.details.search.CommercialSearchRequest;
import com.emass.emass_backend.model.entity.listing.details.CommercialDetails;
import com.emass.emass_backend.repository.details.CommercialDetailsRepository;
import com.emass.emass_backend.service.details.specifications.CommercialSpecifications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommercialDetailsService {

    private final CommercialDetailsRepository commercialDetailsRepository;

    public CommercialDetailsService(CommercialDetailsRepository commercialDetailsRepository) {
        this.commercialDetailsRepository = commercialDetailsRepository;
    }

    public List<ListingResponse> search(CommercialSearchRequest request) {
        List<CommercialDetails> detailsList = commercialDetailsRepository.findAll(
                CommercialSpecifications.filterByRequest(request)
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

                null,
                new ListingResponse.CommercialDetailsResponse(
                        details.getSubtype(),
                        details.getNetArea(),
                        details.getBuildingAge(),
                        details.getRoomCount(),
                        details.getFloorNo(),
                        details.getFloorCount(),
                        details.getHeatingType(),
                        details.getSiteFee(),
                        details.getDeposit(),
                        details.getBuildingType(),
                        details.getFurnished(),
                        details.getParking(),
                        details.getSecurity(),
                        details.getElevator(),
                        details.getGenerator(),
                        details.getAirConditioning(),
                        details.getInternet(),
                        details.getKitchen(),
                        details.getToilet(),
                        details.getShowcase(),
                        details.getWarehouse(),
                        details.getLoadingDock(),
                        details.getCashRegister(),
                        details.getOutdoorSeating(),
                        details.getWaitingArea(),
                        details.getChangingRoom()
                ),
                null, null, null, null
        )).toList();
    }
}