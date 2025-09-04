package com.emass.emass_backend.service.details;

import com.emass.emass_backend.model.dto.listing.ListingDetailResponse;
import com.emass.emass_backend.model.dto.listing.details.search.LandSearchRequest;
import com.emass.emass_backend.model.entity.listing.details.LandDetails;
import com.emass.emass_backend.repository.details.LandDetailsRepository;
import com.emass.emass_backend.service.details.specifications.LandSpecifications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandDetailsService {

    private final LandDetailsRepository landDetailsRepository;

    public LandDetailsService(LandDetailsRepository landDetailsRepository) {
        this.landDetailsRepository = landDetailsRepository;
    }

    public List<ListingDetailResponse> search(LandSearchRequest request) {
        return null;
//        List<LandDetails> detailsList = landDetailsRepository.findAll(
//                LandSpecifications.filterByRequest(request)
//        );
//
//        return detailsList.stream().map(details -> new ListingDetailResponse(
//                details.getListing().getId(),
//                details.getListing().getOwner().getId(),
//                details.getListing().getTitle(),
//                details.getListing().getDescription(),
//                details.getListing().getListingType(),
//                details.getListing().getPropertyType(),
//                details.getListing().getStatus(),
//                details.getListing().getPrice(),
//                details.getListing().getCity(),
//                details.getListing().getDistrict(),
//                details.getListing().getNeighborhood(),
//                details.getListing().getLatitude(),
//                details.getListing().getLongitude(),
//                details.getListing().getCreatedAt(),
//                details.getListing().getUpdatedAt(),
//                details.getListing().getPhotos(),
//                null,
//                null,
//                null,
//                null,
//                null,
//                new ListingDetailResponse.LandDetailsResponse(
//                        details.getSubtype(),
//                        details.getLandArea(),
//                        details.getZoningStatus(),
//                        details.getAdaNo(),
//                        details.getParcelNo(),
//                        details.getPaftaNo(),
//                        details.getKaks(),
//                        details.getGabari(),
//                        details.getTapuStatus(),
//                        details.getElectricity(),
//                        details.getWater(),
//                        details.getNaturalGas(),
//                        details.getSewerage(),
//                        details.getRoadAccess(),
//                        details.getCornerLot(),
//                        details.getSeaView(),
//                        details.getCityView(),
//                        details.getForestView(),
//                        details.getMountainView(),
//                        details.getFlat(),
//                        details.getSlope(),
//                        details.getFenced(),
//                        details.getAgricultural(),
//                        details.getBuildingPermit(),
//                        details.getVineyard(),
//                        details.getOrchard(),
//                        details.getOliveTrees(),
//                        details.getGreenhouse(),
//                        details.getWell()
//                )
//        )).toList();
    }
}