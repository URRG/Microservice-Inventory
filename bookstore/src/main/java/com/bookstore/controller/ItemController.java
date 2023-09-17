package com.bookstore.controller;

import com.bookstore.entity.Item;
import com.bookstore.entity.MyItemList;
import com.bookstore.service.ItemService;
import com.bookstore.service.MyItemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService service;
    @Autowired
    private MyItemListService myItemService;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/item_register")
    public String itemRegister(){
        return "itemRegister";
    }
    @GetMapping("/available_items")
    public ModelAndView getAllItem(){
        List<Item>list=service.getAllItem();
        ModelAndView m=new ModelAndView();
        m.setViewName("itemList");
        m.addObject("item",list);
        return new ModelAndView("itemList","item",list);
    }

    @PostMapping("/save")
    public String addItem(@ModelAttribute Item b){
        service.save(b);
        return "redirect:/available_items";
    }
    @GetMapping("/my_items")
    public String getMyItems(Model model){
        List<MyItemList>list=myItemService.getAllMyItems();
        model.addAttribute("item",list);
        return "myItems";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
    Item b=service.getItemById(id);
        MyItemList mb=new MyItemList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        service.deleteById(id);
    myItemService.saveMyItems(mb);
    return "redirect:/available_items";
    }
    @RequestMapping("/editItem/{id}")
    public String editItem(@PathVariable("id") int id, Model model){
        Item b=service.getItemById(id);
        model.addAttribute("item",b);
        return "itemEdit";
    }
    @RequestMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable("id") int id){
        service.deleteById(id);
    return "redirect:/available_items";
    }
}
