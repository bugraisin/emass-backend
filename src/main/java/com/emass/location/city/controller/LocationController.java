package com.emass.location.city.controller;

import com.emass.location.city.components.City;
import com.emass.location.city.components.District;
import com.emass.location.city.LocationServiceImpl;
import com.emass.location.city.components.Neighbourhood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    private final City city;
    private final District district;
    private final LocationServiceImpl locationServiceImpl;

    @Autowired
    public LocationController(LocationServiceImpl locationServiceImpl) {
        this.locationServiceImpl = locationServiceImpl;
        city = new City();
        district = new District();
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

    @PostMapping("/selected_city")
    public void postSelectedCity(@RequestBody City city) {
        this.city.setId(city.getId());
        this.city.setName(city.getName());
        System.out.println("Received city ID: " + this.city.getId() + ", City Name: " + this.city.getName());
    }

    @GetMapping("/districts")
    public List<District> getAllDistrictsByCity() {
        return locationServiceImpl.getAllDistrictsByCity(this.city);
    }

    @PostMapping("/selected_district")
    public void postSelectedCity(@RequestBody District district) {
        district.setId(district.getId());
        district.setName(district.getName());
        System.out.println("Received ID: " + district.getId() + ", Name: " + district.getName());
    }

    @GetMapping("/neighbourhoods")
    public List<Neighbourhood> getAllNeighbourhood() {
        return locationServiceImpl.getAllNeighbourhoods(this.district);
    }

    @PostMapping("/selected_neighbourhood")
    public void postSelectedCity(@RequestBody Neighbourhood neighbourhood) {
        neighbourhood.setId(neighbourhood.getId());
        neighbourhood.setName(neighbourhood.getName());
        System.out.println("Received ID: " + neighbourhood.getId() + ", Name: " + neighbourhood.getName());
    }


}
