package com.emass.service;

import com.emass.location.components.City;
import com.emass.location.components.District;
import com.emass.location.components.Neighbourhood;


import java.util.List;

public interface LocationService {

    List<City> getAllCities();

    List<District> getAllDistrictsByCity(City city);

    List<Neighbourhood> getAllNeighbourhoodsByDistrict(District district);

}
