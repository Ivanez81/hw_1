package ru.geekbrains.enterprise.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.entity.Order;
import javax.ejb.Stateful;
import java.util.List;

@Stateful
public class OrderDAO extends AbstractDAO{

    public Order findOne(String id) {
        return em.find(Order.class, id);
    }

    @NotNull
    public List<Order> getOrders() {
        return em.createQuery("SELECT e FROM Order e ORDER BY e.created DESC", Order.class).getResultList();
    }

    @Nullable
    public Order getOrderById(@Nullable final String orderId) {
        if (orderId == null || orderId.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT e FROM Order e WHERE e.id = :id", Order.class)
                .setParameter("id", orderId)
                .setMaxResults(1));
    }

    @Nullable
    public Order persist(@Nullable final Order order) {
        if (order == null) return null;
        em.persist(order);
        return order;
    }

    @Nullable
    public Order merge(@Nullable final Order order) {
        if (order == null) return null;
        return em.merge(order);
    }

    public void removeOrderById(@Nullable final String orderId) {
        @Nullable final Order order = getOrderById(orderId);
        if (order == null) return;
        em.remove(order);
    }

}
