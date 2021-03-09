package de.karimbkb.wishlistgraphqlapi.model;

import de.karimbkb.wishlistgraphqlapi.dto.Product;
import de.karimbkb.wishlistgraphqlapi.exception.ProductNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Singleton;

@Singleton
public class ProductApi {
  List<Product> products = new ArrayList<>();

  public ProductApi() {
    this.products.addAll(
        Arrays.asList(
            new Product(
                "f7665cf1-529b-4e64-b7fb-a613d4ccabb3",
                "Product 1",
                "product-1",
                new BigDecimal("14.99")),
            new Product(
                "f6a6b0b9-2026-49de-9b96-92296e4df87d",
                "Product 2",
                "product-2",
                new BigDecimal("12.99")),
            new Product(
                "3cc4bd46-22da-4583-b9e1-9dd4d217c322",
                "Product 3",
                "product-3",
                new BigDecimal("24.99"))));
  }

  public Product loadProduct(String sku) {
    return products.stream()
        .filter(p -> p.getSku().equals(sku))
        .findFirst()
        .orElseThrow(() -> ProductNotFoundException.withProduct(sku));
  }
}
