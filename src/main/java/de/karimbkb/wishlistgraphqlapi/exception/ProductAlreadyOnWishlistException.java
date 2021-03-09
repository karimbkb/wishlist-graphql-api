package de.karimbkb.wishlistgraphqlapi.exception;

import de.karimbkb.wishlistgraphqlapi.dto.WishlistProduct;
import javax.validation.Valid;

public class ProductAlreadyOnWishlistException extends RuntimeException {
  public ProductAlreadyOnWishlistException(String message) {
    super(message);
  }

  public static ProductAlreadyOnWishlistException withProduct(@Valid WishlistProduct product) {
    return new ProductAlreadyOnWishlistException(
        String.format(
            "Product with id %s is already on the wishlist with id %s.",
            product.getId(), product.getWishlistId()));
  }
}
