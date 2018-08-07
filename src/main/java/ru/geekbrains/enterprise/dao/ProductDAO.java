package ru.geekbrains.enterprise.dao;

import ru.geekbrains.enterprise.entity.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
public class ProductDAO {

    private Map<String, Product> products = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        merge(new Product("Demo Product 1", "Тестовый продукт 1"));
        merge(new Product("Demo Product 2", "Тестовый продукт 2"));
        merge(new Product("Demo Product 3", "Тестовый продукт 3"));
        merge(new Product("Demo Product 4", "Тестовый продукт 4"));
    }

    public Collection<Product> getProducts() {
        return products.values();
    }

    public Product getProductById(String productId) {
        if (productId == null || productId.isEmpty()) return null;
        return products.get(productId);
    }

    public Product merge(Product product) {
        if (product == null) return null;
        final String id = product.getId();
        if (id == null || id.isEmpty()) return null;
        products.put(id, product);
        return product;
    }

    public void removeProductById(String productId) {
        if (productId == null || productId.isEmpty()) return;
        if (!products.containsKey(productId)) return;
        products.remove(productId);
    }

}
