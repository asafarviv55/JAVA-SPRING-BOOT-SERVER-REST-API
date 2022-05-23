package com.agriculture.pyhtecserver.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemRS {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    public String description;

    @Column(name = "price")
    public int price;

    @Column(name = "amount")
    public double amount;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemRS itemRS = (ItemRS) o;
        return price == itemRS.price && Double.compare(itemRS.amount, amount) == 0 && Objects.equals(id, itemRS.id) && Objects.equals(description, itemRS.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, price, amount);
    }

    @Override
    public String toString() {
        return "ItemRS{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }


}
