package ru.geekbrains.enterprise.controller;

import ru.geekbrains.enterprise.dao.LogDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class LogController {

    @Inject
    private LogDAO logDAO;

}
