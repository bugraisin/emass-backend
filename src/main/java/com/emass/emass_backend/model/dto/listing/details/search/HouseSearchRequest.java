package com.emass.emass_backend.model.dto.listing.details.search;

import com.emass.emass_backend.model.entity.enums.details.HeatingType;
import com.emass.emass_backend.model.entity.enums.HousingSubtype;
import com.emass.emass_backend.model.entity.enums.ListingStatus;

import java.math.BigDecimal;
import java.util.List;

public record HouseSearchRequest(
        // Listing filtreleri (Address bileşeninden)
        String city,
        String district,
        String neighborhood,

        // Price filtreleri (Price bileşeninden)
        BigDecimal minPrice,
        BigDecimal maxPrice,
        ListingStatus status,

        // HouseDetails filtreleri (Housing Details bileşeninden)
        HousingSubtype subtype,

        // Oda + Salon seçimleri (çoklu seçim)
        List<String> roomCount,  // ["1+0", "1+1", "2+1", "2+2", "3+1", "3+2", "4+1", "4+2", "5+1", "5+2", "6+1", "7+"]

        // Alan filtreleri
        Integer minNetArea,
        Integer maxNetArea,

        // Kat filtreleri (çoklu seçim)
        List<String> floors,  // ["-1", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11-15", "16-20", "21+"]
        List<String> totalFloors,// ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11-15", "16-20", "21-25", "26-30", "31+"]

        // Bina yaşı (çoklu seçim)
        List<String> buildingAges,  // ["0 (Yeni)", "1-5", "6-10", "11-15", "16-20", "21-25", "26-30", "31+"]

        // Mali bilgiler
        BigDecimal minSiteFee,
        BigDecimal maxSiteFee,
        BigDecimal minDeposit,
        BigDecimal maxDeposit,

        // Isıtma türü (çoklu seçim)
        List<String> heatingTypes,  // ["DOGALGAZ", "KOMBI", "KALORIFER", "KLIMA", "SOBALI", "YOK"]

        // Cephe yönü (çoklu seçim)
        List<String> facadeDirections,// ["Kuzey", "Güney", "Doğu", "Batı", "Kuzey-Doğu", "Kuzey-Batı", "Güney-Doğu", "Güney-Batı"]

        // Temel Özellikler (Boolean features)
        Boolean furnished,
        Boolean balcony,
        Boolean terrace,
        Boolean garden,
        Boolean withinSite,

        // Otopark
        Boolean openPark,
        Boolean closedPark,
        Boolean garagePark,

        // Bina & Güvenlik
        Boolean elevator,
        Boolean security,
        Boolean concierge,
        Boolean generator,

        // Konfor & Isıtma
        Boolean airConditioning,
        Boolean floorHeating,
        Boolean fireplace,

        // Mutfak & İç Mekan
        Boolean builtinKitchen,
        Boolean separateKitchen,
        Boolean americanKitchen,
        Boolean laundryRoom,

        // Site İmkanları
        Boolean pool,
        Boolean gym,
        Boolean childrenPlayground,
        Boolean sportsArea
) {}
