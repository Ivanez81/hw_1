package ru.geekbrains.enterprise.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @NotNull
    private String id = UUID.randomUUID().toString();

    @Nullable
    private Date created;

    @Nullable
    private Date updated;

    @NotNull
    public String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }

    @Nullable
    public Date getCreated() {
        return created;
    }

    public void setCreated(@Nullable Date created) {
        this.created = created;
    }

    @Nullable
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(@Nullable Date updated) {
        this.updated = updated;
    }

    @PrePersist
    private void prePersist() {
        created = new Date();
        updated = new Date();
    }

    @PreUpdate
    private void preUpdate() {
        if (created == null) created = new Date();
        updated = new Date();
    }

}
