package ru.geekbrains.enterprise.dto;

import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.entity.Category;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class CategoryDTO {

    @Nullable
    private String id;

    @Nullable
    private Date created;

    @Nullable
    private Date updated;

    @Nullable
    private String name;

    @Nullable
    private String description;

    public CategoryDTO() {
    }

    public CategoryDTO(@Nullable Category category) {
        if (category == null) return;
        this.id = category.getId();
        this.created = category.getCreated();
        this.updated = category.getUpdated();
        this.name = category.getName();
        this.description = category.getDescription();
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