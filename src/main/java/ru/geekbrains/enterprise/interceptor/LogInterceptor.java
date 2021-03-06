package ru.geekbrains.enterprise.interceptor;

import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@ApplicationScoped
public class LogInterceptor {

    private static final Logger LOGGER = Logger.getLogger(LogInterceptor.class.getSimpleName());

    @AroundInvoke
    public Object addLog(InvocationContext context) throws Exception {
        LOGGER.info(context.getMethod().getName());
        return context.proceed();
    }

}
