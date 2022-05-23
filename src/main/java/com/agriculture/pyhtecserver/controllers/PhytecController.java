package com.agriculture.pyhtecserver.controllers;


import com.agriculture.pyhtecserver.models.Item;
import com.agriculture.pyhtecserver.models.ItemRS;
import com.agriculture.pyhtecserver.services.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/PhytecItems")
public class PhytecController {


    @Autowired
    ItemService itemService;


    @GetMapping()
    public List<Item> getAllItems(){
        log.info("getAllItems");
        return itemService.getAllItems();
    }


    @GetMapping("/getAmountOfItem/{id}")
    public List<String> getAmountOfItem(@PathVariable int id){
        log.info("getAllItems");
        return itemService.getAmountOfItem(id);
    }


    @GetMapping("/buyItem/{id}")
    public void buyItem(@PathVariable Long id){
        log.info("getAllItems");
        itemService.buyItem(id);
    }





}
