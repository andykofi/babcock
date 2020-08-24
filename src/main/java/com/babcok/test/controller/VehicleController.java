package com.babcok.test.controller;

import com.babcok.test.dto.VehicleDto;
import com.babcok.test.service.MapValidationErrorService;
import com.babcok.test.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    public VehicleController( VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleDto> getVehicles(@RequestParam(name = "brand", required = false) String model) {
        List<VehicleDto> allVehicles = null;
        if (model!= null) {
            allVehicles = vehicleService.findAllByModel(model);
        } else {
            allVehicles = vehicleService.findAll();
        }
        return allVehicles;
    }


    @GetMapping("/{vehicleId}")
    public ResponseEntity<?> getVehicleById(@PathVariable Long vehicleId) {
        VehicleDto vehicleDto = vehicleService.findById(vehicleId);
        return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveVehicle(@RequestBody VehicleDto vehicleDto) {
        vehicleService.save(vehicleDto);
    }

    @PostMapping("")
    public ResponseEntity<?> saveNewVehicle( @RequestBody VehicleDto vehicleDto, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;
        VehicleDto vehicleDto1 = vehicleService.save(vehicleDto);
        return new ResponseEntity<>(vehicleDto1, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateVehicle(@PathVariable(name = "id") Long id, @RequestBody VehicleDto vehicleDto) {
        VehicleDto vehicle = vehicleService.findById(id);
        vehicle.setRegNumber(vehicleDto.getRegNumber());
        vehicle.setCategory(vehicleDto.getCategory());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setMake(vehicleDto.getMake());
        vehicle.setFuelType(vehicleDto.getFuelType());
        vehicle.setHiredOut(vehicleDto.getHiredOut());
        vehicle.setHireDate(vehicleDto.getHireDate());
        vehicle.setEndDate(vehicleDto.getEndDate());

       vehicleService.save(vehicle);
    }

}
