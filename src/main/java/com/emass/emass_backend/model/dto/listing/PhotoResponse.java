package com.emass.emass_backend.model.dto.listing;

public record PhotoResponse(
        Long id,
        String imageUrl,
        Integer seqNumber
) {}
