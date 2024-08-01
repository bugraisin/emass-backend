package com.emass.location.city;

import com.emass.service.CityService;
import com.emass.location.city.response.CityResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class CityServiceImpl implements CityService {
    private final RestTemplate restTemplate;

    public CityServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<City> getAllCities() {
        String url = "https://turkiyeapi.herokuapp.com/api/v1/provinces";
        CityResponse response = restTemplate.getForObject(url, CityResponse.class);
        return response.getData();
    }


}
