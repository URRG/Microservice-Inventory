package com.productservice.service;


import com.productservice.entity.Item;
import com.productservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository bRepo;
    public void save (Item b){
        bRepo.save(b);
    }
    public List<Item> getAllItem(){
        return bRepo.findAll();
    }
    public Item getItemById(int id){
        return bRepo.findById(id).get();
    }
    public void deleteById(int id){
        bRepo.deleteById(id);
    }
}
