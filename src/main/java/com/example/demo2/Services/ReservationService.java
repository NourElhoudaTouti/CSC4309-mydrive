package com.example.demo2.Services;

import com.example.demo2.Data.Entities.Reservation;
import com.example.demo2.Data.Entities.ReservationStatus;
import com.example.demo2.Data.Entities.User;
import com.example.demo2.Data.Repositories.ReservationRepository;
import com.example.demo2.Data.Repositories.UserRepository;
import com.example.demo2.Data.dtos.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationService {


    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartService cartService;

    public List<Reservation> getOrdersByCustomer(long customerId) {
        return reservationRepository.findByCustomer(customerId);
    }

    public void checkout(long userId) {
        User user = userRepository.findById(userId).get();
        Cart Cart = CartService.getCart(userId);
        if(Cart == null || Cart.getTripsTotalPrice() == 0)
            return;

        Reservation reservation = new Reservation(Cart, user);
        reservationRepository.save(reservation);
        CartService.empty(Cart, user.getId());
    }

    public void updateOrderStatus(long orderId, ReservationStatus newStatus){
        Reservation reservation = reservationRepository.findById(orderId).get();
        reservation.updateStatus(newStatus);
        reservationRepository.save(reservation);
    }
}
