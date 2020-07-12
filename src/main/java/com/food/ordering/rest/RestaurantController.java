package com.food.ordering.rest;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.food.ordering.system.bean.Restaurant;
import com.food.ordering.system.bean.Validate;
import com.food.ordering.system.bean.DeliveryInfo.OrderInfo;
import com.food.ordering.system.service.Menu;
import com.food.ordering.system.service.MenuService;
import com.food.ordering.system.service.RestaurantService;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	Logger log = LoggerFactory.getLogger(RestaurantController.class);
    
	@Autowired
    private RestaurantService restaurantService;

    
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean loginRestaurant(@RequestBody Validate validate) {
    	boolean result = restaurantService.validateRestaurant(validate);
        log.info("logged in restaurant: " + result);
        //cr.save(restaurants);
        return result;
    }
    
    
    @RequestMapping("/getOrders/{resId}")
    public ResponseEntity<List<OrderInfo>> getItems(@PathVariable("resId") String resId) {
    	List<OrderInfo> orderinfo = restaurantService.getPlacedOrder(resId);
        log.info("Fetch all: " + orderinfo);
        return  new ResponseEntity<>(orderinfo,HttpStatus.OK);
    }
    
    @RequestMapping("/")
    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantService.findAll();
        log.info("Fetch all: " + restaurants);
        return restaurants;
    }

}
