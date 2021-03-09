package de.karimbkb.wishlistgraphqlapi.service;

import de.karimbkb.wishlistgraphqlapi.dto.Customer;
import de.karimbkb.wishlistgraphqlapi.dto.Product;
import de.karimbkb.wishlistgraphqlapi.dto.WishlistProduct;
import de.karimbkb.wishlistgraphqlapi.exception.CustomerNotFoundException;
import de.karimbkb.wishlistgraphqlapi.exception.WishlistNotFoundException;
import de.karimbkb.wishlistgraphqlapi.exception.WishlistProductNotFoundException;
import de.karimbkb.wishlistgraphqlapi.model.CustomerApi;
import de.karimbkb.wishlistgraphqlapi.repository.WishlistProductRepository;
import de.karimbkb.wishlistgraphqlapi.repository.WishlistRepository;
import io.micronaut.context.annotation.Prototype;
import io.micronaut.retry.annotation.Retryable;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Prototype
public class RemoveProductFromWishlist {
  private final CustomerApi customerApi;
  private final WishlistRepository wishlistRepository;
  private final WishlistProductRepository wishlistProductRepository;

  @Inject
  public RemoveProductFromWishlist(
      CustomerApi customerApi,
      WishlistRepository wishlistRepository,
      WishlistProductRepository wishlistProductRepository) {
    this.customerApi = customerApi;
    this.wishlistRepository = wishlistRepository;
    this.wishlistProductRepository = wishlistProductRepository;
  }

  @Retryable(
      excludes = {
        WishlistNotFoundException.class,
        NullPointerException.class,
        WishlistProductNotFoundException.class,
        CustomerNotFoundException.class
      })
  public void execute(
      @Valid final Product product,
      @NotNull final String customerId,
      @NotNull final Locale locale) {
    final Customer customer = customerApi.loadCustomer(customerId);

    Optional.ofNullable(wishlistRepository.loadWishlist(customer, locale.toLanguageTag()))
        .ifPresentOrElse(
            wishlist -> {
              WishlistProduct wishlistProductToRemove = null;
              for (WishlistProduct productOnWishlist : wishlist.getProducts()) {
                if (productOnWishlist.getId().equals(product.getId())) {
                  wishlistProductToRemove = productOnWishlist;
                  break;
                }
              }

              if (Objects.isNull(wishlistProductToRemove)) {
                throw WishlistProductNotFoundException.withProduct(product);
              }

              wishlistProductRepository.removeProduct(wishlistProductToRemove);
            },
            () -> {
              throw WishlistNotFoundException.withCustomer(customer);
            });
  }
}
