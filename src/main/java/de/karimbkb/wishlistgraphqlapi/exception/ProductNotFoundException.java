package de.karimbkb.wishlistgraphqlapi.exception;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(String message) {
    super(message);
  }

  public static ProductNotFoundException withProduct(String sku) {
    return new ProductNotFoundException(String.format("Product with sku %s was not found.", sku));
  }
}
