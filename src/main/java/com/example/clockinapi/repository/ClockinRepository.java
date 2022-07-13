package com.example.clockinapi.repository;
import com.example.clockinapi.model.Clockin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;

public interface ClockinRepository extends JpaRepository<Clockin, Long> {
    Clockin findByUseridAndDate(String userid, LocalDate date);
}
