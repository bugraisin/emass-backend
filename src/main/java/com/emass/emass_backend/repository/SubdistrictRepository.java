package com.emass.emass_backend.repository;


import com.emass.emass_backend.model.entity.Subdistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubdistrictRepository extends JpaRepository<Subdistrict, Integer> {
    Subdistrict findByName(String name);
    List<Subdistrict> findSubdistrictByDistrictId(Long districtId);
}
