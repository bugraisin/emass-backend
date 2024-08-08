package com.emass.advert;

import com.emass.advert.repository.AdvertEntity;
import com.emass.advert.repository.AdvertRepository;
import com.emass.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertServiceImpl implements AdvertService {

    @Autowired
    private AdvertRepository advertRepository;

    @Override
    public List<AdvertEntity> findAll() {
        return advertRepository.findAll();
    }

    @Override
    public AdvertEntity findById(String id) {
        return advertRepository.findById(id).orElse(null);
    }

    @Override
    public AdvertEntity save(AdvertEntity advert) {
        return advertRepository.save(advert);
    }

    @Override
    public void deleteById(String id) {
        advertRepository.deleteById(id);
    }

    @Override
    public List<AdvertEntity> getUserAdverts(String userId) {
        return advertRepository.findByUserId(userId);
    }

    @Override
    public Optional<AdvertEntity> updateAdvert(String advertId, String userId, AdvertEntity updatedAdvert) {
        Optional<AdvertEntity> advert = advertRepository.findById(advertId);

        if (advert.isPresent() && advert.get().getUser().getId().equals(userId)) {
            AdvertEntity advertEntity = advert.get();
            advertEntity.setTitle(updatedAdvert.getTitle());
            advertEntity.setDescription(updatedAdvert.getDescription());
            advertRepository.save(advertEntity);
            return Optional.of(advertEntity);
        } else {
            return Optional.empty();
        }
    }
}
