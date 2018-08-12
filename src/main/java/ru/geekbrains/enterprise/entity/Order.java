package ru.geekbrains.enterprise.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.api.WBS;

import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

public class Order implements WBS {

    @Nullable
    private String id = UUID.randomUUID().toString();

    @NotNull
    @Size(min = 2, message = "Minimum \'name\' size = 2 symbols")
    private String name = "";

    @Nullable
    private String description = "";

    @Nullable
    @Past(message = "\'Date Begin\' s.b. in the past")
    private Date dateBegin;

    @Nullable
    @Future(message = "\'Date End\' s.b. in the future")
    private Date dateEnd;

    @Nullable
    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(@Nullable final Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    @Nullable
    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(@Nullable final Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Order() {
    }

    public Order(@NotNull final String name) {
        this.name = name;
    }

    public Order(@NotNull final String name, @Nullable String description) {
        this.name = name;
        this.description = description;
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

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }


}
