package com.tourmanagement.Repositorys;
import com.tourmanagement.Models.Discount;
import com.tourmanagement.Models.Review;
import com.tourmanagement.Shared.Types.EnumStatusDiscount;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.tour.id = :tourId")
    List<Review> findByTourId(Long tourId);

    @Query("SELECT r FROM Review r WHERE r.customer.id = :customerId")
    List<Review> findByCustomerId(Long customerId);

    @Query("SELECT count(*) FROM Review r WHERE " +
            "(:customerId is null or r.customer.id = :customerId) and " +
            "(:tourId is null or r.tour.id = :tourId) and " +
            "(:rating is null or r.rating = :rating)")
    Long countReviewByFilterReview(
            Long customerId,
            Long tourId,
            Integer rating
    );

    @Query("SELECT r FROM Review r WHERE " +
            "(:customerId is null or r.customer.id = :customerId) and " +
            "(:tourId is null or r.tour.id = :tourId) and" +
            "(:rating is null or r.rating = :rating)")
    List<Review> findReviewsByFilterReview(
            Long customerId,
            Long tourId,
            Integer rating,
            Pageable pageable
    );

}
