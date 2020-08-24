package com.babcok.test.mapper;

import com.babcok.test.dto.VehicleDto;
import com.babcok.test.model.Vehicle;

public class VehicleMapper {

    public static VehicleDto toDto(Vehicle vehicle) {

        VehicleDto vehicleDto = new VehicleDto();

        vehicleDto.setId(vehicle.getId());
        vehicleDto.setRegNumber(vehicle.getRegNumber());
        vehicleDto.setCategory(vehicle.getCategory());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setMake(vehicle.getMake());
        vehicleDto.setFuelType(vehicle.getFuelType());
        vehicleDto.setHiredOut(vehicle.getHiredOut());
        vehicleDto.setPricePerDay(vehicle.getPricePerDay());
        vehicleDto.setHireDate(vehicle.getHireDate());
        vehicleDto.setEndDate(vehicle.getEndDate());

        return vehicleDto;

    }

    public static  Vehicle toEntry(VehicleDto vehicleDto) {

        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDto.getId());
        vehicle.setRegNumber(vehicleDto.getRegNumber());
        vehicle.setCategory(vehicleDto.getCategory());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setMake(vehicleDto.getMake());
        vehicle.setFuelType(vehicleDto.getFuelType());
        vehicle.setHiredOut(vehicleDto.getHiredOut());
        vehicle.setPricePerDay(vehicleDto.getPricePerDay());
        vehicle.setHireDate(vehicleDto.getHireDate());
        vehicle.setEndDate(vehicleDto.getEndDate());

        return vehicle;
    }
}
