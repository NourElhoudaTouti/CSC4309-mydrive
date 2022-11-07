package com.example.demo2.Data.Repositories;

import com.example.demo2.Data.Entities.Reservation;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends BaseRepository<Reservation>{
        @Query("select o from Reservation o where o.user.id = ?1")
        List<Reservation> findByCustomer(long userId);
    }

