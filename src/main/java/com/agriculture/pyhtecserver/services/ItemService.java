package com.agriculture.pyhtecserver.services;


import com.agriculture.pyhtecserver.models.Item;
import com.agriculture.pyhtecserver.models.ItemRS;
import com.agriculture.pyhtecserver.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItems(){  return itemRepository.getAllItems();  }

    public List<String>  getAmountOfItem(int item_id){ return itemRepository.getAmountByItem(item_id);  }

    public void buyItem(long item_id){
        itemRepository.buyItem(item_id);
    }

}
