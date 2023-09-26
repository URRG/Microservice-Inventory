package com.bookstore.service;
import com.bookstore.entity.MyItemList;
import com.bookstore.repository.MyItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyItemListService {
    @Autowired
    private MyItemRepository myitem;
    public void saveMyItems(MyItemList item){
        myitem.save(item);
    }
    public List<MyItemList> getAllMyItems(){
        return myitem.findAll();
    }
    public void deleteById(int id){
        myitem.deleteById(id);
    }
}
