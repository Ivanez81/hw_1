package ru.geekbrains.enterprise.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

public interface WBS {

    @NotNull
    String getId();

    void setId(@NotNull String id);

    @NotNull
    String getName();

    void setName(@NotNull String name);

    @Nullable
    String getDescription();

    void setDescription(@Nullable String description);

}
