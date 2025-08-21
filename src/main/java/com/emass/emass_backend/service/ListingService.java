package com.emass.emass_backend.service;

import com.emass.emass_backend.model.dto.listing.ListingCreateRequest;
import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.entity.Listing;
import com.emass.emass_backend.model.entity.details.HousingDetails;
import com.emass.emass_backend.model.entity.details.LandDetails;
import com.emass.emass_backend.model.entity.details.WorkplaceDetails;
import com.emass.emass_backend.model.entity.enums.PropertyType;
import com.emass.emass_backend.repository.ListingRepository;
import com.emass.emass_backend.repository.UserRepository;
import com.emass.emass_backend.repository.details.HousingDetailsRepository;
import com.emass.emass_backend.repository.details.LandDetailsRepository;
import com.emass.emass_backend.repository.details.WorkplaceDetailsRepository;
import com.emass.emass_backend.service.mapper.ListingDetailsMapper;
import com.emass.emass_backend.service.mapper.ListingMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListingService {

    private final UserRepository userRepository;
    private final ListingRepository listingRepository;
    private final HousingDetailsRepository housingDetailsRepository;
    private final WorkplaceDetailsRepository workplaceDetailsRepository;
    private final LandDetailsRepository landDetailsRepository;

    private final ListingMapper listingMapper;
    private final ListingDetailsMapper detailsMapper;

    @Transactional
    public ListingResponse create(ListingCreateRequest req) {

        var owner = userRepository.findById(req.ownerId())
                .orElseThrow(() -> new IllegalArgumentException("Owner not found: " + req.ownerId()));

        Listing listing = listingMapper.toListingEntity(req);
        listing.setOwner(owner);
        Listing saved = listingRepository.save(listing);

        if (req.propertyType() == PropertyType.KONUT) {
            HousingDetails d = detailsMapper.toEntity(saved, req.housingDetails());
            if (d != null) housingDetailsRepository.save(d);
            return listingMapper.toResponse(saved, d);

        } else if (req.propertyType() == PropertyType.ISYERI) {
            WorkplaceDetails d = detailsMapper.toEntity(saved, req.workplaceDetails());
            if (d != null) workplaceDetailsRepository.save(d);
            return listingMapper.toResponse(saved, d);

        } else if (req.propertyType() == PropertyType.ARSA) {
            LandDetails d = detailsMapper.toEntity(saved, req.landDetails());
            if (d != null) landDetailsRepository.save(d);
            return listingMapper.toResponse(saved, d);
        }

        throw new IllegalArgumentException("Unsupported property type: " + req.propertyType());
    }

    public ListingResponse getById(Long id) {
        Listing listing = listingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Listing not found: " + id));

        if (listing.getPropertyType() == PropertyType.KONUT) {
            HousingDetails d = housingDetailsRepository.findByListingId(id).orElse(null);
            return listingMapper.toResponse(listing, d);

        } else if (listing.getPropertyType() == PropertyType.ISYERI) {
            WorkplaceDetails d = workplaceDetailsRepository.findByListingId(id).orElse(null);
            return listingMapper.toResponse(listing, d);

        } else if (listing.getPropertyType() == PropertyType.ARSA) {
            LandDetails d = landDetailsRepository.findByListingId(id).orElse(null);
            return listingMapper.toResponse(listing, d);
        }

        throw new IllegalArgumentException("Unsupported property type: " + listing.getPropertyType());
    }

    public List<ListingResponse> getAll() {
        List<Listing> listings = listingRepository.findAll();

        return listings.stream().map(listing -> {
            Long id = listing.getId();

            if (listing.getPropertyType() == PropertyType.KONUT) {
                HousingDetails d = housingDetailsRepository.findByListingId(id).orElse(null);
                return listingMapper.toResponse(listing, d);

            } else if (listing.getPropertyType() == PropertyType.ISYERI) {
                WorkplaceDetails d = workplaceDetailsRepository.findByListingId(id).orElse(null);
                return listingMapper.toResponse(listing, d);

            } else if (listing.getPropertyType() == PropertyType.ARSA) {
                LandDetails d = landDetailsRepository.findByListingId(id).orElse(null);
                return listingMapper.toResponse(listing, d);
            }

            throw new IllegalArgumentException("Unsupported property type: " + listing.getPropertyType());
        }).toList();
    }

}
