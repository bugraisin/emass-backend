package com.emass.emass_backend.service.details;

import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.details.search.ServiceSearchRequest;
import com.emass.emass_backend.model.entity.listing.details.ServiceDetails;
import com.emass.emass_backend.repository.details.ServiceDetailsRepository;
import com.emass.emass_backend.service.details.specifications.ServiceSpecifications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDetailsService {

    private final ServiceDetailsRepository serviceDetailsRepository;

    public ServiceDetailsService(ServiceDetailsRepository serviceDetailsRepository) {
        this.serviceDetailsRepository = serviceDetailsRepository;
    }

    public List<ListingResponse> search(ServiceSearchRequest request) {
        List<ServiceDetails> detailsList = serviceDetailsRepository.findAll(
                ServiceSpecifications.filterByRequest(request)
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
                null,
                new ListingResponse.ServiceDetailsResponse(
                        details.getSubtype(),
                        details.getGrossArea(),
                        details.getNetArea(),
                        details.getCapacity(),
                        details.getSpaceType(),
                        details.getDeposit(),
                        details.getSecurity(),
                        details.getLighting(),
                        details.getCctv(),
                        details.getInternet(),
                        details.getReception(),
                        details.getRestRoom(),
                        details.getKitchen(),
                        details.getWashingArea(),
                        details.getMaintenanceArea(),
                        details.getAirConditioning(),
                        details.getVentilationSystem(),
                        details.getStorage(),
                        details.getOfficeArea(),
                        details.getCustomerParking()
                ),
                null
        )).toList();
    }
}
