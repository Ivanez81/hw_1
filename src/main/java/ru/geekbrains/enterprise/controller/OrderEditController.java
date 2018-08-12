package ru.geekbrains.enterprise.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.dao.OrderDAO;
import ru.geekbrains.enterprise.entity.Order;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class OrderEditController {

    @Inject
    private OrderDAO orderDAO;

    @Nullable
    private String id;

    @NotNull
    private Order order = new Order();

    public void init() {
        @Nullable final Order order = orderDAO.getOrderById(id);
        if (order != null) this.order = order;
    }

    @NotNull
    public String save() {
        orderDAO.merge(order);
        return "order-list";
    }

    @NotNull
    public Order getOrder() {
        return order;
    }

    public void setOrder(@NotNull final Order order) {
        this.order = order;
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

}
