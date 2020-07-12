package com.food.ordering.rest;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.food.ordering.system.bean.Restaurant;
import com.food.ordering.system.bean.Validate;
import com.food.ordering.system.bean.DeliveryInfo.OrderInfo;
import com.food.ordering.system.service.Menu;
import com.food.ordering.system.service.MenuService;
import com.food.ordering.system.service.RestaurantService;
import com.food.ordering.util.FoodOrderingUtil;
import com.food.ordering.util.GeneratePdfReport;

import java.io.ByteArrayInputStream;
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
    public ResponseEntity<Validate> loginRestaurant(@RequestBody Validate validate) {
    	
    	String token = FoodOrderingUtil.getJWTToken(validate.getId());
    	
    	validate.setToken(token);
    	validate.setPassword(null);
        log.info("logged in restaurant: " + validate.toString());
        return  new ResponseEntity<>(validate,HttpStatus.OK);
    }
    
    
    @RequestMapping("/getOrders/{resId}")
    public ResponseEntity<List<OrderInfo>> getItems(@PathVariable("resId") String resId) {
    	List<OrderInfo> orderinfo = restaurantService.getPlacedOrder(resId);
        log.info("Fetch all: " + orderinfo);
        return  new ResponseEntity<>(orderinfo,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/printInvoice/{resId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    	public ResponseEntity<InputStreamResource> printInvoice(@PathVariable("resId") String resId) {
	    	List<OrderInfo> orderinfo = restaurantService.getPlacedOrder(resId);
	    	ByteArrayInputStream bis = GeneratePdfReport.generateInvoice(orderinfo);
	    	
	    	HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=invoice.pdf");
	       return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
    }

}
