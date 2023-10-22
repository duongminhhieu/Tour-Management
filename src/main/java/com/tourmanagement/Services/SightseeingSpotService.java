package com.tourmanagement.Services;

import com.tourmanagement.DTOs.SightseeingSpotDTO;
import com.tourmanagement.Models.Province;
import com.tourmanagement.Models.SightseeingSpot;
import com.tourmanagement.Repositorys.SightseeingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SightseeingSpotService {
    private final SightseeingSpotRepository sightseeingSpotRepository;

    @Autowired
    public SightseeingSpotService(SightseeingSpotRepository sightseeingSpotRepository) {
        this.sightseeingSpotRepository = sightseeingSpotRepository;
    }

    public SightseeingSpot getSightSeeingSpotById(Long id) {
        SightseeingSpot sightseeingSpot = sightseeingSpotRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sightseeing Spot with id [%s]".formatted(id)));

        return sightseeingSpot;
    }

    public List<SightseeingSpot> getSightseeingSpots() {
        List<SightseeingSpot> sightseeingSpots = sightseeingSpotRepository.findAll();

        return sightseeingSpots;
    }

    public List<SightseeingSpot> getSightseeingSpotsByProvinceId(Long provinceId) {
        List<SightseeingSpot> sightseeingSpots = sightseeingSpotRepository.findByProvinceId(provinceId);

        return sightseeingSpots;
    }

    public SightseeingSpot createNewSightseeingSpot(SightseeingSpot newSightseeingSpot) {
        return sightseeingSpotRepository.save(newSightseeingSpot);
    }
}