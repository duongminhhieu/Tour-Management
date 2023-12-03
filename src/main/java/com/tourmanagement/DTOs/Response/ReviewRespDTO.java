package com.tourmanagement.DTOs.Response;

import com.tourmanagement.Models.Customer;

import com.tourmanagement.Models.Tour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRespDTO {
    private Long id;
    private Customer customer;
    private Tour tour;
    private String comment;
    private Integer rating;
}
