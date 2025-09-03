package com.emass.emass_backend.controller;

import com.emass.emass_backend.model.dto.listing.ListingCreateRequest;
import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.dto.listing.details.search.*;
import com.emass.emass_backend.service.ListingService;
import com.emass.emass_backend.service.details.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.emass.emass_backend.config.RestApis.*;

@RestController
@RequestMapping(LISTINGS_BASE)
@RequiredArgsConstructor
@CrossOrigin("*")
public class ListingController {

    private final ListingService listingService;
    private final HousingDetailsService housingDetailsService;
    private final OfficeDetailsService officeDetailsService;
    private final CommercialDetailsService commercialDetailsService;
    private final IndustrialDetailsService industrialDetailsService;
    private final ServiceDetailsService serviceDetailsService;
    private final LandDetailsService landDetailsService;

    @PostMapping(CREATE_LISTING)
    @ResponseStatus(HttpStatus.CREATED)
    public ListingResponse create(@Valid @RequestBody ListingCreateRequest request) {
        return listingService.create(request);
    }

    @GetMapping(SEARCH_HOUSE)
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> search(@Valid @ModelAttribute HouseSearchRequest request) {
        return housingDetailsService.search(request);
    }

    @GetMapping(SEARCH_OFFICE)
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> search(@Valid @ModelAttribute OfficeSearchRequest request) {
        return officeDetailsService.search(request);
    }

    @GetMapping(SEARCH_COMMERCIAL)
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> search(@Valid @ModelAttribute CommercialSearchRequest request) {
        return commercialDetailsService.search(request);
    }

    @GetMapping(SEARCH_INDUSTRIAL)
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> search(@Valid @ModelAttribute IndustrialSearchRequest request) {
        return industrialDetailsService.search(request);
    }

    @GetMapping(SEARCH_SERVICE)
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> search(@Valid @ModelAttribute ServiceSearchRequest request) {
        return serviceDetailsService.search(request);
    }

    @GetMapping(SEARCH_LAND)
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> search(@Valid @ModelAttribute LandSearchRequest request) {
        return landDetailsService.search(request);
    }

    @GetMapping(GET_LISTING_BY_ID)
    @ResponseStatus(HttpStatus.OK)
    public ListingResponse getById(@PathVariable Long id) {
        return listingService.getById(id);
    }

    @GetMapping(GET_ALL_LISTINGS)
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponse> getAll() {
        return listingService.getAll();
    }

    @DeleteMapping(DELETE_LISTING_BY_ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteListing(@PathVariable Long id) {
        listingService.deleteListing(id);
    }
}