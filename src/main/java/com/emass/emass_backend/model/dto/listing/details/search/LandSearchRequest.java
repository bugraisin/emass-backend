package com.emass.emass_backend.model.dto.listing.details.search;

import com.emass.emass_backend.model.entity.enums.LandSubtype;
import com.emass.emass_backend.model.entity.enums.ListingStatus;
import com.emass.emass_backend.model.entity.enums.ListingType;
import com.emass.emass_backend.model.entity.enums.details.land.TitleLandDeedStatus;
import com.emass.emass_backend.model.entity.enums.details.land.ZoningStatus;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.List;

public record LandSearchRequest(
        // Listing filtreleri
        ListingType listingType,
        String city,
        List<String> district,
        List<String> neighborhood,
        // Price filtreleri (Price bileşeninden)
        BigDecimal minPrice,
        BigDecimal maxPrice,
        ListingStatus status,

        // LandDetails filtreleri
        LandSubtype subtype,
        // Alan filtreleri
        Integer minNetArea,
        Integer maxNetArea,

        List<ZoningStatus> zoningStatus,
        List<TitleLandDeedStatus> titleLandDeedStatus,

        // Altyapı
        Boolean electricity,
        Boolean water,
        Boolean naturalGas,
        Boolean sewerage,
        Boolean roadAccess,

        // Konum & Manzara
        Boolean cornerLot,
        Boolean seaView,
        Boolean cityView,
        Boolean forestView,
        Boolean mountainView,

        // Arazi Özellikler
        Boolean flat,
        Boolean slope,
        Boolean fenced,
        Boolean agricultural,
        Boolean buildingPermit,

        // Tarım & Bahçe
        Boolean vineyard,
        Boolean orchard,
        Boolean oliveTrees,
        Boolean greenhouse,
        Boolean well
) {}