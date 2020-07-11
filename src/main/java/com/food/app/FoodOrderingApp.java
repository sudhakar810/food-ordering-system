package com.food.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.food.app.domain.bean.Restaurant;
import com.food.app.domain.service.Menu;
import com.food.app.domain.service.RestaurantService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

@SpringBootApplication
public class FoodOrderingApp {

    public static void main(String[] args) {
        SpringApplication.run(FoodOrderingApp.class, args);
    }

//    @Bean
//    public ApplicationRunner demo(RestaurantRepository cr) {
//        return args -> {
//            Restaurant r1 = new Restaurant(null,"Restaurant1", "Location1", null);
//            Menu menu = new Menu(null, "name1", "info1", r1);
//            Menu[] menus = {menu};
//            r1.setMenus(new LinkedList<>(Arrays.asList(menus)));
//            cr.save(r1);
//            cr.save(new Restaurant(null, "Restauant2", "Location2", null));
//        };
//    }
}
