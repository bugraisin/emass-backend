package com.emass.emass_backend.controller;

import com.emass.emass_backend.model.dto.listing.ListingCreateRequest;
import com.emass.emass_backend.model.dto.listing.ListingDetailResponse;
import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.PhotoResponse;
import com.emass.emass_backend.model.dto.listing.details.search.*;
import com.emass.emass_backend.model.entity.enums.ListingStatus;
import com.emass.emass_backend.service.ListingService;
import com.emass.emass_backend.service.PhotoService;
import com.emass.emass_backend.service.details.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/listings")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ListingController {

    private final ListingService listingService;
    private final PropertySearchService propertySearchService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ListingDetailResponse create(@Valid @RequestBody ListingCreateRequest request) {
        return listingService.create(request);
    }

    @GetMapping("/house")
    public List<ListingResponse> searchHouse(@ModelAttribute HouseSearchRequest request) {
        return propertySearchService.searchHousing(request);
    }

    @GetMapping("/commercial")
    public List<ListingResponse> searchCommercial(@ModelAttribute CommercialSearchRequest request) {
        return propertySearchService.searchCommercial(request);
    }

    @GetMapping("/office")
    public List<ListingResponse> searchOffice(@ModelAttribute OfficeSearchRequest request) {
        return propertySearchService.searchOffice(request);
    }

    @GetMapping("/industrial")
    public List<ListingResponse> searchIndustrial(@ModelAttribute IndustrialSearchRequest request) {
        return propertySearchService.searchIndustrial(request);
    }

    @GetMapping("/service")
    public List<ListingResponse> searchService(@ModelAttribute ServiceSearchRequest request) {
        return propertySearchService.searchService(request);
    }

    @GetMapping("/land")
    public List<ListingResponse> searchLand(@ModelAttribute LandSearchRequest request) {
        return propertySearchService.searchLand(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ListingDetailResponse getById(@PathVariable Long id) {
        return listingService.getById(id);
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> getByUserId(@PathVariable Long userId) {
        return listingService.getByUserId(userId);
    }

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> getAll() {
        return listingService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteListing(@PathVariable Long id) {
        listingService.deleteListing(id);
    }

    @PutMapping("/{id}/publish")
    @ResponseStatus(HttpStatus.OK)
    public void publishListing(@PathVariable Long id) {
        listingService.updateListingStatus(id, ListingStatus.PUBLISHED);
    }

    @PutMapping("/{id}/unpublish")
    @ResponseStatus(HttpStatus.OK)
    public void unpublishListing(@PathVariable Long id) {
        listingService.updateListingStatus(id, ListingStatus.NON_PUBLISHED);
    }

    @PutMapping("/{id}/toggle-status")
    @ResponseStatus(HttpStatus.OK)
    public void toggleListingStatus(@PathVariable Long id) {
        listingService.toggleListingStatus(id);
    }
}