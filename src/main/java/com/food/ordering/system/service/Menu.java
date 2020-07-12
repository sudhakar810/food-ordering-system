package com.food.ordering.system.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.food.ordering.system.bean.MenuItem;
import com.food.ordering.system.bean.Restaurant;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Menu {

 
 
    private Long id;

    private String type;

    private String info;

    private List<MenuItem> items;
    private Restaurant restaurant;

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }


    public Menu(Long id, String type, String info, Restaurant restaurant) {
        this.id = id;
        this.type = type;
        this.info = info;
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", info='" + info + '\'' +
                ", items=" + items +
                '}';
    }
}
