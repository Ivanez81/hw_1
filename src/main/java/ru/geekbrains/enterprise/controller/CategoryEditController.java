package ru.geekbrains.enterprise.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.dao.CategoryDAO;
import ru.geekbrains.enterprise.entity.Category;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class CategoryEditController {

    @Inject
    private CategoryDAO categoryDAO;

    @Nullable
    private String id;

    @NotNull
    private Category category = new Category();

    public void init() {
        @Nullable final Category category = categoryDAO.getCategoryById(id);
        if (category != null) this.category = category;
    }

    @NotNull
    public String save() {
        categoryDAO.merge(category);
        return "category-list";
    }

    @NotNull
    public Category getCategory() {
        return category;
    }

    public void setCategory(@NotNull final Category category) {
        this.category = category;
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

}
