package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import interfaces.Repository;
import interfaces.ServiceRelation;
import models.Product;

public class ProductService implements ServiceRelation {
  Repository<Integer, Product> repository;

  public ProductService(Repository<Integer, Product> repository) {
    this.repository = repository;
  }

  public Product get(Integer id) {
    return repository.get(id);
  }

  public Collection<Product> getAll() {
    return this.repository.all();
  }

  public Collection<Product> search(String name) {
    Collection<Product> result = new ArrayList<>();
    Iterator<Product> productsIterator = this.repository.all().iterator();
    Product productAux = null;

    while (productsIterator.hasNext()) {
      productAux = productsIterator.next();
      if (productAux.getName().matches(name))
        result.add(productAux);
    }

    return result;
  }

  public void remove(Integer id) {
    this.repository.remove(id);
  }

  @Override
  public void remove(Object object) {
    if (object == null)
      throw new IllegalArgumentException("Argument object not can a null value");

    if (object.getClass() != Product.class)
      throw new IllegalArgumentException("Argument has been of type models.Product");

    this.repository.remove(((Product) object).getId());
  }

  public void create(String name, String manufacturing, float price) {
    this.repository.add(new Product(name, manufacturing, price));
  }
}
