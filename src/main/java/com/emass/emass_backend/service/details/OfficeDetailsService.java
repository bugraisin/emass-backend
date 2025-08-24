package com.emass.emass_backend.service.details;

import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.details.search.OfficeSearchRequest;
import com.emass.emass_backend.model.entity.listing.details.OfficeDetails;
import com.emass.emass_backend.repository.details.OfficeDetailsRepository;
import com.emass.emass_backend.service.details.specifications.OfficeSpecifications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeDetailsService {

    private final OfficeDetailsRepository officeDetailsRepository;

    public OfficeDetailsService(OfficeDetailsRepository officeDetailsRepository) {
        this.officeDetailsRepository = officeDetailsRepository;
    }

    public List<ListingResponse> search(OfficeSearchRequest request) {
        List<OfficeDetails> detailsList = officeDetailsRepository.findAll(
                OfficeSpecifications.filterByRequest(request)
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
                new ListingResponse.OfficeDetailsResponse(
                        details.getSubtype(),
                        details.getNetArea(),
                        details.getFloorNo(),
                        details.getBuildingAge(),
                        details.getRoomCount(),
                        details.getMeetingRoomCount(),
                        details.getFurnished(),
                        details.getAirConditioning(),
                        details.getParking(),
                        details.getBusinessCenter(),
                        details.getReception(),
                        details.getDeskCount(),
                        details.getPrivateOfficeCount(),
                        details.getWorkstationCount(),
                        details.getSoundIsolation(),
                        details.getMaintenanceFee(),
                        details.getInternetIncluded()
                ),
                null, null, null
        )).toList();
    }
}