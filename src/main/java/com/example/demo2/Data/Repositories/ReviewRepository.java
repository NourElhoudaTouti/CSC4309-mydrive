package com.example.demo2.Data.Repositories;

import com.example.demo2.Data.Entities.Review;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends BaseRepository<Review>{
        @Query("select r from Review r where r.trip.id = ?1")
        List<ReviewRepository> findByProduct(long productId);
    }
