package com.emass.service;

import com.emass.advert.repository.AdvertEntity;

import java.util.List;
import java.util.Optional;

public interface AdvertService {

    List<AdvertEntity> findAll();
    AdvertEntity findById(String id);
    AdvertEntity save(AdvertEntity advert);
    void deleteById(String id);
    List<AdvertEntity> getUserAdverts(String userId);
    Optional<AdvertEntity> updateAdvert(String advertId, String userId, AdvertEntity updatedAdvert);
}
