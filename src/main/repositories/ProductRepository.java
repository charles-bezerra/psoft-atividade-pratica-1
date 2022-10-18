package repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import interfaces.Repository;
import models.Product;

public class ProductRepository implements Repository<Integer, Product> {
  private Map<Integer, Product> products;

  public ProductRepository() {
    products = new HashMap<>();
  }

  public void add(Product product) {
    products.put(product.getId(), product);
  }

  public Product get(Integer id) {
    Product result = products.get(id);

    if (result == null)
      throw new IllegalArgumentException("Product not found in ProductRepository");

    return result;
  }

  public Collection<Product> all() {
    return products.values();
  }

  public void remove(Integer id) {
    Product p = products.remove(id);

    if (p == null)
      throw new IllegalArgumentException("Product not found in repositories.ProductRepository");
  }

}
