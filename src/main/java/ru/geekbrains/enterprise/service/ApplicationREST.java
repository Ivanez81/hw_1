package ru.geekbrains.enterprise.service;

import ru.geekbrains.enterprise.service.crud.CategoryService;
import ru.geekbrains.enterprise.service.crud.ProductService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationPath("/api")
public class ApplicationREST extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Stream.of(
                ProductService.class,
                CategoryService.class
        ).collect(Collectors.toSet());
    }

}