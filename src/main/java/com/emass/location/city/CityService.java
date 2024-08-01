package com.emass.location.city;

import com.emass.location.city.response.CityResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class CityService {
    private final RestTemplate restTemplate;

    public CityService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<City> getAllCities() {
        String url = "https://turkiyeapi.herokuapp.com/api/v1/provinces";
        CityResponse response = restTemplate.getForObject(url, CityResponse.class);
        return Objects.requireNonNull(response).getData();
    }


}
