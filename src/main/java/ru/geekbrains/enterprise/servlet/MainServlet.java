package ru.geekbrains.enterprise.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MainServlet", urlPatterns = {"/main"})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // s.b. comment for test UTF8Filter this line
        req.getRequestDispatcher("main.jsp").forward(req,resp);

        /* for UTF8Filter test s.b. uncomment
        try (PrintWriter writer = resp.getWriter()){
            writer.println("GET: HELLO WORLD! Русский язык");
        } */

    }
}
