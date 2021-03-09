package de.karimbkb.wishlistgraphqlapi.exception;

import de.karimbkb.wishlistgraphqlapi.dto.Product;

public class WishlistProductNotFoundException extends RuntimeException {
  public WishlistProductNotFoundException(String message) {
    super(message);
  }

  public static WishlistProductNotFoundException withProduct(Product product) {
    return new WishlistProductNotFoundException(
        String.format("Product with id %s was not found on the wishlist.", product.getId()));
  }
}
