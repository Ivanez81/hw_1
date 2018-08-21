package ru.geekbrains.enterprise.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Order extends AbstractEntity {

    @NotNull
    private String name = "";

    @Nullable
    private String description = "";

    public Order() {
    }

    public Order(@NotNull final String name) {
        this.name = name;
    }

    public Order(@NotNull final String name, @Nullable String description) {
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

}
