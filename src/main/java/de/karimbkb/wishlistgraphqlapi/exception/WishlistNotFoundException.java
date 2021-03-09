package de.karimbkb.wishlistgraphqlapi.exception;

import de.karimbkb.wishlistgraphqlapi.dto.Customer;
import javax.validation.Valid;

public class WishlistNotFoundException extends RuntimeException {
  public WishlistNotFoundException(String message) {
    super(message);
  }

  public static WishlistNotFoundException withCustomer(@Valid Customer customer) {
    return new WishlistNotFoundException(
        String.format("Wishlist for customer with id %s could not be found.", customer.getId()));
  }
}
