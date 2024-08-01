package com.emass.location.district;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistrictController {

    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping("/districts")
    public List<District> getDistricts() {
        return districtService.getDistricts();
    }

    @GetMapping("/districts/{district_id}")
    public District getDistrict(@PathVariable Long district_id) {
        return districtService.getDistricts().stream()
                .filter(tmp -> tmp.getId() == district_id)
                .findFirst()
                .orElse(null);
    }
}
