package com.emass.emass_backend.service;

import com.emass.emass_backend.model.entity.District;
import com.emass.emass_backend.model.entity.Neighborhood;
import com.emass.emass_backend.model.entity.Province;
import com.emass.emass_backend.model.entity.Subdistrict;
import com.emass.emass_backend.repository.DistrictRepository;
import com.emass.emass_backend.repository.NeighborhoodRepository;
import com.emass.emass_backend.repository.ProvinceRepository;
import com.emass.emass_backend.repository.SubdistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final ProvinceRepository provinceRepository;
    private final DistrictRepository districtRepository;
    private final SubdistrictRepository subdistrictRepository;
    private final NeighborhoodRepository neighborhoodRepository;

    public LocationService(
            ProvinceRepository provinceRepository,
            DistrictRepository districtRepository,
            SubdistrictRepository subdistrictRepository,
            NeighborhoodRepository neighborhoodRepository
    ) {
        this.provinceRepository = provinceRepository;
        this.districtRepository = districtRepository;
        this.subdistrictRepository = subdistrictRepository;
        this.neighborhoodRepository = neighborhoodRepository;
    }

    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    public List<District> getDistrictsByProvinceId(Long provinceId) {
        return districtRepository.findByProvinceId(provinceId);
    }

    public List<Subdistrict> getSubdistrictsByDistrict(Long districtId) {
        return subdistrictRepository.findSubdistrictByDistrictId(districtId);
    }

    public List<Neighborhood> getNeighborhoodsBySubdistrict(Long subdistrictId) {
        return neighborhoodRepository.findBySubdistrictId(subdistrictId);
    }
}
