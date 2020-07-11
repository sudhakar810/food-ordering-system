package com.food.app.domain.service;

import com.fasterxml.jackson.annotation.*;
import com.food.app.domain.bean.MenuItem;
import com.food.app.domain.bean.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
