package com.emass.location.city;

import com.emass.location.district.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/cities/{city_id}")
    public City getCity(@PathVariable Long city_id) {
        return cityService.getAllCities().stream()
                .filter(il -> il.getId() == city_id)
                .findFirst()
                .orElse(null);
    }

}
