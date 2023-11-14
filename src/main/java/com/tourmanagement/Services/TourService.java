package com.tourmanagement.Services;

import com.tourmanagement.DTOs.Payload.PaginationRequest;
import com.tourmanagement.DTOs.Payload.TourPayload;
import com.tourmanagement.DTOs.Request.SearchTourDTO;
import com.tourmanagement.DTOs.Request.TourDTO;
import com.tourmanagement.DTOs.Response.BookedTourRespDTO;
import com.tourmanagement.DTOs.Response.PaginationRespDTO;
import com.tourmanagement.DTOs.Response.TourRespDTO;
import com.tourmanagement.Dao.Impl.TourDaoImpl;
import com.tourmanagement.Models.BookedTour;
import com.tourmanagement.Models.Tour;
import com.tourmanagement.Repositorys.TourRepository;
import com.tourmanagement.Shared.Utils.Converter;
import com.tourmanagement.Shared.Utils.EntityDtoConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourService {
    private final TourRepository tourRepository;
    private final ModelMapper modelMapper;
    private final EntityDtoConverter entityDtoConverter;
    private final ImageService imageService;
    private final TourDaoImpl tourDao;

    @Autowired
    public TourService(TourRepository tourRepository, ModelMapper modelMapper, EntityDtoConverter entityDtoConverter, ImageService imageService,TourDaoImpl tourDao) {
        this.tourRepository = tourRepository;
        this.modelMapper = modelMapper;
        this.entityDtoConverter = entityDtoConverter;
        this.imageService = imageService;
        this.tourDao = tourDao;
    }

    public List<TourRespDTO> getTours(){
        List<Tour> tours = tourRepository.findAll();

        return tours.stream()
                .map(entityDtoConverter::convertToTourRespDTO)
                .collect(Collectors.toList());
    }

    public Long getCountTour() {
        return tourRepository.count();
    }

    public Tour getTourById(Long id) {
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tour with id [%s] is not found!".formatted(id)));

        return tour;
    }

    public Tour createTour(TourPayload tourPayload) {
        if(imageService.isEmptyFilesArray(tourPayload.getImages())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No uploaded images");
        }

        TourDTO tourDTO = tourPayload.convertTourPayloadToTourDTO();
        Tour newTour = modelMapper.map(tourDTO, Tour.class);
        newTour = tourRepository.save(newTour);

        List<String> images = this.imageService.uploadMultipleImage(tourPayload.getImages(), newTour.getId());
        newTour.setImages(Converter.convertListImagesToJson(images));

        return tourRepository.save(newTour);
    }

    public Tour updateTour(Long id, TourPayload tourPayload) {
        getTourById(id);

        if(imageService.isEmptyFilesArray(tourPayload.getImages())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No uploaded images");
        }

        TourDTO tourDTO = tourPayload.convertTourPayloadToTourDTO();
        Tour tourUpdate = modelMapper.map(tourDTO, Tour.class);
        tourUpdate = tourRepository.save(tourUpdate);
        tourUpdate.setId(id);

        List<String> images = this.imageService.uploadMultipleImage(tourPayload.getImages(), id);
        tourUpdate.setImages(Converter.convertListImagesToJson(images));

        return tourRepository.save(tourUpdate);
    }

    public void deleteTour(Long id) {
        getTourById(id);
        tourRepository.deleteById(id);
    }

    public List<TourRespDTO> searchTours(SearchTourDTO searchTourDTO) {
        var tours = tourDao.searchTours(searchTourDTO);

        return tours.stream()
                .map(entityDtoConverter::convertToTourRespDTO)
                .collect(Collectors.toList());
    }

    public List<Tour> filterToursByPrice(Double minPrice, Double maxPrice) {
        return tourRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Tour> getTopRatedTours(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        List<Tour> topRatedTours = tourRepository.findTopRatedTours(pageable);
        return topRatedTours;
    }

    public List<TourRespDTO> getTodayTour() {
        List<Tour> tours = tourRepository.findToDayTour(Converter.convertDateUtilToSqlDate(new Date()));

        return tours.stream()
                .map(entityDtoConverter::convertToTourRespDTO)
                .collect(Collectors.toList());
    }

    public void saveTour(Tour tour) {
        tourRepository.save(tour);
    }


    public Page<Tour> getToursByPage(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return tourRepository.findAll(pageable);
    }

    public List<TourRespDTO> getTourRespDTOsByPage(int page, int size) {
        Page<Tour> tourPage = getToursByPage(page, size);
        return tourPage.getContent().stream()
                .map(entityDtoConverter::convertToTourRespDTO)
                .collect(Collectors.toList());
    }

    public PaginationRespDTO<TourRespDTO> getAllTour(PaginationRequest pagination) {
        PaginationRespDTO<TourRespDTO> result = new PaginationRespDTO<TourRespDTO>();
        result.setTotal(tourRepository.count());
        result.setPage(pagination.getPage());
        result.setItemsPerPage(pagination.getItemsPerPage());
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getItemsPerPage());

        Page<Tour> TourPage = tourRepository.findAll(pageable);
        result.setData(
                TourPage.getContent().stream()
                        .map(entityDtoConverter::convertToTourRespDTO)
                        .collect(Collectors.toList()));

        return result;
    }

}
