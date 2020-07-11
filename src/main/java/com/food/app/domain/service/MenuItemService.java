package com.food.app.domain.service;

import java.util.List;

import com.food.app.domain.bean.MenuItem;

public interface MenuItemService  {

    List<MenuItem> findByMenu_Id(Long id);
    
    List<MenuItem> findAll();
    
    MenuItem findOne(Long id);
    
    void save(List<MenuItem> menuList);
}
