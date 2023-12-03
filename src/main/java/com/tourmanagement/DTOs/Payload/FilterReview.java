package com.tourmanagement.DTOs.Payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilterReview {

    @PositiveOrZero(message = "Page must be a positive number or Zero number")
    @NotNull(message = "Page cannot be null")
    private int page;
    @Positive(message = "Items per page must be a positive number")
    @NotNull(message = "ItemsPerPage cannot be null")
    private int itemsPerPage;
    private Long tourId;
    private Long customerId;
}
