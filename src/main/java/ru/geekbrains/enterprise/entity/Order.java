package ru.geekbrains.enterprise.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order extends AbstractEntity {

    @NotNull
    private String name = "";

    @Nullable
    private String description = "";

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "orders", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public Order() {
    }

    public Order(@NotNull final String name) {
        this.name = name;
    }

    public Order(@NotNull final String name, @Nullable String description) {
        this.name = name;
        this.description = description;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull final String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable final String description) {
        this.description = description;
    }

    @NotNull
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(@NotNull List<Product> products) {
        this.products = products;
    }
}
