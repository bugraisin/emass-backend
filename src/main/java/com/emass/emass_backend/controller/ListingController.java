package com.emass.emass_backend.controller;

import com.emass.emass_backend.model.dto.listing.ListingCreateRequest;
import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.details.search.CommercialSearchRequest;
import com.emass.emass_backend.model.dto.listing.details.search.HouseSearchRequest;
import com.emass.emass_backend.model.dto.listing.details.search.IndustrialSearchRequest;
import com.emass.emass_backend.model.dto.listing.details.search.OfficeSearchRequest;
import com.emass.emass_backend.service.ListingService;
import com.emass.emass_backend.service.details.CommercialDetailsService;
import com.emass.emass_backend.service.details.HousingDetailsService;
import com.emass.emass_backend.service.details.IndustrialDetailsService;
import com.emass.emass_backend.service.details.OfficeDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listings")
@RequiredArgsConstructor
public class ListingController {

    private final ListingService listingService;
    private final HousingDetailsService housingDetailsService;
    private final OfficeDetailsService officeDetailsService;
    private final CommercialDetailsService commercialDetailsService;
    private final IndustrialDetailsService industrialDetailsService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ListingResponse create(@Valid @RequestBody ListingCreateRequest request) {
        return listingService.create(request);
    }

    @GetMapping("/search/house")
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> search(@Valid @ModelAttribute HouseSearchRequest request) {
        return housingDetailsService.search(request);
    }

    @GetMapping("/search/office")
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> search(@Valid @ModelAttribute OfficeSearchRequest request) {
        return officeDetailsService.search(request);
    }

    @GetMapping("/search/commercial")
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> search(@Valid @ModelAttribute CommercialSearchRequest request) {
        return commercialDetailsService.search(request);
    }

    @GetMapping("/search/industrial")
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> search(@Valid @ModelAttribute IndustrialSearchRequest request) {
        return industrialDetailsService.search(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ListingResponse getById(@PathVariable Long id) {
        return listingService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> getAll() {
        return listingService.getAll();
    }

}