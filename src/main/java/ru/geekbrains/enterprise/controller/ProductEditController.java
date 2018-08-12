package ru.geekbrains.enterprise.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.dao.ProductDAO;
import ru.geekbrains.enterprise.entity.Product;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class ProductEditController {

    @Inject
    private ProductDAO productDAO;

    @Nullable
    private String id;

    @NotNull
    private Product product = new Product();

    public void init() {
        @Nullable final Product product = productDAO.getProductById(id);
        if (product != null) this.product = product;
    }

    @NotNull
    public String save() {
        productDAO.merge(product);
        return "product-list";
    }

    @NotNull
    public Product getProduct() {
        return product;
    }

    public void setProduct(@NotNull final Product product) {
        this.product = product;
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

}
