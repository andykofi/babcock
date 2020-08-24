package com.babcok.test.controller;

import com.babcok.test.dto.CustomerDto;
import com.babcok.test.model.Booking;
import com.babcok.test.service.BookingService;
import com.babcok.test.service.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("api/booking")
@CrossOrigin
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewVehicleRental(@RequestBody Booking booking, BindingResult result, CustomerDto customerDto) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;
        Booking booking1 = bookingService.saveOrUpdateBooking(booking, customerDto.getEmail());
        return new ResponseEntity<>(booking1, HttpStatus.CREATED);
    }

}
