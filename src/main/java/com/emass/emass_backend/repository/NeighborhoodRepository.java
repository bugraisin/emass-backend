package com.emass.emass_backend.repository;

import com.emass.emass_backend.model.entity.location.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long> {
    Neighborhood findByName(String name);
    List<Neighborhood> findBySubdistrictId(Long subdistrictId);
}
