package ru.geekbrains.enterprise.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.dao.CategoryDAO;
import ru.geekbrains.enterprise.dao.ProductDAO;
import ru.geekbrains.enterprise.entity.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

@ViewScoped
@ManagedBean
public class CategoryListController {

    @Inject
    private CategoryDAO categoryDAO;

    private String selectedCategory;

    @NotNull
    public Collection<Category> getListCategory() {
        return categoryDAO.getCategories();
    }

    public void removeCategoryById(@Nullable final String categoryId) {
        categoryDAO.removeCategoryById(categoryId);
    }

    @NotNull
    public List<String> getCategoriesName() {
        return categoryDAO.getCategoriesName();
    }

    @Nullable
    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }
}
