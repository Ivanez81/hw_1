package ru.geekbrains.enterprise.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    @Nullable
    private String products_id;

    @Nullable
    private String orders_id;

    @NotNull
    public String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }

    @Nullable
    public String getProducts_id() {
        return products_id;
    }

    public void setProducts_id(@Nullable String products_id) {
        this.products_id = products_id;
    }

    @Nullable
    public String getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(@Nullable String orders_id) {
        this.orders_id = orders_id;
    }


}
