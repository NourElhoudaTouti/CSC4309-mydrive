package com.example.demo2.Services;

import com.example.demo2.Data.Entities.Trip;
import com.example.demo2.Data.Repositories.TripsRepository;
import com.example.demo2.Data.dtos.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private TripsRepository tripRepository;

    @Cacheable(value = "Cart")
    public static Cart getCart(long userId) {
        return new Cart();
    }

    @CachePut(value = "Cart", key = "#userId")
    public static Cart addTrip(Cart Cart, long userId, long tripId, int seat) {
       // com.example.demo2.Data.Entities.Trip trip = tripRepository.findById(tripId).get();
       // Cart.addTrip(trip,seat);
        return Cart;
    }


    @CachePut(value = "Cart", key = "#userId")
    public static Cart removeTrip(Cart Cart, long userId, long tripId) {
        //Trip trip = tripRepository.findById(tripId).get();
       // Cart.removeTrip(trip);
        return Cart;
    }

    @CachePut(value = "Cart", key = "#userId")
    public static Cart empty(Cart shoppingCart, long userId) {
        shoppingCart.empty();
        return shoppingCart;
    }
}
