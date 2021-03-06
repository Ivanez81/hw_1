package ru.geekbrains.enterprise.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;

@Entity
public class Product extends AbstractEntity {

    @ManyToOne
    @JoinColumn(nullable = true, name = "category_id")
    private Category category;

    @NotNull
    private String name = "";

    @Nullable
    private String description = "";

    public Product() {
    }

    public Product(@NotNull final String name) {
        this.name = name;
    }

    public Product(@NotNull final String name, @Nullable String description) {
        this.name = name;
        this.description = description;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull final String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable final String description) {
        this.description = description;
    }

    @Nullable
    public Category getCategory() {
        return category;
    }

    public void setCategory(@Nullable Category category) {
        this.category = category;
    }
}
