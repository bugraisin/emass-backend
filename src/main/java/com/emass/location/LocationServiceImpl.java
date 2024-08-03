package com.emass.location;

import com.emass.location.components.City;
import com.emass.location.components.District;
import com.emass.location.components.Neighbourhood;
import com.emass.location.response.DistrictResponse;
import com.emass.location.response.NeighbourhoodResponse;
import com.emass.service.LocationService;
import com.emass.location.response.CityResponse;
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
    public List<Neighbourhood> getAllNeighbourhoodsByDistrict(District district) {
        String url = "https://turkiyeapi.herokuapp.com/api/v1/neighborhoods";
        NeighbourhoodResponse response = restTemplate.getForObject(url, NeighbourhoodResponse.class);
        return response.getData().stream()
                .filter(neighbourhood -> neighbourhood.getDistrict().equalsIgnoreCase(district.getName()))
                .collect(Collectors.toList());
    }


}
