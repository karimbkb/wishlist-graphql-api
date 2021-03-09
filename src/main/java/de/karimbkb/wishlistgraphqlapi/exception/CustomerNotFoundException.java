package de.karimbkb.wishlistgraphqlapi.exception;

public class CustomerNotFoundException extends RuntimeException {
  public CustomerNotFoundException(String message) {
    super(message);
  }

  public static CustomerNotFoundException withCustomer(String customerId) {
    return new CustomerNotFoundException(
        String.format("Customer with id %s could not be found.", customerId));
  }
}
