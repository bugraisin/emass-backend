package com.emass.location.controller;

import com.emass.location.components.City;
import com.emass.location.components.District;
import com.emass.location.LocationServiceImpl;
import com.emass.location.components.Neighbourhood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    private final City city;
    private final District district;
    private final Neighbourhood neighbourhood;
    private final LocationServiceImpl locationServiceImpl;

    @Autowired
    public LocationController(LocationServiceImpl locationServiceImpl) {
        this.locationServiceImpl = locationServiceImpl;
        city = new City();
        district = new District();
        neighbourhood = new Neighbourhood();
    }

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return locationServiceImpl.getAllCities();
    }

    @GetMapping("/cities/{city_id}")
    public City getCity(@PathVariable Long city_id) {
        return locationServiceImpl.getAllCities().stream()
                .filter(il -> il.getId().equals(city_id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/selected-city")
    public void postSelectedCity(@RequestBody City city) {
        this.city.setId(city.getId());
        this.city.setName(city.getName());
    }

    @GetMapping("/districts")
    public List<District> getAllDistricts() {
        return locationServiceImpl.getAllDistrictsByCity(this.city);
    }

    @PostMapping("/selected-district")
    public void postSelectedDistrict(@RequestBody District district) {
        this.district.setId(district.getId());
        this.district.setName(district.getName());
        this.district.setProvince(district.getProvince());
    }

    @GetMapping("/neighbourhoods")
    public List<Neighbourhood> getAllNeighbourhood() {
        return locationServiceImpl.getAllNeighbourhoodsByDistrict(this.district);
    }

    @PostMapping("/selected-neighbourhood")
    public void postSelectedNeighbourhood(@RequestBody Neighbourhood neighbourhood) {
        this.neighbourhood.setId(neighbourhood.getId());
        this.neighbourhood.setName(neighbourhood.getName());
        this.neighbourhood.setDistrict(neighbourhood.getDistrict());
    }


}
