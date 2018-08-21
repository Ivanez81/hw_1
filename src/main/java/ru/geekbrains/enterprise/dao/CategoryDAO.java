package ru.geekbrains.enterprise.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.entity.Category;
import ru.geekbrains.enterprise.interceptor.LogInterceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless
@Interceptors({LogInterceptor.class})
public class CategoryDAO extends AbstractDAO{

    public Category findOne(String id) {
        return em.find(Category.class, id);
    }

    @NotNull
    public List<Category> getCategories() {
        return em.createQuery("SELECT e FROM Category e ORDER BY e.name ASC", Category.class).getResultList();
    }

    public List<String> getCategoriesName() {
        return em.createQuery("SELECT e.name FROM Category e ORDER BY e.name ASC", String.class).getResultList();
    }

    @Nullable
    public Category getCategoryById(@Nullable final String categoryId) {
        if (categoryId == null || categoryId.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT e FROM Category e WHERE e.id = :categoryId", Category.class)
                .setParameter("categoryId", categoryId)
                .setMaxResults(1));
    }

    @Nullable
    public Category getCategoryIdByName(@Nullable final String categoryName) {
        if (categoryName == null || categoryName.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT e FROM Category e WHERE e.name = :name", Category.class)
                .setParameter("name", categoryName)
                .setMaxResults(1));
    }

    @Nullable
    public Category persist(@Nullable final Category category) {
        if (category == null) return null;
        em.persist(category);
        return category;
    }

    @Nullable
    public Category merge(@Nullable final Category category) {
        if (category == null) return null;
        return em.merge(category);
    }

    public void removeCategoryById(@Nullable final String categoryId) {
        @Nullable final Category category = getCategoryById(categoryId);
        if (category == null) return;
        em.remove(category);
    }

}
