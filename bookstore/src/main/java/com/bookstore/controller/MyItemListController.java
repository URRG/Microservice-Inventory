package com.bookstore.controller;

import com.bookstore.service.MyItemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyItemListController {

    @Autowired
    private MyItemListService service;
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/my_items";
    }
}
