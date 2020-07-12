package com.food.ordering.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.food.ordering.system.bean.MenuItem;
import com.food.ordering.system.service.MenuItemService;

@RestController
@RequestMapping("/menuItems")
public class MenuItemController {

    //@Autowired
    private MenuItemService mir;

    @GetMapping("/")
    public List<MenuItem> getMenItems() {
        return mir.findAll();
    }

    @GetMapping("/{id}")
    public MenuItem findMenuById(@PathVariable("id") Long id) {
        return mir.findOne(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<MenuItem> menuItemList) {
        mir.save(menuItemList);
    }

    @DeleteMapping("/")
    public void deleteAll() {
       // mir.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
       // mir.delete(id);
    }

}
