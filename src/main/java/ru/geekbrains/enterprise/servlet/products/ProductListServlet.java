package ru.geekbrains.enterprise.servlet.products;

import ru.geekbrains.enterprise.constant.FieldConst;
import ru.geekbrains.enterprise.dao.ProductDAO;
import ru.geekbrains.enterprise.entity.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(urlPatterns = "/product-list-jsp")
public class ProductListServlet extends HttpServlet {

    @Inject
    ProductDAO productDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Collection<Product> products = productDAO.getProducts();
        req.setAttribute(FieldConst.PRODUCTS, products);
        req.getRequestDispatcher("WEB-INF/views/product-list.jsp").forward(req, resp);
    }
}
