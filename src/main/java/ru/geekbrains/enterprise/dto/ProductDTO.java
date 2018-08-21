package ru.geekbrains.enterprise.dto;

import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.entity.Category;
import ru.geekbrains.enterprise.entity.Product;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class ProductDTO {

    @Nullable
    private String id;

    @Nullable
    private Date created;

    @Nullable
    private Date updated;

    @Nullable
    private String category_id;

    @Nullable
    private String name;

    @Nullable
    private String description;

    public ProductDTO() {
    }

    public ProductDTO(@Nullable Product product) {
        if (product == null) return;
        this.id = product.getId();
        this.created = product.getCreated();
        this.updated = product.getUpdated();
        this.name = product.getName();
        this.description = product.getDescription();

        @Nullable Category category = product.getCategory();
        if (category != null) this.category_id = category.getId();
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

    @Nullable
    public Date getCreated() {
        return created;
    }

    public void setCreated(@Nullable final Date created) {
        this.created = created;
    }

    @Nullable
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(@Nullable final Date updated) {
        this.updated = updated;
    }

    @Nullable
    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(@Nullable final String category_id) {
        this.category_id = category_id;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable final String name) {
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
