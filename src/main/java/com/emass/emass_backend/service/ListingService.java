package com.emass.emass_backend.service;

import com.emass.emass_backend.model.dto.listing.ListingCreateRequest;
import com.emass.emass_backend.model.dto.listing.ListingDetailResponse;
import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.*;
import com.emass.emass_backend.repository.listing.ListingRepository;
import com.emass.emass_backend.repository.user.UserRepository;
import com.emass.emass_backend.service.mapper.ListingDetailsMapper;
import com.emass.emass_backend.service.mapper.ListingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListingService {

    private final UserRepository userRepository;
    private final ListingRepository listingRepository;
    private final ListingMapper listingMapper;
    private final ListingDetailsMapper detailsMapper;

    @Transactional
    public ListingDetailResponse create(ListingCreateRequest req) {
        var owner = userRepository.findById(req.ownerId())
                .orElseThrow(() -> new IllegalArgumentException("Owner not found: " + req.ownerId()));

        Listing listing = listingMapper.toListingEntity(req);
        listing.setOwner(owner);

        attachDetailsToListing(listing, req);

        Listing saved = listingRepository.save(listing);

        PropertyDetails details = getDetailsFromListing(saved);
        return listingMapper.toResponse(saved, details);
    }

    @Transactional(readOnly = true)
    public ListingDetailResponse getById(Long id) {
        Listing listing = listingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Listing not found: " + id));

        PropertyDetails details = getDetailsFromListing(listing);

        return listingMapper.toResponse(listing, details);
    }

    @Transactional(readOnly = true)
    public List<ListingResponse> getByUserId(Long id) {
        List<Listing> listings = listingRepository.findByOwnerId(id);

        return listings.stream()
                .map(listingMapper::toSearchResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ListingResponse> getAll() {
        List<Listing> listings = listingRepository.findAll();

        return listings.stream()
                .map(listingMapper::toSearchResponse)
                .toList();
    }

    @Transactional
    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }

    private void attachDetailsToListing(Listing listing, ListingCreateRequest req) {
        switch (req.propertyType()) {
            case KONUT -> {
                if (req.housingDetails() != null) {
                    HousingDetails details = detailsMapper.toEntity(listing, req.housingDetails());
                    listing.setHousingDetails(details);
                }
            }
            case TICARI -> {
                if (req.commercialDetails() != null) {
                    CommercialDetails details = detailsMapper.toEntity(listing, req.commercialDetails());
                    listing.setCommercialDetails(details);
                }
            }
            case OFIS -> {
                if (req.officeDetails() != null) {
                    OfficeDetails details = detailsMapper.toEntity(listing, req.officeDetails());
                    listing.setOfficeDetails(details);
                }
            }
            case ENDUSTRIYEL -> {
                if (req.industrialDetails() != null) {
                    IndustrialDetails details = detailsMapper.toEntity(listing, req.industrialDetails());
                    listing.setIndustrialDetails(details);
                }
            }
            case HIZMET -> {
                if (req.serviceDetails() != null) {
                    ServiceDetails details = detailsMapper.toEntity(listing, req.serviceDetails());
                    listing.setServiceDetails(details);
                }
            }
            case ARSA -> {
                if (req.landDetails() != null) {
                    LandDetails details = detailsMapper.toEntity(listing, req.landDetails());
                    listing.setLandDetails(details);
                }
            }
        }
    }

    private PropertyDetails getDetailsFromListing(Listing listing) {
        return switch (listing.getPropertyType()) {
            case KONUT -> listing.getHousingDetails();
            case TICARI -> listing.getCommercialDetails();
            case OFIS -> listing.getOfficeDetails();
            case ENDUSTRIYEL -> listing.getIndustrialDetails();
            case HIZMET -> listing.getServiceDetails();
            case ARSA -> listing.getLandDetails();
        };
    }

}