package com.babcok.test.service;

import com.babcok.test.dto.HiringCostDto;
import com.babcok.test.model.Vehicle;
import com.babcok.test.repository.VehicleRepository;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.repository.query.Param;


@Service
public class VehicleService  {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }


    public Vehicle findById(Long id) {
        return  vehicleRepository.findById(id).get();
    }

    public Vehicle save(Vehicle vehicle) {
        vehicle= vehicleRepository.save(vehicle);
        return vehicle;
    }

    public List<Vehicle> listVehicleAvailableForHireToday(@Param("today")Date today){
        return vehicleRepository.listVehicleAvailableForHireToday(today);
    }

    public HiringCostDto calculateCost(long id, String startDate,String endDate) {

        Vehicle vehicle=findById(id);
        LocalDate stDate = LocalDate.parse(startDate);
        LocalDate endate = LocalDate.parse(endDate);

        long noOfDaysBetween = DAYS.between(stDate, endate);
        HiringCostDto hiringCostDto=new HiringCostDto();
        hiringCostDto.setId(vehicle.getId());
        hiringCostDto.setNumberOfDays((int)noOfDaysBetween);
        hiringCostDto.setTotalCost(noOfDaysBetween*vehicle.getPricePerDay());

        return hiringCostDto;
    }


}
