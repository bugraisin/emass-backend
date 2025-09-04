package com.emass.emass_backend.service.details;

import com.emass.emass_backend.model.dto.listing.ListingDetailResponse;
import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.details.search.IndustrialSearchRequest;
import com.emass.emass_backend.model.entity.listing.details.HousingDetails;
import com.emass.emass_backend.model.entity.listing.details.IndustrialDetails;
import com.emass.emass_backend.repository.details.IndustrialDetailsRepository;
import com.emass.emass_backend.service.details.specifications.HousingSpecifications;
import com.emass.emass_backend.service.details.specifications.IndustrialSpecifications;
import com.emass.emass_backend.service.mapper.ListingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndustrialDetailsService {

    private final IndustrialDetailsRepository industrialDetailsRepository;
    private final ListingMapper listingMapper;

    public List<ListingResponse> search(IndustrialSearchRequest request) {
        List<IndustrialDetails> detailsList = industrialDetailsRepository.findAll(
                IndustrialSpecifications.filterByRequest(request)
        );

        return detailsList.stream()
                .map(details -> listingMapper.toSearchResponse(details.getListing()))
                .toList();
    }
}
