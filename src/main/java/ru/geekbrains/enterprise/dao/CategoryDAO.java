package ru.geekbrains.enterprise.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.entity.Category;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
public class CategoryDAO {

    @NotNull
    private Map<String, Category> categorys = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        merge(new Category("Category 1", "Demo Category 1"));
        merge(new Category("Category 2", "Demo Category 2"));
        merge(new Category("Category 3", "Demo Category 3"));
        merge(new Category("Category 4", "Demo Category 4"));
    }

    @NotNull
    public Collection<Category> getCategorys() {
        return categorys.values();
    }

    @Nullable
    public Category getCategoryById(@Nullable final String categoryId) {
        if (categoryId == null || categoryId.isEmpty()) return null;
        return categorys.get(categoryId);
    }

    @Nullable
    public Category merge(@Nullable final Category category) {
        if (category == null) return null;
        @Nullable final String id = category.getId();
        if (id == null || id.isEmpty()) return null;
        this.categorys.put(id, category);
        return category;
    }

    public void removeCategoryById(@Nullable final String categoryId) {
        if (categoryId == null || categoryId.isEmpty()) return;
        if (!categorys.containsKey(categoryId)) return;
        categorys.remove(categoryId);
    }

}
