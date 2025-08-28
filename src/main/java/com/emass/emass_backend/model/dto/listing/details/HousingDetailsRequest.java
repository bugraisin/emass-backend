package com.emass.emass_backend.model.dto.listing.details;

import com.emass.emass_backend.model.entity.enums.details.HeatingType;
import com.emass.emass_backend.model.entity.enums.details.FacadeDirection;
import com.emass.emass_backend.model.entity.enums.details.TitleDeedStatus;
import com.emass.emass_backend.model.entity.enums.details.UsageStatus;
import com.emass.emass_backend.model.entity.enums.HousingSubtype;

import java.math.BigDecimal;

public record HousingDetailsRequest(
        HousingSubtype subtype,
        String roomCount,
        Integer grossArea,
        Integer netArea,
        Integer floorNo,
        Integer totalFloors,
        String buildingAge,
        Integer bathroomCount,
        HeatingType heatingType,
        FacadeDirection facadeDirection,
        TitleDeedStatus titleDeedStatus,
        UsageStatus usageStatus,
        String siteName,
        BigDecimal siteFee,
        BigDecimal deposit,
        Boolean furnished,
        Boolean balcony,
        Boolean terrace,
        Boolean garden,
        Boolean withinSite,
        Boolean openPark,
        Boolean closedPark,
        Boolean garagePark,
        Boolean elevator,
        Boolean security,
        Boolean concierge,
        Boolean generator,
        Boolean airConditioning,
        Boolean floorHeating,
        Boolean fireplace,
        Boolean builtinKitchen,
        Boolean separateKitchen,
        Boolean americanKitchen,
        Boolean laundryRoom,
        Boolean pool,
        Boolean gym,
        Boolean childrenPlayground,
        Boolean sportsArea
) {}

