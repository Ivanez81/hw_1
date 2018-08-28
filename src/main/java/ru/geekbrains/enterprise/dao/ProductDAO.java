package ru.geekbrains.enterprise.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.entity.Product;
import ru.geekbrains.enterprise.interceptor.LogInterceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.Collections;
import java.util.List;

@Stateless
@Interceptors({LogInterceptor.class})
public class ProductDAO extends AbstractDAO {

    public Product findOne(String id) {
        return em.find(Product.class, id);
    }

    @Nullable
    public Product getProductByName(@Nullable final String name) {
        return getEntity(em.createQuery("SELECT p FROM Product p WHERE p.name = :name", Product.class)
                .setParameter("name", name)
                .setMaxResults(1));
    }

    @NotNull
    public List<Product> getListProduct() {
        return em.createQuery("SELECT p FROM Product p ORDER BY p.name ASC ", Product.class).getResultList();
    }

    @Nullable
    public List<String> getListProductName() {
        return em.createQuery("SELECT p.name FROM Product p ORDER BY p.name ASC", String.class).getResultList();
    }

    @Nullable
    public String getCategoryById(String productId) {
        if (productId == null || productId.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT p.category.name FROM Product p WHERE p.id = :productId", String.class)
                .setParameter("productId", productId)
                .setMaxResults(1));
    }

    @NotNull
    public List<Product> getProductsByCategoryId(final String categoryId) {
        if (categoryId == null || categoryId.isEmpty()) return Collections.emptyList();
        return em.createQuery("SELECT p FROM Product p WHERE p.category.id = :categoryId ORDER BY p.name",
                Product.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    @Nullable
    public List<Product> getProductsByOrderId(final String orderId) {
        if (orderId == null || orderId.isEmpty()) return Collections.emptyList();
        return em.createQuery(
                "SELECT p.product FROM ProductOrder p WHERE p.order.id = :orderId ORDER BY p.product.name",
                Product.class)
                .setParameter("orderId", orderId)
                .getResultList();
    }

    @NotNull
    public List<Product> getProducts() {
        return em.createQuery("SELECT e FROM Product e INNER JOIN e.category c ORDER BY e.created DESC",
                Product.class).getResultList();
    }

    @Nullable
    public Product getProductById(@Nullable final String productId) {
        if (productId == null || productId.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT e FROM Product e WHERE e.id = :id", Product.class)
                .setParameter("id", productId)
                .setMaxResults(1));
    }

    @Nullable
    public Product persist(@Nullable final Product product) {
        if (product == null) return null;
        em.persist(product);
        return product;
    }

    @Nullable
    public Product merge(@Nullable final Product product) {
        if (product == null) return null;
        return em.merge(product);
    }

    public void removeProductById(@Nullable final String productId) {
        @Nullable final Product product = getProductById(productId);
        if (product == null) return;
        em.remove(product);
    }

}
