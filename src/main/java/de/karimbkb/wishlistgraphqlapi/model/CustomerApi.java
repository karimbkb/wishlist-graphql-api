package de.karimbkb.wishlistgraphqlapi.model;

import de.karimbkb.wishlistgraphqlapi.dto.Customer;
import de.karimbkb.wishlistgraphqlapi.exception.CustomerNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Singleton;

@Singleton
public class CustomerApi {
  List<Customer> customers = new ArrayList<>();

  public CustomerApi() {
    this.customers.addAll(
        Arrays.asList(
            new Customer("8e5ef1ec-d115-49af-b431-85da02ff3ee6", "John Doe", "john.doe@gmail.com"),
            new Customer(
                "a6326918-0676-41f6-877c-7154c9c91eb6", "James Ryan", "james.ryan@gmail.com")));
  }

  public Customer loadCustomer(String customerId) {
    return customers.stream()
        .filter(p -> p.getId().equals(customerId))
        .findFirst()
        .orElseThrow(() -> CustomerNotFoundException.withCustomer(customerId));
  }
}
