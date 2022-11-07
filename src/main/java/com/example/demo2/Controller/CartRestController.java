package com.example.demo2.Controller;

import com.example.demo2.Data.Entities.User;
import com.example.demo2.Data.Repositories.UserRepository;
import com.example.demo2.Data.dtos.Cart;
import com.example.demo2.Data.dtos.Trip;
import com.example.demo2.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CartRestController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserRepository userRepository;

    private User user;
    private long userId;

    @GetMapping("/get")
    public Cart getCart(Authentication auth ){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        System.out.println(cartService);
        return CartService.getCart(userId);
    }

    //@PatchMapping("/addTrip")
    /*public Cart addProduct(@RequestBody Trip dto,Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        Cart shoppingCart = CartService.getCart(userId);
       // return CartService.addTrip(shoppingCart, userId, dto.getId(), dto.getAvailableSeats());

    }*/
    /*@PatchMapping("/removeTrip")
    public Cart removeProduct(@RequestBody Trip dto,Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        Cart shoppingCart = CartService.getCart(userId);
        return CartService.removeTrip(shoppingCart, userId, dto.getId());
    }*/

}
