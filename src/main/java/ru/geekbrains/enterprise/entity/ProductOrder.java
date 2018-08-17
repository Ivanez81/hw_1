package ru.geekbrains.enterprise.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "product_orders")
public class ProductOrder {
    @Id
    @NotNull
    private String id = UUID.randomUUID().toString();

    @NotNull
    private String products_id;

    @NotNull
    private String orders_id;

    public String getId() {
        return id;
    }

    @NotNull
    public void setId(@NotNull String id) {
        this.id = id;
    }

    public String getProducts_id() {
        return products_id;
    }

    @NotNull
    public void setProducts_id(@NotNull String products_id) {
        this.products_id = products_id;
    }

    public String getOrders_id() {
        return orders_id;
    }

    @NotNull
    public void setOrders_id(@NotNull String orders_id) {
        this.orders_id = orders_id;
    }


}
