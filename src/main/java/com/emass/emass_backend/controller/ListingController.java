package com.emass.emass_backend.controller;

import com.emass.emass_backend.model.dto.listing.ListingCreateRequest;
import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.details.search.HouseSearchRequest;
import com.emass.emass_backend.model.dto.listing.details.search.OfficeSearchRequest;
import com.emass.emass_backend.service.ListingService;
import com.emass.emass_backend.service.details.HousingDetailsService;
import com.emass.emass_backend.service.details.OfficeDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/listings")
@RequiredArgsConstructor
public class ListingController {

    private final ListingService listingService;
    private final HousingDetailsService housingDetailsService;
    private final OfficeDetailsService officeDetailsService;

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