package com.example.demo2.Data.Entities;

import com.example.demo2.Data.dtos.Cart;
import com.example.demo2.Data.dtos.Trip;
import com.example.demo2.Data.dtos.User;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = " \"Reservation\"")
public class Reservation extends BaseEntity{
        @ManyToOne
        @NotNull
        protected User user;

        @OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        protected List<ReservationLine> reservationLine;

        protected ReservationStatus status;
        protected static float TripsTotalPrice;

        public Reservation(Cart cart, com.example.demo2.Data.Entities.User user) {
        }

        public Reservation(Cart cart, User user) {
            this.user = user;
            if (Cart.getSelectedTrips() != null) {
                Iterator<Map.Entry<Trip.Trips, Integer>> it = Cart.getSelectedTrips().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Trip.Trips, Integer> e = it.next();
                    new ReservationLine(this, e.getKey(), e.getValue());
                }
            }
            TripsTotalPrice = Cart.getTripsTotalPrice();
            status = ReservationStatus.MADE;
        }

    public Reservation() {

    }

    public void updateStatus(ReservationStatus newStatus) /*throws IllegalStatusChangeException*/ {
            if (status == ReservationStatus.CANCELED )
                //throw new IllegalStatusChangeException(newStatus);
                status = newStatus;
        }


    }

