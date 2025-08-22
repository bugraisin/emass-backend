package com.emass.emass_backend.repository;

import com.emass.emass_backend.model.entity.location.District;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
    District findByName(String name);
    List<District> findByProvinceId(Long provinceId);
}