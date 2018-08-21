package ru.geekbrains.enterprise.controller;

import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.dao.ProductDAO;
import ru.geekbrains.enterprise.dao.ProductOrderDAO;
import ru.geekbrains.enterprise.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ViewScoped
@ManagedBean
public class ProductListController {

    @Nullable
    private String orderId;

    @Nullable
    private String categoryId;

    @Inject
    private ProductDAO productDAO;

    @Inject
    private ProductOrderDAO productOrderDAO;

    @Nullable
    public List<Product> getListProduct() {
        if (orderId != null) return productDAO.getProductsByOrderId(orderId);
        if (categoryId != null) return productDAO.getProductsByCategoryId(categoryId);
        return productDAO.getListProduct();
    }

    public void removeProductById(@Nullable final String productId, @Nullable final String orderId) {
        if (orderId != null) {
            productOrderDAO.removeProductById(productId);
        } else {
            productDAO.removeProductById(productId);
        }
    }

    @Nullable
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(@Nullable final String orderId) {
        this.orderId = orderId;
    }

    @Nullable
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@Nullable final String categoryId) {
        this.categoryId = categoryId;
    }
}
