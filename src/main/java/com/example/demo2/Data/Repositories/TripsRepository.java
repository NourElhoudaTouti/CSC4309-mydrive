package com.example.demo2.Data.Repositories;

import com.example.demo2.Data.Entities.Trip;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripsRepository extends BaseRepository<Trip> {

        @Query("select t from Trip t where t.Destination like %?1%")
        List<Trip> findByDestination(String name);

        @Query("select t from Trip t  where t.Destination like %?1% and t.price between ?2 and ?3")
        List<Trip> findByDestinationAndPrice(String name, float min, float max);

        @Query("select t from Trip t  where t.Carbrand= ?1")
        List<Trip> findByBrand(long brandId);

        @Query("select t from Trip t  where t.Carbrand = ?1 and t.price between ?2 and ?3")
        List<Trip> findByBrandAndPrice(long brandId, float min, float max);

        @Query(value = "select t from Trip t  where p.id = ?1", nativeQuery = true)
        List<Trip> findById(long id);


    }

