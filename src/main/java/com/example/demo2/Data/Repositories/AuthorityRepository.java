package com.example.demo2.Data.Repositories;

import com.example.demo2.Data.Entities.Authority;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityRepository extends BaseRepository<Authority> {

    @Query(value = "select a from Authority a where a.authority like %?1%", nativeQuery = true)
        List<Authority> findByAuthority(String authority);
    }

