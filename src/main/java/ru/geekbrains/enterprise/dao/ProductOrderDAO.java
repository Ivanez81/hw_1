package ru.geekbrains.enterprise.dao;

import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.entity.Product;

import javax.ejb.Stateless;
import java.util.*;

@Stateless
public class ProductOrderDAO extends AbstractDAO {

    @Nullable
    public Map<String, List<Product>> getProductsByOrderId(@Nullable final String orderId) {
        Map<String, List<Product>> result = new HashMap<>();

        if (orderId == null || orderId.isEmpty()) {
            result.put(orderId, Collections.emptyList());
            return result;
        }

        result.put(orderId,
                // Понимаю что тут ошибка
                em.createQuery("SELECT p FROM Product p WHERE p.id = :orderId ORDER BY p.name", Product.class)
                        .setParameter("orderId", orderId).getResultList());

        return result;
    }

}
