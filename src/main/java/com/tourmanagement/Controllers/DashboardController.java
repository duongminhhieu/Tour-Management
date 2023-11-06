package com.tourmanagement.Controllers;

import com.tourmanagement.DTOs.Response.QuantityStatisticResp;
import com.tourmanagement.DTOs.Response.RevenueRespDTO;
import com.tourmanagement.DTOs.Response.TopProvinceRespDTO;
import com.tourmanagement.Services.BookTourService;
import com.tourmanagement.Services.DashboardService;
import com.tourmanagement.Services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dash-board")
@ResponseStatus(HttpStatus.OK)
public class DashboardController {
    private final DashboardService dashboardService;
    private final TourService tourService;

    private final BookTourService bookTourService;
    @Autowired
    public DashboardController(DashboardService dashboardService,
                               TourService tourService,
                               BookTourService bookTourService) {
        this.dashboardService = dashboardService;
        this.tourService = tourService;
        this.bookTourService = bookTourService;
    }

    @GetMapping("quantity-statistic")
    public QuantityStatisticResp handleGetQuantityStatistic() {
        return dashboardService.getQuantityStatistics();
    }

    @GetMapping("revenues")
    public List<RevenueRespDTO> handleGetRevenuresPerWeek() {
        return  bookTourService.getRevenuesSevenNearestDate();
    }

    @GetMapping("top-amazing-province")
    public List<TopProvinceRespDTO> handleTopAmazingProvince() {
        return bookTourService.getTopTheMostAmazingProvinces();
    }
}
