package ru.geekbrains.enterprise.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ProductOrder extends AbstractEntity {

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    @NotNull
    public Order getOrder() {
        return order;
    }

    public void setOrder(@NotNull final Order order) {
        this.order = order;
    }

    @Nullable
    public Product getProduct() {
        return product;
    }

    public void setProduct(@Nullable final Product product) {
        if (product == null) return;
        this.product = product;
    }

}
