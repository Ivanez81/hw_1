package ru.geekbrains.enterprise.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.dao.ProductDAO;
import ru.geekbrains.enterprise.entity.Product;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

@ViewScoped
@ManagedBean
public class ProductListController {

    @Nullable
    private String orderId;

    @Inject
    private ProductDAO productDAO;

    @NotNull
    public List<Product> getListProduct() {
        if (orderId == null || orderId.isEmpty()) return productDAO.getListProduct();
        return productDAO.getListProduct()/*.getProductsByOrderId(orderId)*/;
    }

    public void removeProductById(@Nullable final String productId) {
        productDAO.removeProductById(productId);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
