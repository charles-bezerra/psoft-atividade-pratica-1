package facades;

import java.util.Collection;

import models.Allotment;
import models.Product;

import repositories.AllotmentRepository;
import repositories.ProductRepository;

import services.AllotmentService;
import services.ProductService;
import services.RelationshipService;

public class FacadeUserStore {
  private AllotmentRepository allotmentRepository;
  private ProductRepository productRepository;

  private AllotmentService allotmentService;
  private ProductService productService;
  private RelationshipService relationshipService;

  public FacadeUserStore() {
    allotmentRepository = new AllotmentRepository();
    productRepository = new ProductRepository();

    allotmentService = new AllotmentService(allotmentRepository);
    productService = new ProductService(productRepository);
    relationshipService = new RelationshipService(allotmentService, productService);
  }

  public Collection<Allotment> getAllAlloment() {
    return allotmentService.getAll();
  }

  public void createAlloment(Product produto, int quantidade, String dataValidade) {
    allotmentService.create(produto, quantidade, dataValidade);
  }

  public Collection<Allotment> searchAllomentForProduct(String name) {
    return allotmentService.searchForProductName(name);
  }

  public void removeAlloment(Product product, Integer amount, String expirationDate) {
    allotmentService.remove(product, amount, expirationDate);
  }

  public Product getProduct(Integer id) {
    return productService.get(id);
  }

  public Collection<Product> getAllProduct() {
    return productService.getAll();
  }

  public Collection<Product> searchProduct(String name) {
    return productService.search(name);
  }

  public void removeProduct(Integer id) {
    relationshipService.removeProductDependents(id);
  }

  public void createProduct(String name, String manufacturing, float price) {
    productService.create(name, manufacturing, price);
  }

}