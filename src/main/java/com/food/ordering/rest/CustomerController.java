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
import com.food.ordering.util.FoodOrderingUtil;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

	Logger log = LoggerFactory.getLogger(CustomerController.class);
   
	@Autowired
    private CustomerService customerService;
    
    @PostMapping("/login")
    public ResponseEntity<Validate>  customerLogin(@RequestBody Validate validate) {
    	
    	String token = null;
    	
    	Boolean isExist =  customerService.validateCustomer(validate);
    	
    	if(isExist) {
    		token = FoodOrderingUtil.getJWTToken(validate.getId());
    	}
    	
    	validate.setToken(token);
    	validate.setPassword(null);
        log.info("logged in Customer: " + validate.toString());
        return  new ResponseEntity<>(validate,HttpStatus.OK);
    }
    
    @RequestMapping("/logout")
    public ResponseEntity<String> logout() {
    	String result = null;
    	String invalidateToken = FoodOrderingUtil.invalidateToken();
    	if(invalidateToken.isEmpty()) {
    		result = "successfully logout";
    	}
    	log.info("Fetch all: " + invalidateToken);
        return  new ResponseEntity<>(result,HttpStatus.OK);
    }
    
    @RequestMapping("/findRestaurant")
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        List<Restaurant> restaurants = customerService.findAllRestaurant();
        log.info("Fetch all: " + restaurants);
        return  new ResponseEntity<>(restaurants,HttpStatus.OK);
    }
    
    
    @RequestMapping("/getMenuItem/{resId}")
    public ResponseEntity<List<MenuItem>> getItems(@PathVariable("resId") String resId) {
        List<MenuItem> menuItems = customerService.findMenuItems(resId);
        log.info("Fetch all: " + menuItems);
        return  new ResponseEntity<>(menuItems,HttpStatus.OK);
    }
    
    
    

    @PostMapping("/foodOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<Invoice> customerLogin(@RequestBody List<Order> orderList) {
    	Invoice invoice = customerService.OrderFood(orderList);
        log.info("logged in customer: " + invoice.toString());
        return new ResponseEntity<>(invoice,HttpStatus.OK);
    }
    

}
