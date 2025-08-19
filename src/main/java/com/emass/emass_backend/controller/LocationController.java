package com.emass.emass_backend.controller;

import com.emass.emass_backend.model.entity.District;
import com.emass.emass_backend.model.entity.Neighborhood;
import com.emass.emass_backend.model.entity.Province;
import com.emass.emass_backend.model.entity.Subdistrict;
import com.emass.emass_backend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/provinces")
    public List<Province> getAllProvinces() {
        return locationService.getAllProvinces();
    }

    @GetMapping("/{provinceId}/districts")
    public List<District> getDistrictsByProvince(@PathVariable Long provinceId) {
        return locationService.getDistrictsByProvinceId(provinceId);
    }

    @GetMapping("/{districtId}/subdistricts")
    public List<Subdistrict> getSubdistrictsByDistrict(@PathVariable Long districtId) {
        return locationService.getSubdistrictsByDistrict(districtId);
    }

    @GetMapping("/{subdistrictId}/neighborhoods")
    public List<Neighborhood> getNeighborhoodsBySubdistrict(@PathVariable Long subdistrictId) {
        return locationService.getNeighborhoodsBySubdistrict(subdistrictId);
    }
}
