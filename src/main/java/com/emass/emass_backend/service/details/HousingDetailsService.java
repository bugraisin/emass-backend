package com.emass.emass_backend.service.details;

import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.details.search.HouseSearchRequest;
import com.emass.emass_backend.model.entity.listing.details.HousingDetails;
import com.emass.emass_backend.repository.details.HousingDetailsRepository;
import com.emass.emass_backend.service.details.specifications.HousingSpecifications;
import com.emass.emass_backend.service.mapper.ListingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HousingDetailsService {

    private final HousingDetailsRepository housingDetailsRepository;
    private final ListingMapper listingMapper;

    public List<ListingResponse> search(HouseSearchRequest request) {
        List<HousingDetails> detailsList = housingDetailsRepository.findAll(
                HousingSpecifications.filterByRequest(request)
        );

        return detailsList.stream()
                .map(details -> listingMapper.toSearchResponse(details.getListing()))
                .toList();
    }
}