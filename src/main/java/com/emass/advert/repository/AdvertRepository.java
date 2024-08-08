package com.emass.advert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertRepository extends JpaRepository<AdvertEntity, String> {
    List<AdvertEntity> findByUserId(String userId);
}
