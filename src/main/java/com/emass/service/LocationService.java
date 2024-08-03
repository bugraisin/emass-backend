package com.emass.service;

import com.emass.location.city.components.City;
import com.emass.location.city.components.District;
import com.emass.location.city.components.Neighbourhood;


import java.util.List;

public interface LocationService {

    List<City> getAllCities();

    List<District> getAllDistrictsByCity(City city);

    List<Neighbourhood> getAllNeighbourhoods(District district);

}
