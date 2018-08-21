package ru.geekbrains.enterprise.manager;

import ru.geekbrains.enterprise.dao.LogDAO;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;

@Startup
@Singleton
public class StartManager {

    private static final Logger LOGGER = Logger.getLogger(StartManager.class.getSimpleName());

    @Inject
    private LogDAO logDAO;

    @PostConstruct
    public void init() {
        LOGGER.info("Application started...");
        logDAO.start();
    }

    @PreDestroy
    public void destroy() {
        LOGGER.info("Application stopped...");
        logDAO.stopped();
    }

}
