package com.agriculture.pyhtecserver.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock")
public class Stock {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "description")
    private String desc;

    @Column(name = "price")
    private int price;


    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item_id;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public Item getItem_id() {
        return item_id;
    }

    public void setItem_id(Item item_id) {
        this.item_id = item_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Float.compare(stock.price, price) == 0 && id.equals(stock.id) && desc.equals(stock.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc, price);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                '}';
    }

}
