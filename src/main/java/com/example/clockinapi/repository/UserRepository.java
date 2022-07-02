package com.example.clockinapi.repository;

import com.example.clockinapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
         //return one user with the specified userid
         User findByUserid(String userid);
}
