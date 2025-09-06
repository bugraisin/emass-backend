package com.emass.emass_backend.model.dto.listing.details;

import com.emass.emass_backend.model.entity.enums.LandSubtype;
import com.emass.emass_backend.model.entity.enums.details.land.TitleLandDeedStatus;
import com.emass.emass_backend.model.entity.enums.details.land.ZoningStatus;

import java.math.BigDecimal;

public record LandDetailsRequest(
        LandSubtype subtype,
        Integer landArea,
        ZoningStatus zoningStatus,
        Integer adaNo,
        Integer parcelNo,
        String paftaNo,
        BigDecimal kaks,
        BigDecimal gabari,
        TitleLandDeedStatus titleLandDeedStatus,
        Boolean electricity,
        Boolean water,
        Boolean naturalGas,
        Boolean sewerage,
        Boolean roadAccess,
        Boolean cornerLot,
        Boolean seaView,
        Boolean cityView,
        Boolean forestView,
        Boolean mountainView,
        Boolean flat,
        Boolean slope,
        Boolean fenced,
        Boolean agricultural,
        Boolean buildingPermit,
        Boolean vineyard,
        Boolean orchard,
        Boolean oliveTrees,
        Boolean greenhouse,
        Boolean well
) {}
