package com.example.demo2.Data.Entities;

import com.example.demo2.Data.dtos.Trip;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"Review\"")
public class Review extends BaseEntity{
        //private static final long serialVersionUID = 8080148085913683937L;

        @ManyToOne
        @NotNull
        private Trip trip;

        @NotNull
        private String eval;

        private float grade;

        public Review() {
        }

        public Trip getTrips() {
            return trip;
        }

        public void setTrips(Trip trip) {
            this.trip = trip;
        }

        public String getEval() {
            return eval;
        }

        public void setEval(String eval) {
            this.eval = eval;
        }

        public float getGrade() {
            return grade;
        }

        public void setGrade(float grade) {
            this.grade = grade;
        }
    }
