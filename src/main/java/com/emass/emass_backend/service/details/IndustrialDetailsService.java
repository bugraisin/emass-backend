package com.emass.emass_backend.service.details;

import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.details.search.IndustrialSearchRequest;
import com.emass.emass_backend.model.entity.listing.details.IndustrialDetails;
import com.emass.emass_backend.repository.details.IndustrialDetailsRepository;
import com.emass.emass_backend.service.details.specifications.IndustrialSpecifications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustrialDetailsService {

    private final IndustrialDetailsRepository industrialDetailsRepository;

    public IndustrialDetailsService(IndustrialDetailsRepository industrialDetailsRepository) {
        this.industrialDetailsRepository = industrialDetailsRepository;
    }

    public List<ListingResponse> search(IndustrialSearchRequest request) {
        List<IndustrialDetails> detailsList = industrialDetailsRepository.findAll(
                IndustrialSpecifications.filterByRequest(request)
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
                new ListingResponse.IndustrialDetailsResponse(
                        details.getSubtype(),
                        details.getTotalArea(),
                        details.getCoveredArea(),
                        details.getBuildingAge(),
                        details.getCeilingHeight(),
                        details.getPowerCapacity(),
                        details.getCrane(),
                        details.getCraneCapacity(),
                        details.getLoadingDock(),
                        details.getLoadingDockCount(),
                        details.getTruckAccess(),
                        details.getColdStorage(),
                        details.getTemperatureRange(),
                        details.getProductionLineCount(),
                        details.getLaboratory(),
                        details.getOfficeArea(),
                        details.getFireSystem(),
                        details.getSecurity(),
                        details.getOperatingCost()
                ),
                null, null
        )).toList();
    }
}