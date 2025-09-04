package com.emass.emass_backend.model.dto.listing;

import com.emass.emass_backend.model.entity.enums.ListingStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ListingResponse (
    Long id,
    Long ownerId,
    String title,
    String description,
    ListingStatus status,
    BigDecimal price,
    String city,
    String district,
    String neighborhood,
    Double latitude,
    Double longitude,
    LocalDateTime createdAt,
    String thumbnailUrl
){}
