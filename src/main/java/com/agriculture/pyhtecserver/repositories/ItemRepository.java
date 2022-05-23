package com.agriculture.pyhtecserver.repositories;

import com.agriculture.pyhtecserver.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query(value = "select id,description,price from items", nativeQuery=true )
    public List<Item> getAllItems();


    @Query(nativeQuery=true, value="SELECT description,price,amount FROM get_item_amount(:id)")
    public List<String> getAmountByItem(@Param("id") Integer id);


    @Transactional
    @Modifying
    @Query(value="  update stock set amount = a.amount - 1\n" +
            "        from \n" +
            "        (\n" +
            "          select item_id,amount from stock limit 1\n" +
            "        ) as a \n" +
            "        where a.amount > 0", nativeQuery=true )
    void buyItem(@Param("item_id") long item_id);



}
