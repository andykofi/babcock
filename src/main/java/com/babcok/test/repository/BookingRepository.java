package com.babcok.test.repository;

import com.babcok.test.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
  //  Booking findBookingByEmail(String email);
    Booking findByCustomerEmail(String email);
}
