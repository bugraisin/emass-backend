package com.emass.emass_backend.service.details;

import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.details.search.*;
import com.emass.emass_backend.model.entity.listing.details.PropertyDetails;
import com.emass.emass_backend.repository.details.*;
import com.emass.emass_backend.service.details.specifications.*;
import com.emass.emass_backend.service.mapper.ListingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertySearchService {

    private final ListingMapper listingMapper;
    private final HousingDetailsRepository housingDetailsRepository;
    private final CommercialDetailsRepository commercialDetailsRepository;
    private final OfficeDetailsRepository officeDetailsRepository;
    private final IndustrialDetailsRepository industrialDetailsRepository;
    private final ServiceDetailsRepository serviceDetailsRepository;
    private final LandDetailsRepository landDetailsRepository;

    public List<ListingResponse> searchHousing(HouseSearchRequest request) {
        return search(housingDetailsRepository, HousingSpecifications.filterByRequest(request));
    }

    public List<ListingResponse> searchCommercial(CommercialSearchRequest request) {
        return search(commercialDetailsRepository, CommercialSpecifications.filterByRequest(request));
    }

    public List<ListingResponse> searchOffice(OfficeSearchRequest request) {
        return search(officeDetailsRepository, OfficeSpecifications.filterByRequest(request));
    }

    public List<ListingResponse> searchIndustrial(IndustrialSearchRequest request) {
        return search(industrialDetailsRepository, IndustrialSpecifications.filterByRequest(request));
    }

    public List<ListingResponse> searchService(ServiceSearchRequest request) {
        return search(serviceDetailsRepository, ServiceSpecifications.filterByRequest(request));
    }

    public List<ListingResponse> searchLand(LandSearchRequest request) {
        return search(landDetailsRepository, LandSpecifications.filterByRequest(request));
    }

    private <T extends PropertyDetails> List<ListingResponse> search(
            JpaSpecificationExecutor<T> repository,
            Specification<T> specification) {

        List<T> detailsList = repository.findAll(specification);

        return detailsList.stream()
                .map(details -> listingMapper.toSearchResponse(details.getListing()))
                .toList();
    }
}
