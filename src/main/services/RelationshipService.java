package services;

import models.Product;

public class RelationshipService {
  AllotmentService allotmentService;
  ProductService productService;

  public RelationshipService(AllotmentService allotmentService, ProductService productService) {
    this.allotmentService = allotmentService;
    this.productService = productService;
  }

  public void removeProductDependents(Integer id) {
    Product product = productService.get(id);
    allotmentService.remove(product);
    productService.remove(product);
  }
}
