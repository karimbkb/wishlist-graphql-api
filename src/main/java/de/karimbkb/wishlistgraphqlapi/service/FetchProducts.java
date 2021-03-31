package de.karimbkb.wishlistgraphqlapi.service;

import de.karimbkb.wishlistgraphqlapi.dto.Customer;
import de.karimbkb.wishlistgraphqlapi.dto.Wishlist;
import de.karimbkb.wishlistgraphqlapi.dto.WishlistCollection;
import de.karimbkb.wishlistgraphqlapi.exception.CustomerNotFoundException;
import de.karimbkb.wishlistgraphqlapi.exception.WishlistNotFoundException;
import de.karimbkb.wishlistgraphqlapi.model.CustomerApi;
import de.karimbkb.wishlistgraphqlapi.repository.WishlistRepository;
import io.micronaut.context.annotation.Prototype;
import io.micronaut.retry.annotation.Retryable;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Prototype
public class FetchProducts {
  private final WishlistRepository wishlistRepository;
  private final CustomerApi customerApi;

  @Inject
  public FetchProducts(WishlistRepository wishlistRepository, CustomerApi customerApi) {
    this.wishlistRepository = wishlistRepository;
    this.customerApi = customerApi;
  }

  @Retryable(
      excludes = {
        WishlistNotFoundException.class,
        NullPointerException.class,
        CustomerNotFoundException.class
      })
  public WishlistCollection execute(@NotNull final String customerId, @NotNull final Locale locale)
      throws InterruptedException {
    final Customer customer = customerApi.loadCustomer(customerId);
    final Wishlist wishlist = wishlistRepository.loadWishlist(customer, locale);

    return WishlistCollection.builder()
        .wishlistId(wishlist.getId())
        .customerId(wishlist.getCustomerId())
        .locale(wishlist.getLocale())
        .createdAt(wishlist.getCreatedAt())
        .items(
            wishlist == null || wishlist.getProducts() == null ? List.of() : wishlist.getProducts())
        .count(
            wishlist == null || wishlist.getProducts() == null ? 0 : wishlist.getProducts().size())
        .build();
  }
}
