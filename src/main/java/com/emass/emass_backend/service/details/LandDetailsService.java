package com.emass.emass_backend.service.details;

import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.details.search.LandSearchRequest;
import com.emass.emass_backend.model.entity.listing.details.LandDetails;
import com.emass.emass_backend.repository.details.LandDetailsRepository;
import com.emass.emass_backend.service.details.specifications.LandSpecifications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandDetailsService {

    private final LandDetailsRepository landDetailsRepository;

    public LandDetailsService(LandDetailsRepository landDetailsRepository) {
        this.landDetailsRepository = landDetailsRepository;
    }

    public List<ListingResponse> search(LandSearchRequest request) {
        List<LandDetails> detailsList = landDetailsRepository.findAll(
                LandSpecifications.filterByRequest(request)
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

                null,
                null,
                null,
                null,
                null,
                new ListingResponse.LandDetailsResponse(
                        details.getSubtype(),
                        details.getTotalArea(),
                        details.getZoningStatus(),
                        details.getElectricity(),
                        details.getWater(),
                        details.getRoadAccess(),
                        details.getTitleDeedStatus()
                )
        )).toList();
    }
}