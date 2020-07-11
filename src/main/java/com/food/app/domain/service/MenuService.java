package com.food.app.domain.service;

import java.util.List;

public interface MenuService {
    List<Menu> findByRestaurant_Id(Long id);

    void deleteByRestaurant_Id(Long id);
    
    List<Menu> findAll();
    
    Menu findOne(Long id);
    
    void save(List<Menu> menuList);
}
