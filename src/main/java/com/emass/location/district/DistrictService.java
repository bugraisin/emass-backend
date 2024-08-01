package com.emass.location.district;

import com.emass.location.city.response.CityResponse;
import com.emass.location.district.response.DistrictResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class DistrictService {

    private final RestTemplate restTemplate;

    public DistrictService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    public List<District> getDistricts() {
        String url = "https://turkiyeapi.herokuapp.com/api/v1/districts";
        DistrictResponse response = restTemplate.getForObject(url, DistrictResponse.class);
        return Objects.requireNonNull(response).getData();
    }


}
