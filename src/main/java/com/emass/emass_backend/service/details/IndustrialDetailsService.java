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
                details.getListing().getLatitude(),
                details.getListing().getLongitude(),
                details.getListing().getCreatedAt(),
                details.getListing().getUpdatedAt(),

                null,
                null,
                null,
                new ListingResponse.IndustrialDetailsResponse(
                        details.getSubtype(),
                        details.getNetArea(),
                        details.getBuildingAge(),
                        details.getRoomCount(),
                        details.getFloorCount(),
                        details.getCeilingHeight(),
                        details.getSiteFee(),
                        details.getDeposit(),
                        details.getThreephaseElectricity(),
                        details.getNaturalGasLine(),
                        details.getSteamLine(),
                        details.getWaterSystem(),
                        details.getWasteWaterSystem(),
                        details.getCraneSystem(),
                        details.getVentilationSystem(),
                        details.getAirConditioning(),
                        details.getWideOpenArea(),
                        details.getMachineMountingSuitable(),
                        details.getLoadingRamp(),
                        details.getTruckEntrance(),
                        details.getForkliftTraffic(),
                        details.getRackingSystem(),
                        details.getColdStorage(),
                        details.getFireExtinguishingSystem(),
                        details.getSecurityCameras(),
                        details.getAlarmSystem(),
                        details.getFencedArea(),
                        details.getSecurity(),
                        details.getOperatingCost()
                ),
                null, null
        )).toList();
    }
}