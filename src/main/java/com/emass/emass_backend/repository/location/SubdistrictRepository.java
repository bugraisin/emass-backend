package com.emass.emass_backend.repository.location;


import com.emass.emass_backend.model.entity.location.Subdistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubdistrictRepository extends JpaRepository<Subdistrict, Integer> {
    Subdistrict findByName(String name);
    List<Subdistrict> findSubdistrictByDistrictId(Long districtId);
}
