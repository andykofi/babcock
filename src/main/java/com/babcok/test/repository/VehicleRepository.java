package com.babcok.test.repository;

import com.babcok.test.model.Vehicle;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findAllByModel(String model);

    @Query("SELECT v FROM Vehicle v WHERE v.hiredate!=:today")
    List<Vehicle> listVehicleAvailableForHireToday(@Param("today")Date today);


}
