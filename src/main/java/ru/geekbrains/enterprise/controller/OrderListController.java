package ru.geekbrains.enterprise.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.dao.OrderDAO;
import ru.geekbrains.enterprise.entity.Order;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Collection;

@ViewScoped
@ManagedBean
public class OrderListController {

    @Inject
    private OrderDAO orderDAO;

    @NotNull
    public Collection<Order> getListOrder() {
        return orderDAO.getOrders();
    }

    public void removeOrderById(@Nullable final String orderId) {
        orderDAO.removeOrderById(orderId);
    }

}
