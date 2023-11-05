package com.tourmanagement.DTOs.Payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tourmanagement.DTOs.Request.TourDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class TourPayload {
    @NotNull(message = "Name cannot be null!")
    private String name;

    @NotNull(message = "Duration cannot be null!")
    @Positive(message = "Duration is a positive number")
    private Integer duration;

    @NotNull(message = "Available Seats cannot be null")
    @Positive(message = "Available Seats is a positive number")
    private Integer availableSeats;

    @NotNull(message = "Gathering Address cannot be null")
    @Length(min = 4, max = 255, message = "Gathering Address has from 4 to 255 characters!")
    private String gatheringAddress;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price is a positive number")
    private Double price;

    @NotNull(message = "Departure Date cannot be null")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date departureDate;

    @NotNull(message = "Images cannot be null")
    private MultipartFile[] images;

    public TourDTO convertTourPayloadToTourDTO() {
        TourDTO tourDTO = new TourDTO();
        tourDTO.setName(this.getName());
        tourDTO.setDuration(this.getDuration());
        tourDTO.setAvailableSeats(this.getAvailableSeats());
        tourDTO.setGatheringAddress(this.getGatheringAddress());
        tourDTO.setPrice(this.getPrice());
        tourDTO.setDepartureDate(this.getDepartureDate());
        return tourDTO;
    }
}
