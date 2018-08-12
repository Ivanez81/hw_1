package ru.geekbrains.enterprise.api;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

public interface WBS {

    @Nullable
    String getId();

    void setId(@Nullable String id);

    @Nullable
    String getName();

    void setName(@Nullable String name);

    @Nullable
    String getDescription();

    void setDescription(@Nullable String description);

    Date getDateBegin();

    void setDateBegin(@Nullable Date dateBegin);

    Date getDateEnd();

    void setDateEnd(@Nullable Date dateEnd);

}
