package com.food.ordering.rest;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.food.ordering.system.bean.DeliveryInfo;
import com.food.ordering.system.bean.DeliveryInfo.OrderInfo;
import com.food.ordering.system.bean.Invoice;
import com.food.ordering.system.bean.MenuItem;
import com.food.ordering.system.bean.Order;
import com.food.ordering.system.bean.Restaurant;
import com.food.ordering.system.bean.Validate;
import com.food.ordering.system.service.CustomerService;
import com.food.ordering.system.service.DriverService;
import com.food.ordering.system.service.Menu;
import com.food.ordering.system.service.MenuService;
import com.food.ordering.system.service.RestaurantService;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/driver")
public class DriverController {

	Logger log = LoggerFactory.getLogger(DriverController.class);
    @Autowired
    private DriverService driverService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean driverLogin(@RequestBody Validate validate) {
    	boolean result = driverService.validateDriver(validate);
        log.info("logged in driver: " + result);
        return result;
    }
    
    @RequestMapping("/getOrderInfo/{resId}")
    public ResponseEntity<OrderInfo> getItems(@PathVariable("resId") String resId) {
    	OrderInfo orderinfo = driverService.getOrderInformationWithRestaurant(resId);
        log.info("Fetch all: " + orderinfo);
        return  new ResponseEntity<>(orderinfo,HttpStatus.OK);
    }
    
}
