package com.babcok.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "regNumber", nullable = false)
    private String regNumber;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "make", nullable = false)
    private String make;

    @Column(name = "fuelType", nullable = false)
    private String fuelType;

    @Column(name = "hiredOut", nullable = false)
    private boolean hiredOut;

    @Column(name = "pricePerDay", nullable = false)
    private double pricePerDay;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date hireDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date endDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_id", nullable = false)
    @JsonIgnore   // This breaks the infinite recursion problem
    private Booking booking;



    public Vehicle() {

    }

    public Vehicle(Long id, String regNumber, String category, String model, String make, String fuelType, boolean hiredOut, double pricePerDay, Date hireDate, Date endDate) {
        this.id = id;
        this.regNumber = regNumber;
        this.category = category;
        this.model = model;
        this.make = make;
        this.fuelType = fuelType;
        this.hiredOut = hiredOut;
        this.pricePerDay = pricePerDay;
        this.hireDate = hireDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public boolean getHiredOut() {
        return hiredOut;
    }

    public void setHiredOut(boolean hiredOut) {
        this.hiredOut = hiredOut;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isHiredOut() {
        return hiredOut;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.pricePerDay, pricePerDay) == 0 &&
                Objects.equals(id, vehicle.id) &&
                Objects.equals(regNumber, vehicle.regNumber) &&
                Objects.equals(category, vehicle.category) &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(make, vehicle.make) &&
                Objects.equals(fuelType, vehicle.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, regNumber, category, model, make, fuelType, pricePerDay);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", regNumber='" + regNumber + '\'' +
                ", category=" + category +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", fuelType=" + fuelType +
                ", hiredOut=" + hiredOut +
                ", pricePerDay=" + pricePerDay +
                ", hireDate=" + hireDate +
                ", endDate=" + endDate +
                '}';
    }
}