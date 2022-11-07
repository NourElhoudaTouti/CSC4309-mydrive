package com.example.demo2.Controller;

import com.example.demo2.Data.Entities.Reservation;
import com.example.demo2.Data.Entities.ReservationStatus;
import com.example.demo2.Data.Entities.User;
import com.example.demo2.Data.Repositories.UserRepository;
import com.example.demo2.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/Reservation")
public class ReservationRestController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserRepository userRepository;

    private User user;
    private long userId;

    @GetMapping("/getReservations")
    public Reservation getReservationByUser(Authentication auth) {
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        System.out.println(reservationService);
        return (Reservation) reservationService.getOrdersByCustomer(userId);
    }

    @GetMapping("/checkout")
    public void checkout(Authentication auth) {
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        reservationService.checkout(userId);
    }

    @GetMapping("/backOffice/updateStatus")
    public void updateOrderStatus(@RequestParam long reservationId, @RequestParam int newStatus) {
        switch (newStatus) {
            case 1:
                reservationService.updateOrderStatus(reservationId, ReservationStatus.MADE);
                break;
            case 2:
                reservationService.updateOrderStatus(reservationId, ReservationStatus.CANCELED);
                break;
            case 3:
                reservationService.updateOrderStatus(reservationId, ReservationStatus.ONHOLD);
                break;

        }
    }
}
