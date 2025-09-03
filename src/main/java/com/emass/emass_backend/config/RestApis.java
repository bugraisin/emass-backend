package com.emass.emass_backend.config;

public class RestApis {

    // Base paths
    public static final String LISTINGS_BASE = "/api/listings";

    // Listing operations
    public static final String CREATE_LISTING = "/create";
    public static final String GET_LISTING_BY_ID = "/{id}";
    public static final String GET_ALL_LISTINGS = "/get-all";

    // Search endpoints
    public static final String SEARCH_HOUSE = "/search/house";
    public static final String SEARCH_OFFICE = "/search/office";
    public static final String SEARCH_COMMERCIAL = "/search/commercial";
    public static final String SEARCH_INDUSTRIAL = "/search/industrial";
    public static final String SEARCH_SERVICE = "/search/service";
    public static final String SEARCH_LAND = "/search/land";
    public static final String DELETE_LISTING_BY_ID = "/{id}";
}
