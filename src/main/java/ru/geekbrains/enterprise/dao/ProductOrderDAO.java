package ru.geekbrains.enterprise.dao;

import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.entity.ProductOrder;
import ru.geekbrains.enterprise.interceptor.LogInterceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors({LogInterceptor.class})
public class ProductOrderDAO extends AbstractDAO {

    @Nullable
    public ProductOrder mergeProductOrder(@Nullable final ProductOrder productOrder) {
        if (productOrder == null) return null;
        return em.merge(productOrder);
    }

    public void removeProductById(@Nullable final String productId) {
        @Nullable final ProductOrder productOrder = getProductById(productId);
        if (productOrder == null) return;
        em.remove(productOrder);
    }

    @Nullable
    public ProductOrder getProductById(@Nullable final String productId) {
        if (productId == null || productId.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT p FROM ProductOrder p WHERE p.product.id = :productId", ProductOrder.class)
                .setParameter("productId", productId)
                .setMaxResults(1));
    }
}
