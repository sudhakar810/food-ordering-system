package com.food.ordering.rest;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.food.ordering.system.bean.DeliveryInfo.OrderInfo;
import com.food.ordering.system.bean.Validate;
import com.food.ordering.system.service.DriverService;
import com.food.ordering.util.FoodOrderingUtil;

@Slf4j
@RestController
@RequestMapping("/driver")
public class DriverController {

	Logger log = LoggerFactory.getLogger(DriverController.class);
    @Autowired
    private DriverService driverService;

    @PostMapping("/login")
    public ResponseEntity<Validate> driverLogin(@RequestBody Validate validate) {
    	
    	String token = null;
    	
    	Boolean isExist =  driverService.validateDriver(validate);
    	
    	if(isExist) {
    		token = FoodOrderingUtil.getJWTToken(validate.getId());
    	}
    	
    	validate.setToken(token);
    	validate.setPassword(null);
        log.info("logged in Driver: " + validate.toString());
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
    
    @RequestMapping("/getOrderInfo/{resId}")
    public ResponseEntity<OrderInfo> getItems(@PathVariable("resId") String resId) {
    	OrderInfo orderinfo = driverService.getOrderInformationWithRestaurant(resId);
        log.info("Fetch all: " + orderinfo);
        return  new ResponseEntity<>(orderinfo,HttpStatus.OK);
    }
    
    @PutMapping("/updateOrderInfo/{orderId}/{pickedUp}")
    public ResponseEntity<String> itemPickedUp(@PathVariable("orderId") Integer orderId,@PathVariable("pickedUp") boolean pickedUp) {
    	String result = driverService.itemPickedUp(orderId,pickedUp);
        log.info("Fetch all: " + result);
        return  new ResponseEntity<>(result,HttpStatus.OK);
    }
    
    
    @PutMapping("/updateDeliveryStatus/{orderId}/{delivered}")
    public ResponseEntity<String> itemDelivered(@PathVariable("orderId") Integer orderId,@PathVariable("delivered") boolean delivered) {
    	String result = driverService.itemDelivered(orderId,delivered);
        log.info("Fetch all: " + result);
        return  new ResponseEntity<>(result,HttpStatus.OK);
    }
    
    
}
