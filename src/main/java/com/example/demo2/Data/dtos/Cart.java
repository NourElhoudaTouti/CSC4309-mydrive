package com.example.demo2.Data.dtos;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;


public class Cart implements Serializable {
        private static final long serialVersionUID = 1718078099996510259L;
        private static Hashtable<Trip.Trips, Integer> selectedTrips;
        private static float tripsTotalPrice;


        public Cart(){
            selectedTrips = new Hashtable<Trip.Trips, Integer>();
            tripsTotalPrice = 0;
        }




        public static Hashtable<Trip.Trips, Integer> getSelectedTrips() {
            return selectedTrips;
        }

        public void setSelectedTrips(Hashtable<Trip.Trips, Integer> selectedTrips) {
            this.selectedTrips = selectedTrips;
        }

        public static float getTripsTotalPrice() {
            return tripsTotalPrice;
        }
        public void addTrip(com.example.demo2.Data.Entities.Trip trip, int seat){
            if(seat <= 0)
                return;
            if(seat > 1)
                return;
            String reation="add";
            updateTripsSeats(trip,seat,reation);
        }
        public void updateTripsSeats(com.example.demo2.Data.Entities.Trip trip, int seat, String reation){
            if(reation=="add")
                seat--;
            if(reation=="remove")
                seat++;
            Iterator<Map.Entry<Trip.Trips, Integer>> it = selectedTrips.entrySet().iterator();
            int TotalPrice = 0;
            while(((Iterator<?>) it).hasNext()){
                Map.Entry<Trip.Trips, Integer> e = (Map.Entry<Trip.Trips, Integer>) it.next();
                TotalPrice += e.getKey().getPrice() * e.getValue();
            }
        }
    public void removeTrip(com.example.demo2.Data.Entities.Trip trip){
        //if(selectedTrips.get(trip) != null)
            //removeTrip(selectedTrips.get(trip));
    }

        public boolean isEmpty(){
            return tripsTotalPrice == 0;
        }
        public void empty(){
            selectedTrips = new Hashtable<Trip.Trips, Integer>();
            tripsTotalPrice = 0;
        }

    }

