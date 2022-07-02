package com.example.clockinapi.repository;
import com.example.clockinapi.model.Clockin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClockinRepository extends JpaRepository<Clockin, Long> {

}
