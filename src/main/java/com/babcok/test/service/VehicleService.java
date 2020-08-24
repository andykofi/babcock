package com.babcok.test.service;


import com.babcok.test.dto.VehicleDto;
import com.babcok.test.mapper.VehicleMapper;
import com.babcok.test.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class VehicleService  {

   private VehicleRepository vehicleRepository;

   @Autowired
   public VehicleService(VehicleRepository vehicleRepository) {
       this.vehicleRepository = vehicleRepository;
   }

   public List<VehicleDto> findAll() {
       return vehicleRepository.findAll().stream().map(VehicleMapper:: toDto)
               .collect(Collectors.toList());
   }

   public List<VehicleDto> findAllByModel(String model) {
       return  vehicleRepository.findAllByModel(model).stream().map(VehicleMapper:: toDto)
               .collect(Collectors.toList());
   }

   public VehicleDto findById(Long id) {
       return  VehicleMapper.toDto(vehicleRepository.findById(id).get());
   }

   public VehicleDto save(VehicleDto vehicleDto) {
       vehicleRepository.save(VehicleMapper.toEntry(vehicleDto));
       return null;
   }

   public VehicleDto calculateCost() {
       // To be done later;
       return null;
   }


}
