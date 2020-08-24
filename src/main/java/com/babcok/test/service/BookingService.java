package com.babcok.test.service;

import com.babcok.test.dto.CustomerDto;
import com.babcok.test.exception.BookingIdException;
import com.babcok.test.model.Booking;
import com.babcok.test.repository.BookingRepository;
import com.babcok.test.repository.CustomerRepository;
import com.babcok.test.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    public Booking saveOrUpdateBooking(Booking booking, String email) {

        if (booking.getId() != null) {
            Booking existingBooking = bookingRepository.findByCustomerEmail(email);

            if (existingBooking != null && (!existingBooking.getCustomer().getEmail().equals(email))) {
                throw new BookingIdException("We could not find any booking in your name");
            }
        }

        try {
            // Customer cus =
            CustomerDto customer = customerRepository.findCustomerByEmail(email);
            booking.setCustomer(booking.getCustomer());
            booking.setVehicle(booking.getVehicle());
            if (booking.getVehicle().getCategory().equals("Small car")) {
                booking.getVehicle().setPricePerDay(25.00);
            } else if (booking.getVehicle().getCategory().equals("Estate car")) {
                booking.getVehicle().setPricePerDay(34.00);
            } else if (booking.getVehicle().getCategory().equals("Van")) {
                booking.getVehicle().setPricePerDay(50.00);
            } else {
                System.out.println("No category of this type");
            }
           // Calculate cost of hiring a specific vehicle for a provided date range.
            return bookingRepository.save(booking);
        } catch (Exception e) {
            throw new BookingIdException("Booking with '" + booking.getCustomer().getEmail() + " already exist");
        }
    }

    //List available vehicles for hire – all vehicles that can be hired today.
}
