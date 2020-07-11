package com.food.app.rest;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.app.domain.bean.Restaurant;
import com.food.app.domain.service.RestaurantService;

@RestController
public class OnlineFoodOrderingRestController {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

}
