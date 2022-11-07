package com.example.demo2.Data.Entities;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "\"Trip\"")

public class Trip extends BaseEntity{
        private static final long serialVersionUID = 730736845770996539L;

        @NotNull
        private String Destination;

        @NotNull
        private Date date;

        @NotNull
        private String Carbrand;

        @NotNull
        private String DriverGender;

        @NotNull
        private float price;

        @NotNull
        private int availableSeat;

        @OneToMany(mappedBy = "trips", fetch = FetchType.LAZY)
        private List<Review> reviews;

        public Trip() {
        }

        public String getDestination() {
            return Destination;
        }

        public void setDestination(String destination) {
            Destination = destination;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getCarbrand() {
            return Carbrand;
        }

        public void setCarbrand(String carbrand) {
            Carbrand = carbrand;
        }

        public String getDriverGender() {
            return DriverGender;
        }

        public void setDriverGender(String driverGender) {
            DriverGender = driverGender;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public int getAvailableSeat() {
            return availableSeat;
        }

        public void setAvailableSeat(int availableSeat) {
            this.availableSeat = availableSeat;
        }

        public List<Review> getReviews() {
            return reviews;
        }

        public void setReviews(List<Review> reviews) {
            this.reviews = reviews;
        }
    }
