package ru.geekbrains.enterprise.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.dao.OrderDAO;
import ru.geekbrains.enterprise.dao.ProductDAO;
import ru.geekbrains.enterprise.dao.ProductOrderDAO;
import ru.geekbrains.enterprise.entity.Order;
import ru.geekbrains.enterprise.entity.ProductOrder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean
public class OrderEditController {

    @Inject
    private OrderDAO orderDAO;

    @Inject
    private ProductDAO productDAO;

    @Inject
    private ProductOrderDAO productOrderDAO;

    @Nullable
    private String id;

    @NotNull
    private Order order = new Order();

    @NotNull
    private List<String> productNames = new ArrayList<>();

    public void init() {
        @Nullable final Order order = orderDAO.getOrderById(id);
        if (order != null) this.order = order;
    }

    @Nullable
    public String save() {
        orderDAO.merge(order);
        for (String s: productNames) {
            @NotNull
            ProductOrder productOrder = new ProductOrder();
            productOrder.setOrder(order);
            productOrder.setProduct(productDAO.getProductByName(s));
            productOrderDAO.mergeProductOrder(productOrder);
        }
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

    @Nullable
    public List<String> getListProductName() {
        return productDAO.getListProductName();
    }

    @NotNull
    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(@NotNull final List<String> productNames) {
        this.productNames = productNames;
    }
}
