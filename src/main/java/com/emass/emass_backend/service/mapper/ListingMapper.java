package com.emass.emass_backend.service.mapper;
import com.emass.emass_backend.model.dto.listing.ListingCreateRequest;
import com.emass.emass_backend.model.dto.listing.ListingDetailResponse;
import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.details.*;
import org.springframework.stereotype.Component;
import com.emass.emass_backend.model.dto.listing.PhotoResponse;

@Component
public class ListingMapper {

    public Listing toListingEntity(ListingCreateRequest req) {
        if (req == null) return null;

        var listing = new Listing();
        listing.setTitle(req.title());
        listing.setDescription(req.description());
        listing.setListingType(req.listingType());
        listing.setPropertyType(req.propertyType());
        listing.setPrice(req.price());

        listing.setCity(req.city());
        listing.setDistrict(req.district());
        listing.setNeighborhood(req.neighborhood());
        listing.setLatitude(req.latitude());
        listing.setLongitude(req.longitude());
        return listing;
    }

    public ListingResponse toSearchResponse(Listing listing) {
        if (listing == null) return null;

        return new ListingResponse(
                listing.getId(),
                listing.getOwner().getId(),
                listing.getTitle(),
                listing.getDescription(),
                listing.getStatus(),
                listing.getPrice(),
                listing.getCity(),
                listing.getDistrict(),
                listing.getNeighborhood(),
                listing.getLatitude(),
                listing.getLongitude(),
                listing.getCreatedAt(),
                listing.getThumbnailUrl()
        );
    }

    public ListingDetailResponse toResponse(Listing l, PropertyDetails propertyDetails) {
        if (l == null) return null;

        return new ListingDetailResponse(
                l.getId(),
                l.getOwner() != null ? l.getOwner().getId() : null,
                l.getTitle(),
                l.getDescription(),
                l.getListingType(),
                l.getPropertyType(),
                l.getStatus(),
                l.getPrice(),
                l.getCity(),
                l.getDistrict(),
                l.getNeighborhood(),
                l.getLatitude(),
                l.getLongitude(),
                l.getCreatedAt(),
                l.getUpdatedAt(),
                l.getPhotos() != null ? l.getPhotos().stream()
                        .map(p -> new PhotoResponse(
                                p.getId(),
                                p.getFullImageUrl(),
                                p.getSeqNumber()
                        ))
                        .toList() : null,
                mapPropertyDetails(propertyDetails)
        );
    }

    private Object mapPropertyDetails(PropertyDetails propertyDetails) {
        if (propertyDetails == null) return null;

        if (propertyDetails instanceof HousingDetails d) {
            return new ListingDetailResponse.HousingDetailsResponse(
                    d.getSubtype(), d.getRoomCount(), d.getGrossArea(), d.getNetArea(),
                    d.getFloorNo(), d.getTotalFloors(), d.getBuildingAge(), d.getBathroomCount(),
                    d.getHeatingType(), d.getFacadeDirection(), d.getTitleDeedStatus(),
                    d.getUsageStatus(), d.getSiteName(), d.getSiteFee(), d.getDeposit(),
                    d.getFurnished(), d.getBalcony(), d.getTerrace(), d.getGarden(),
                    d.getWithinSite(), d.getOpenPark(), d.getClosedPark(), d.getGaragePark(),
                    d.getElevator(), d.getSecurity(), d.getConcierge(), d.getGenerator(),
                    d.getAirConditioning(), d.getFloorHeating(), d.getFireplace(),
                    d.getBuiltinKitchen(), d.getSeparateKitchen(), d.getAmericanKitchen(),
                    d.getLaundryRoom(), d.getPool(), d.getGym(), d.getChildrenPlayground(),
                    d.getSportsArea()
            );
        }

        if (propertyDetails instanceof OfficeDetails d) {
            return new ListingDetailResponse.OfficeDetailsResponse(
                    d.getSubtype(), d.getGrossArea(), d.getNetArea(), d.getBuildingAge(),
                    d.getRoomCount(), d.getFloorNo(), d.getFloorCount(), d.getHeatingType(),
                    d.getSiteFee(), d.getDeposit(), d.getBuildingType(), d.getFurnished(),
                    d.getParking(), d.getElevator(), d.getSecurity(), d.getGenerator(),
                    d.getAirConditioning(), d.getInternet(), d.getKitchen(), d.getFireSystem(),
                    d.getReception(), d.getWaitingArea(), d.getMeetingRoom(), d.getArchive(),
                    d.getLibrary(), d.getServerRoom(), d.getAccessControl(),
                    d.getFiberInternet(), d.getSoundproof()
            );
        }

        if (propertyDetails instanceof CommercialDetails d) {
            return new ListingDetailResponse.CommercialDetailsResponse(
                    d.getSubtype(), d.getGrossArea(), d.getNetArea(), d.getBuildingAge(),
                    d.getFloorNo(), d.getFloorCount(), d.getHeatingType(), d.getSiteFee(),
                    d.getDeposit(), d.getBuildingType(), d.getFurnished(), d.getParking(),
                    d.getSecurity(), d.getElevator(), d.getGenerator(), d.getAirConditioning(),
                    d.getInternet(), d.getKitchen(), d.getToilet(), d.getShowcase(),
                    d.getWarehouse(), d.getLoadingDock(), d.getCashRegister(),
                    d.getOutdoorSeating(), d.getWaitingArea(), d.getChangingRoom()
            );
        }

        if (propertyDetails instanceof IndustrialDetails d) {
            return  new ListingDetailResponse.IndustrialDetailsResponse(
                    d.getSubtype(), d.getGrossArea(), d.getNetArea(), d.getBuildingAge(),
                    d.getRoomCount(), d.getFloorCount(), d.getCeilingHeight(), d.getDeposit(),
                    d.getThreephaseElectricity(), d.getNaturalGasLine(), d.getSteamLine(),
                    d.getWaterSystem(), d.getWasteWaterSystem(), d.getCraneSystem(),
                    d.getVentilationSystem(), d.getAirConditioning(), d.getWideOpenArea(),
                    d.getMachineMountingSuitable(), d.getLoadingRamp(), d.getTruckEntrance(),
                    d.getForkliftTraffic(), d.getRackingSystem(), d.getColdStorage(),
                    d.getFireExtinguishingSystem(), d.getSecurityCameras(), d.getAlarmSystem(),
                    d.getFencedArea(), d.getSecurity()
            );
        }

        if (propertyDetails instanceof ServiceDetails d) {
            return new ListingDetailResponse.ServiceDetailsResponse(
                    d.getSubtype(), d.getGrossArea(), d.getNetArea(), d.getCapacity(),
                    d.getSpaceType(), d.getDeposit(), d.getSecurity(), d.getLighting(),
                    d.getCctv(), d.getInternet(), d.getReception(), d.getRestRoom(),
                    d.getKitchen(), d.getWashingArea(), d.getMaintenanceArea(),
                    d.getAirConditioning(), d.getVentilationSystem(), d.getStorage(),
                    d.getOfficeArea(), d.getCustomerParking()
            );
        }

        if (propertyDetails instanceof LandDetails d) {
            return new ListingDetailResponse.LandDetailsResponse(
                    d.getSubtype(), d.getLandArea(), d.getZoningStatus(), d.getAdaNo(),
                    d.getParcelNo(), d.getPaftaNo(), d.getKaks(), d.getGabari(),
                    d.getTitleLandDeedStatus(), d.getElectricity(), d.getWater(),
                    d.getNaturalGas(), d.getSewerage(), d.getRoadAccess(), d.getCornerLot(),
                    d.getSeaView(), d.getCityView(), d.getForestView(), d.getMountainView(),
                    d.getFlat(), d.getSlope(), d.getFenced(), d.getAgricultural(),
                    d.getBuildingPermit(), d.getVineyard(), d.getOrchard(), d.getOliveTrees(),
                    d.getGreenhouse(), d.getWell()
            );
        }

        return null;
    }

//    /** KONUT detayıyla birlikte response üretir. */
//    public ListingDetailResponse toResponse(Listing l, HousingDetails d) {
//        if (l == null) return null;
//
//        return new ListingDetailResponse(
//                l.getId(),
//                l.getOwner() != null ? l.getOwner().getId() : null,
//                l.getTitle(),
//                l.getDescription(),
//                l.getListingType(),
//                l.getPropertyType(),
//                l.getStatus(),
//                l.getPrice(),
//                l.getCity(),
//                l.getDistrict(),
//                l.getNeighborhood(),
//                l.getLatitude(),
//                l.getLongitude(),
//                l.getCreatedAt(),
//                l.getUpdatedAt(),
//                l.getPhotos() != null ? l.getPhotos().stream()
//                        .map(p -> new PhotoResponse(
//                                p.getId(),
//                                p.getFullImageUrl(),
//                                p.getSeqNumber()
//                        ))
//                        .toList() : null,
//
//                // HousingDetailsResponse
//                d == null ? null : new ListingDetailResponse.HousingDetailsResponse(
//                        d.getSubtype(),
//                        d.getRoomCount(),
//                        d.getGrossArea(),
//                        d.getNetArea(),
//                        d.getFloorNo(),
//                        d.getTotalFloors(),
//                        d.getBuildingAge(),
//                        d.getBathroomCount(),
//                        d.getHeatingType(),
//                        d.getFacadeDirection(),
//                        d.getTitleDeedStatus(),
//                        d.getUsageStatus(),
//                        d.getSiteName(),
//                        d.getSiteFee(),
//                        d.getDeposit(),
//                        d.getFurnished(),
//                        d.getBalcony(),
//                        d.getTerrace(),
//                        d.getGarden(),
//                        d.getWithinSite(),
//                        d.getOpenPark(),
//                        d.getClosedPark(),
//                        d.getGaragePark(),
//                        d.getElevator(),
//                        d.getSecurity(),
//                        d.getConcierge(),
//                        d.getGenerator(),
//                        d.getAirConditioning(),
//                        d.getFloorHeating(),
//                        d.getFireplace(),
//                        d.getBuiltinKitchen(),
//                        d.getSeparateKitchen(),
//                        d.getAmericanKitchen(),
//                        d.getLaundryRoom(),
//                        d.getPool(),
//                        d.getGym(),
//                        d.getChildrenPlayground(),
//                        d.getSportsArea()
//                ),
//                null, null, null, null, null
//        );
//    }
//    /** OFİS detayıyla birlikte response üretir. */
//    public ListingDetailResponse toResponse(Listing l, OfficeDetails d) {
//        if (l == null) return null;
//
//        return new ListingDetailResponse(
//                l.getId(),
//                l.getOwner() != null ? l.getOwner().getId() : null,
//                l.getTitle(),
//                l.getDescription(),
//                l.getListingType(),
//                l.getPropertyType(),
//                l.getStatus(),
//                l.getPrice(),
//                l.getCity(),
//                l.getDistrict(),
//                l.getNeighborhood(),
//                l.getLatitude(),
//                l.getLongitude(),
//                l.getCreatedAt(),
//                l.getUpdatedAt(),
//                l.getPhotos() != null ? l.getPhotos().stream()
//                        .map(p -> new PhotoResponse(
//                                p.getId(),
//                                p.getFullImageUrl(),
//                                p.getSeqNumber()
//                        ))
//                        .toList() : null,
//
//                null,
//                null,
//                d == null ? null : new ListingDetailResponse.OfficeDetailsResponse(
//                        d.getSubtype(),
//                        d.getGrossArea(),
//                        d.getNetArea(),
//                        d.getBuildingAge(),
//                        d.getRoomCount(),
//                        d.getFloorNo(),
//                        d.getFloorCount(),
//                        d.getHeatingType(),
//                        d.getSiteFee(),
//                        d.getDeposit(),
//                        d.getBuildingType(),
//                        d.getFurnished(),
//                        d.getParking(),
//                        d.getElevator(),
//                        d.getSecurity(),
//                        d.getGenerator(),
//                        d.getAirConditioning(),
//                        d.getInternet(),
//                        d.getKitchen(),
//                        d.getFireSystem(),
//                        d.getReception(),
//                        d.getWaitingArea(),
//                        d.getMeetingRoom(),
//                        d.getArchive(),
//                        d.getLibrary(),
//                        d.getServerRoom(),
//                        d.getAccessControl(),
//                        d.getFiberInternet(),
//                        d.getSoundproof()
//                ),
//                null, null, null
//        );
//    }
//
//    /** TİCARİ detayıyla birlikte response üretir. */
//    public ListingDetailResponse toResponse(Listing l, CommercialDetails d) {
//        if (l == null) return null;
//
//        return new ListingDetailResponse(
//                l.getId(),
//                l.getOwner() != null ? l.getOwner().getId() : null,
//                l.getTitle(),
//                l.getDescription(),
//                l.getListingType(),
//                l.getPropertyType(),
//                l.getStatus(),
//                l.getPrice(),
//                l.getCity(),
//                l.getDistrict(),
//                l.getNeighborhood(),
//                l.getLatitude(),
//                l.getLongitude(),
//                l.getCreatedAt(),
//                l.getUpdatedAt(),
//                l.getPhotos() != null ? l.getPhotos().stream()
//                        .map(p -> new PhotoResponse(
//                                p.getId(),
//                                p.getFullImageUrl(),
//                                p.getSeqNumber()
//                        ))
//                        .toList() : null,
//
//                null,
//                d == null ? null : new ListingDetailResponse.CommercialDetailsResponse(
//                        d.getSubtype(),
//                        d.getGrossArea(),
//                        d.getNetArea(),
//                        d.getBuildingAge(),
//                        d.getFloorNo(),
//                        d.getFloorCount(),
//                        d.getHeatingType(),
//                        d.getSiteFee(),
//                        d.getDeposit(),
//                        d.getBuildingType(),
//                        d.getFurnished(),
//                        d.getParking(),
//                        d.getSecurity(),
//                        d.getElevator(),
//                        d.getGenerator(),
//                        d.getAirConditioning(),
//                        d.getInternet(),
//                        d.getKitchen(),
//                        d.getToilet(),
//                        d.getShowcase(),
//                        d.getWarehouse(),
//                        d.getLoadingDock(),
//                        d.getCashRegister(),
//                        d.getOutdoorSeating(),
//                        d.getWaitingArea(),
//                        d.getChangingRoom()
//                ),
//                null, null, null, null
//        );
//    }
//
//    /** ENDÜSTRİYEL detayıyla birlikte response üretir. */
//    public ListingDetailResponse toResponse(Listing l, IndustrialDetails d) {
//        if (l == null) return null;
//
//        return new ListingDetailResponse(
//                l.getId(),
//                l.getOwner() != null ? l.getOwner().getId() : null,
//                l.getTitle(),
//                l.getDescription(),
//                l.getListingType(),
//                l.getPropertyType(),
//                l.getStatus(),
//                l.getPrice(),
//                l.getCity(),
//                l.getDistrict(),
//                l.getNeighborhood(),
//                l.getLatitude(),
//                l.getLongitude(),
//                l.getCreatedAt(),
//                l.getUpdatedAt(),
//                l.getPhotos() != null ? l.getPhotos().stream()
//                        .map(p -> new PhotoResponse(
//                                p.getId(),
//                                p.getFullImageUrl(),
//                                p.getSeqNumber()
//                        ))
//                        .toList() : null,
//
//                null, // housingDetails
//                null, // commercialDetails
//                null, // officeDetails
//                // IndustrialDetailsResponse
//                d == null ? null : new ListingDetailResponse.IndustrialDetailsResponse(
//                        d.getSubtype(),
//                        d.getGrossArea(),
//                        d.getNetArea(),
//                        d.getBuildingAge(),
//                        d.getRoomCount(),
//                        d.getFloorCount(),
//                        d.getCeilingHeight(),
//                        d.getDeposit(),
//                        d.getThreephaseElectricity(),
//                        d.getNaturalGasLine(),
//                        d.getSteamLine(),
//                        d.getWaterSystem(),
//                        d.getWasteWaterSystem(),
//                        d.getCraneSystem(),
//                        d.getVentilationSystem(),
//                        d.getAirConditioning(),
//                        d.getWideOpenArea(),
//                        d.getMachineMountingSuitable(),
//                        d.getLoadingRamp(),
//                        d.getTruckEntrance(),
//                        d.getForkliftTraffic(),
//                        d.getRackingSystem(),
//                        d.getColdStorage(),
//                        d.getFireExtinguishingSystem(),
//                        d.getSecurityCameras(),
//                        d.getAlarmSystem(),
//                        d.getFencedArea(),
//                        d.getSecurity()
//                ),
//                null, null
//        );
//    }
//
//    /** HİZMET detayıyla birlikte response üretir. */
//    public ListingDetailResponse toResponse(Listing l, ServiceDetails d) {
//        if (l == null) return null;
//
//        return new ListingDetailResponse(
//                l.getId(),
//                l.getOwner() != null ? l.getOwner().getId() : null,
//                l.getTitle(),
//                l.getDescription(),
//                l.getListingType(),
//                l.getPropertyType(),
//                l.getStatus(),
//                l.getPrice(),
//                l.getCity(),
//                l.getDistrict(),
//                l.getNeighborhood(),
//                l.getLatitude(),
//                l.getLongitude(),
//                l.getCreatedAt(),
//                l.getUpdatedAt(),
//                l.getPhotos() != null ? l.getPhotos().stream()
//                        .map(p -> new PhotoResponse(
//                                p.getId(),
//                                p.getFullImageUrl(),
//                                p.getSeqNumber()
//                        ))
//                        .toList() : null,
//
//                null,
//                null,
//                null,
//                null,
//                d == null ? null : new ListingDetailResponse.ServiceDetailsResponse(
//                        d.getSubtype(),
//                        d.getGrossArea(),
//                        d.getNetArea(),
//                        d.getCapacity(),
//                        d.getSpaceType(),
//                        d.getDeposit(),
//                        d.getSecurity(),
//                        d.getLighting(),
//                        d.getCctv(),
//                        d.getInternet(),
//                        d.getReception(),
//                        d.getRestRoom(),
//                        d.getKitchen(),
//                        d.getWashingArea(),
//                        d.getMaintenanceArea(),
//                        d.getAirConditioning(),
//                        d.getVentilationSystem(),
//                        d.getStorage(),
//                        d.getOfficeArea(),
//                        d.getCustomerParking()
//                ),
//                null
//        );
//    }
//
//    /** ARSA detayıyla birlikte response üretir. */
//    public ListingDetailResponse toResponse(Listing l, LandDetails d) {
//        if (l == null) return null;
//
//        return new ListingDetailResponse(
//                l.getId(),
//                l.getOwner() != null ? l.getOwner().getId() : null,
//                l.getTitle(),
//                l.getDescription(),
//                l.getListingType(),
//                l.getPropertyType(),
//                l.getStatus(),
//                l.getPrice(),
//                l.getCity(),
//                l.getDistrict(),
//                l.getNeighborhood(),
//                l.getLatitude(),
//                l.getLongitude(),
//                l.getCreatedAt(),
//                l.getUpdatedAt(),
//                l.getPhotos() != null ? l.getPhotos().stream()
//                        .map(p -> new PhotoResponse(
//                                p.getId(),
//                                p.getFullImageUrl(),
//                                p.getSeqNumber()
//                        ))
//                        .toList() : null,
//
//                null, // housingDetails
//                null, // commercialDetails
//                null, // officeDetails
//                null, // industrialDetails
//                null, // serviceDetails
//                // LandDetailsResponse
//                d == null ? null : new ListingDetailResponse.LandDetailsResponse(
//                        d.getSubtype(),
//                        d.getLandArea(),
//                        d.getZoningStatus(),
//                        d.getAdaNo(),
//                        d.getParcelNo(),
//                        d.getPaftaNo(),
//                        d.getKaks(),
//                        d.getGabari(),
//                        d.getTitleLandDeedStatus(),
//                        d.getElectricity(),
//                        d.getWater(),
//                        d.getNaturalGas(),
//                        d.getSewerage(),
//                        d.getRoadAccess(),
//                        d.getCornerLot(),
//                        d.getSeaView(),
//                        d.getCityView(),
//                        d.getForestView(),
//                        d.getMountainView(),
//                        d.getFlat(),
//                        d.getSlope(),
//                        d.getFenced(),
//                        d.getAgricultural(),
//                        d.getBuildingPermit(),
//                        d.getVineyard(),
//                        d.getOrchard(),
//                        d.getOliveTrees(),
//                        d.getGreenhouse(),
//                        d.getWell()
//                )
//        );
//    }
}

