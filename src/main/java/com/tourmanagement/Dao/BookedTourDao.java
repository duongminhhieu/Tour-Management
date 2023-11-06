package com.tourmanagement.Dao;

import com.tourmanagement.DTOs.Response.RevenueRespDTO;
import com.tourmanagement.DTOs.Response.TopProvinceRespDTO;

import java.util.Date;
import java.util.List;

public interface BookedTourDao {
    public List<RevenueRespDTO> revenues(List<Date> dates);
    public List<TopProvinceRespDTO> theMostAmazingProvinces();
}
