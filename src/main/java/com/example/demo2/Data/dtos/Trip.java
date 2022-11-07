package com.example.demo2.Data.dtos;

import java.io.Serializable;
import java.util.Date;

public class Trip {




    public class Trips implements Serializable {
        private static final long serialVersionUID = 781803052368469398L;
        private String destination;
        private float price;
        private Date date;
        private int availableSeats;
        private String Carbrand;
        private String drivergender;

        private Cart  cart;

        public Trips() {
        }

        public Trips(String destination, float price, Date date, int availableSeats, String carbrand, String drivergender) {
            this.destination = destination;
            this.price = price;
            this.date = date;
            this.availableSeats = availableSeats;
            Carbrand = carbrand;
            this.drivergender = drivergender;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public  int getAvailableSeats() {
            return availableSeats;
        }

        public void setAvailableSeats(int availableSeats) {
            this.availableSeats = availableSeats;
        }

        public String getCarbrand() {
            return Carbrand;
        }

        public void setCarbrand(String carbrand) {
            Carbrand = carbrand;
        }

        public String getDrivergender() {
            return drivergender;
        }

        public void setDrivergender(String drivergender) {
            this.drivergender = drivergender;
        }

    }

}
