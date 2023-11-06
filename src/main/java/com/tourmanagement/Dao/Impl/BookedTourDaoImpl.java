package com.tourmanagement.Dao.Impl;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.tourmanagement.DTOs.Response.RevenueRespDTO;
import com.tourmanagement.DTOs.Response.TopProvinceRespDTO;
import com.tourmanagement.Dao.BookedTourDao;
import com.tourmanagement.Dao.DaoBase;
import com.tourmanagement.Models.BookedTour;
import com.tourmanagement.Models.Province;
import com.tourmanagement.Models.QBookedTour;
import com.tourmanagement.Models.QTour;
import com.tourmanagement.Shared.Utils.Converter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BookedTourDaoImpl extends DaoBase implements BookedTourDao {
    @Override
    public List<RevenueRespDTO> revenues(List<Date> dates) {
        List<RevenueRespDTO> result = new ArrayList<>();
        JPAQuery<BookedTour> query = new JPAQuery<>(_entityManager);
        QBookedTour bookedTour = QBookedTour.bookedTour;
        QTour tour = QTour.tour;

        query = query.from(bookedTour).leftJoin(bookedTour.tour, tour);

        for (Date date : dates) {
            List<BookedTour> matchedBookedTours = query
                    .where(bookedTour.bookingDate.eq(Converter.convertDateUtilToSqlDate(date)))
                    .fetch();

            if (matchedBookedTours.size() == 0) {
                result.add(new RevenueRespDTO(0, date));
                continue;
            }

            Double totalMoney = 0.0;
            for (BookedTour _bookedTour : matchedBookedTours) {
                totalMoney += _bookedTour.getTour().getPrice();
            }

            result.add(new RevenueRespDTO(totalMoney, date));
        }

        return result;
    }

    @Override
    public List<TopProvinceRespDTO> theMostAmazingProvinces() {
        JPAQuery<BookedTour> query = new JPAQuery<>(_entityManager);
        QBookedTour bookedTour = QBookedTour.bookedTour;

        List<Tuple> dataResp = query.select(bookedTour.tour.province, bookedTour.tour.province.count())
                .from(bookedTour)
                .groupBy(bookedTour.tour.province)
                .fetch();

        return dataResp.stream()
                .map(tuple -> {
                    Province province = tuple.get(bookedTour.tour.province);
                    Long tourCount = tuple.get(bookedTour.tour.province.count());
                    assert province != null;
                    return new TopProvinceRespDTO(province.getName(), tourCount);
                })
                .toList();
    }
}
