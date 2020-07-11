package com.food.ordering.rest;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.food.ordering.system.bean.Invoice;
import com.food.ordering.system.bean.MenuItem;
import com.food.ordering.system.bean.Order;
import com.food.ordering.system.bean.Restaurant;
import com.food.ordering.system.bean.Validate;
import com.food.ordering.system.service.CustomerService;
import com.food.ordering.system.service.Menu;
import com.food.ordering.system.service.MenuService;
import com.food.ordering.system.service.RestaurantService;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

	Logger log = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService cr;

   // @Autowired
    private MenuService mr;

    
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public String customerLogin(@RequestBody Validate validate) {
    	String result = cr.validateCustomer(validate);
        log.info("logged in customer: " + result);
        return result;
    }
    
    
    @RequestMapping("/findRestaurant")
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        List<Restaurant> restaurants = cr.findAllRestaurant();
        log.info("Fetch all: " + restaurants);
        return  new ResponseEntity<>(restaurants,HttpStatus.OK);
    }
    
    
    @RequestMapping("/getMenuItem/{resId}")
    public ResponseEntity<List<MenuItem>> getItems(@PathVariable("resId") String resId) {
        List<MenuItem> menuItems = cr.findMenuItems(resId);
        log.info("Fetch all: " + menuItems);
        return  new ResponseEntity<>(menuItems,HttpStatus.OK);
    }
    
    
    

    @PostMapping("/foodOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<Invoice> customerLogin(@RequestBody List<Order> orderList) {
    	Invoice invoice = cr.OrderFood(orderList);
        log.info("logged in customer: " + invoice.toString());
        return new ResponseEntity<>(invoice,HttpStatus.OK);
    }
    

}
