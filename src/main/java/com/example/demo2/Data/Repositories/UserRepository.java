package com.example.demo2.Data.Repositories;

import com.example.demo2.Data.Entities.User;

public interface UserRepository extends BaseRepository<User>{
        User findByUsername(String username);
        User findById(int userId);
}
