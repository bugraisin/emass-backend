package com.emass.emass_backend.service;

import com.emass.emass_backend.model.dto.listing.ListingCreateRequest;
import com.emass.emass_backend.model.dto.listing.ListingDetailResponse;
import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.ListingPhoto;
import com.emass.emass_backend.model.entity.listing.details.*;
import com.emass.emass_backend.repository.ListingPhotoRepository;
import com.emass.emass_backend.repository.ListingRepository;
import com.emass.emass_backend.repository.UserRepository;
import com.emass.emass_backend.repository.details.*;
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

    private final HousingDetailsRepository housingDetailsRepository;
    private final CommercialDetailsRepository commercialDetailsRepository;
    private final OfficeDetailsRepository officeDetailsRepository;
    private final IndustrialDetailsRepository industrialDetailsRepository;
    private final ServiceDetailsRepository serviceDetailsRepository;
    private final LandDetailsRepository landDetailsRepository;
    private final ListingPhotoRepository listingPhotoRepository;

    private final ListingMapper listingMapper;
    private final ListingDetailsMapper detailsMapper;

    @Transactional
    public ListingDetailResponse create(ListingCreateRequest req) {

        var owner = userRepository.findById(req.ownerId())
                .orElseThrow(() -> new IllegalArgumentException("Owner not found: " + req.ownerId()));

        Listing listing = listingMapper.toListingEntity(req);
        listing.setOwner(owner);
        Listing saved = listingRepository.save(listing);

        // YENİ: 6 kategori için switch-case
        return switch (req.propertyType()) {
            case KONUT -> {
                HousingDetails d = detailsMapper.toEntity(saved, req.housingDetails());
                if (d != null) housingDetailsRepository.save(d);
                yield listingMapper.toResponse(saved, d);
            }
            case TICARI -> {
                CommercialDetails d = detailsMapper.toEntity(saved, req.commercialDetails());
                if (d != null) commercialDetailsRepository.save(d);
                yield listingMapper.toResponse(saved, d);
            }
            case OFIS -> {
                OfficeDetails d = detailsMapper.toEntity(saved, req.officeDetails());
                if (d != null) officeDetailsRepository.save(d);
                yield listingMapper.toResponse(saved, d);
            }
            case ENDUSTRIYEL -> {
                IndustrialDetails d = detailsMapper.toEntity(saved, req.industrialDetails());
                if (d != null) industrialDetailsRepository.save(d);
                yield listingMapper.toResponse(saved, d);
            }
            case HIZMET -> {
                ServiceDetails d = detailsMapper.toEntity(saved, req.serviceDetails());
                if (d != null) serviceDetailsRepository.save(d);
                yield listingMapper.toResponse(saved, d);
            }
            case ARSA -> {
                LandDetails d = detailsMapper.toEntity(saved, req.landDetails());
                if (d != null) landDetailsRepository.save(d);
                yield listingMapper.toResponse(saved, d);
            }
        };
    }

    @Transactional(readOnly = true)
    public ListingDetailResponse getById(Long id) {
        Listing listing = listingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Listing not found: " + id));

        List<ListingPhoto> photos = listingPhotoRepository.findByListingIdOrderBySeqNumberAsc(id);
        listing.setPhotos(photos);

        // YENİ: 6 kategori için switch-case
        return switch (listing.getPropertyType()) {
            case KONUT -> {
                HousingDetails d = housingDetailsRepository.findByListingId(id).orElse(null);
                yield listingMapper.toResponse(listing, d);
            }
            case TICARI -> {
                CommercialDetails d = commercialDetailsRepository.findByListingId(id).orElse(null);
                yield listingMapper.toResponse(listing, d);
            }
            case OFIS -> {
                OfficeDetails d = officeDetailsRepository.findByListingId(id).orElse(null);
                yield listingMapper.toResponse(listing, d);
            }
            case ENDUSTRIYEL -> {
                IndustrialDetails d = industrialDetailsRepository.findByListingId(id).orElse(null);
                yield listingMapper.toResponse(listing, d);
            }
            case HIZMET -> {
                ServiceDetails d = serviceDetailsRepository.findByListingId(id).orElse(null);
                yield listingMapper.toResponse(listing, d);
            }
            case ARSA -> {
                LandDetails d = landDetailsRepository.findByListingId(id).orElse(null);
                yield listingMapper.toResponse(listing, d);
            }
        };
    }

    public List<ListingResponse> getAll() {
        List<Listing> listings = listingRepository.findAll();

        return listings.stream()
                .map(listingMapper::toSearchResponse)
                .toList();
    }

    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }
}