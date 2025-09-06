package com.emass.emass_backend.controller;

import com.emass.emass_backend.model.dto.listing.ListingCreateRequest;
import com.emass.emass_backend.model.dto.listing.ListingDetailResponse;
import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.details.search.*;
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
    private final PhotoService photoService;
    private final PropertySearchService propertySearchService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ListingDetailResponse create(@Valid @RequestBody ListingCreateRequest request) {
        return listingService.create(request);
    }

    @PostMapping("/{listingId}/photos")
    @ResponseStatus(HttpStatus.OK)
    public void uploadPhotos(
            @PathVariable Long listingId,
            @RequestParam("photos") List<MultipartFile> photos) {

        photoService.uploadPhotos(listingId, photos);
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
}