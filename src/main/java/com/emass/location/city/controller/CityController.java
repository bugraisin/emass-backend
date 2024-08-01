package com.emass.location.city.controller;

import com.emass.location.city.City;
import com.emass.location.city.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    private final CityServiceImpl cityServiceImpl;

    @Autowired
    public CityController(CityServiceImpl cityServiceImpl) {
        this.cityServiceImpl = cityServiceImpl;
    }

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityServiceImpl.getAllCities();
    }

    @GetMapping("/cities/{city_id}")
    public City getCity(@PathVariable Long city_id) {
        return cityServiceImpl.getAllCities().stream()
                .filter(il -> il.getId() == city_id)
                .findFirst()
                .orElse(null);
    }

}
