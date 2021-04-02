package de.karimbkb.wishlistgraphqlapi.service;

import de.karimbkb.wishlistgraphqlapi.dto.Customer;
import de.karimbkb.wishlistgraphqlapi.dto.Product;
import de.karimbkb.wishlistgraphqlapi.dto.Wishlist;
import de.karimbkb.wishlistgraphqlapi.dto.WishlistProduct;
import de.karimbkb.wishlistgraphqlapi.exception.CustomerNotFoundException;
import de.karimbkb.wishlistgraphqlapi.exception.ProductAlreadyOnWishlistException;
import de.karimbkb.wishlistgraphqlapi.model.CustomerApi;
import de.karimbkb.wishlistgraphqlapi.repository.WishlistProductRepository;
import de.karimbkb.wishlistgraphqlapi.repository.WishlistRepository;
import io.micronaut.context.annotation.Prototype;
import io.micronaut.retry.annotation.Retryable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Prototype
public class AddProductToWishlist {
  private final CustomerApi customerApi;
  private final WishlistRepository wishlistRepository;
  private final WishlistProductRepository wishlistProductRepository;

  @Inject
  public AddProductToWishlist(
      CustomerApi customerApi,
      WishlistRepository wishlistRepository,
      WishlistProductRepository wishlistProductRepository) {
    this.customerApi = customerApi;
    this.wishlistRepository = wishlistRepository;
    this.wishlistProductRepository = wishlistProductRepository;
  }

  @Retryable(
      excludes = {
        ProductAlreadyOnWishlistException.class,
        CustomerNotFoundException.class,
        NullPointerException.class
      })
  public void execute(
      @NotNull final Product product,
      @NotNull final String customerId,
      @NotNull final Locale locale) {
    final Customer customer = customerApi.loadCustomer(customerId);

    Optional.ofNullable(wishlistRepository.loadWishlist(customer, locale))
        .ifPresentOrElse(
            wishlist -> {
              if (wishlist.getProducts() != null) {
                for (WishlistProduct productOnWishlist : wishlist.getProducts()) {
                  if (productOnWishlist.getId().equals(product.getId())) {
                    throw ProductAlreadyOnWishlistException.withProduct(productOnWishlist);
                  }
                }
              }

              wishlistProductRepository.saveProduct(product, wishlist);
            },
            () -> {
              Wishlist wishlist =
                  new Wishlist(
                      UUID.randomUUID().toString(),
                      customerId,
                      locale.toLanguageTag(),
                      true,
                      LocalDateTime.now().toString(),
                      LocalDateTime.now().toString(),
                      List.of());

              wishlistRepository.saveWishlist(wishlist);
              wishlistProductRepository.saveProduct(product, wishlist);
            });
  }
}
