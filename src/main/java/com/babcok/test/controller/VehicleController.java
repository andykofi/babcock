package com.babcok.test.controller;

import com.babcok.test.dto.HiringCostDto;
import com.babcok.test.model.Vehicle;
import com.babcok.test.service.VehicleService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    public VehicleController( VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @GetMapping(path = "/listVehicleAvailableForHire",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehicle> listVehicleAvailableForHire() {
        List<Vehicle> allVehicles = vehicleService.listVehicleAvailableForHireToday(new Date());
        return allVehicles;
    }


    @GetMapping(path = "/calcualteCost",produces = MediaType.APPLICATION_JSON_VALUE)
    public HiringCostDto calcualteCost(@RequestParam(name = "vehicleId", required = true) long vehicleId,@RequestParam(name = "startDate", required = true)String startDate,@RequestParam(name = "endDate", required = true)String endDate ) {

        return vehicleService.calculateCost(vehicleId, startDate, endDate);
    }

//    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void updateVehicle(@PathVariable(name = "id") Long id, @RequestBody VehicleDto vehicleDto) {
//        VehicleDto vehicle = vehicleService.findById(id);
//        vehicle.setRegNumber(vehicleDto.getRegNumber());
//        vehicle.setCategory(vehicleDto.getCategory());
//        vehicle.setModel(vehicleDto.getModel());
//        vehicle.setMake(vehicleDto.getMake());
//        vehicle.setFuelType(vehicleDto.getFuelType());
//        vehicle.setHiredOut(vehicleDto.getHiredOut());
//        vehicle.setHireDate(vehicleDto.getHireDate());
//        vehicle.setEndDate(vehicleDto.getEndDate());
//
//       vehicleService.save(vehicle);
//    }

}