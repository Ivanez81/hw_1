package ru.geekbrains.enterprise.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.dao.CategoryDAO;
import ru.geekbrains.enterprise.entity.Category;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Collection;

@ViewScoped
@ManagedBean
public class CategoryListController {

    @Inject
    private CategoryDAO categoryDAO;

    @NotNull
    public Collection<Category> getListCategory() {
        return categoryDAO.getCategorys();
    }

    public void removeCategoryById(@Nullable final String categoryId) {
        categoryDAO.removeCategoryById(categoryId);
    }

}
