package com.emass.location.city;

import com.emass.location.city.components.City;
import com.emass.location.city.components.District;
import com.emass.location.city.components.Neighbourhood;
import com.emass.location.city.response.DistrictResponse;
import com.emass.service.LocationService;
import com.emass.location.city.response.CityResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    private final RestTemplate restTemplate;

    public LocationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<City> getAllCities() {
        String url = "https://turkiyeapi.herokuapp.com/api/v1/provinces";
        CityResponse response = restTemplate.getForObject(url, CityResponse.class);
        return response.getData();
    }

    @Override
    public List<District> getAllDistrictsByCity(City city) {
        String url = "https://turkiyeapi.herokuapp.com/api/v1/districts";
        DistrictResponse response = restTemplate.getForObject(url, DistrictResponse.class);
        return response.getData().stream()
                .filter(district -> district.getProvince().equalsIgnoreCase(city.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Neighbourhood> getAllNeighbourhoods(District district) {
        return List.of();
    }


}
