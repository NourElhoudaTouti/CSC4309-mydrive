package com.example.demo2.Data.Entities;

import com.example.demo2.Data.dtos.Trip;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ReservationLine extends BaseEntity{

        private static final long serialVersionUID = -2465717954068251960L;

        @ManyToOne
        @NotNull
        private Reservation reservation;

        @ManyToOne
        @NotNull
        private Trip trip;
        private  float Unitprice;
        private float price;

        public ReservationLine(Reservation reservation, Trip.Trips key, Integer value) {
        }

        public ReservationLine(Reservation reservation, Trip trip) {
            this.reservation = reservation;
            this.trip = trip;
           //Unitprice = trip.getPrice();
           // price=Unitprice;
        }

        public ReservationLine() {

        }

        public Reservation getReservation() {
            return reservation;
        }

        public void setReservation(Reservation reservation) {
            this.reservation = reservation;
        }

        public Trip getTrip() {
            return trip;
        }

        public void setTrip(Trip trip) {
            this.trip = trip;
        }

        public float getUnitprice() {
            return Unitprice;
        }

        public void setUnitprice(float unitprice) {
            Unitprice = unitprice;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }
    }

