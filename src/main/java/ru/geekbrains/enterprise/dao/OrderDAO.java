package ru.geekbrains.enterprise.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.entity.Order;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
public class OrderDAO {

    @NotNull
    private Map<String, Order> orders = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        merge(new Order("Order 1", "Demo Order 1"));
        merge(new Order("Order 2", "Demo Order 2"));
        merge(new Order("Order 3", "Demo Order 3"));
        merge(new Order("Order 4", "Demo Order 4"));
    }

    @NotNull
    public Collection<Order> getOrders() {
        return orders.values();
    }

    @Nullable
    public Order getOrderById(@Nullable final String orderId) {
        if (orderId == null || orderId.isEmpty()) return null;
        return orders.get(orderId);
    }

    @Nullable
    public Order merge(@Nullable final Order order) {
        if (order == null) return null;
        @Nullable final String id = order.getId();
        if (id == null || id.isEmpty()) return null;
        this.orders.put(id, order);
        return order;
    }

    public void removeOrderById(@Nullable final String orderId) {
        if (orderId == null || orderId.isEmpty()) return;
        if (!orders.containsKey(orderId)) return;
        orders.remove(orderId);
    }

}
