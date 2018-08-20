package ru.geekbrains.enterprise.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.dao.CategoryDAO;
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

    @Inject
    private CategoryDAO categoryDAO;

    @Nullable
    private String id;

    @Nullable
    private String categoryName;

    @NotNull
    private Product product = new Product();

    public void init() {
        @Nullable final Product product = productDAO.getProductById(id);
        if (product != null) this.product = product;
    }

    @NotNull
    public String save() {
        if (categoryName != null) product.setCategory(categoryDAO.getCategoryIdByName(categoryName));
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

    @Nullable
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(@Nullable final String categoryName) {
        this.categoryName = categoryName;
    }
}
