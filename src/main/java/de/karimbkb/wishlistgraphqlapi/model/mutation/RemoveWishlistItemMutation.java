package de.karimbkb.wishlistgraphqlapi.model.mutation;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.karimbkb.wishlistgraphqlapi.dto.Product;
import de.karimbkb.wishlistgraphqlapi.dto.WishlistProduct;
import de.karimbkb.wishlistgraphqlapi.model.ProductApi;
import de.karimbkb.wishlistgraphqlapi.model.input.WishlistItemInput;
import de.karimbkb.wishlistgraphqlapi.service.RemoveProductFromWishlist;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class RemoveWishlistItemMutation extends GraphBase implements DataFetcher<WishlistProduct> {
  private final RemoveProductFromWishlist removeProductFromWishlist;
  private final ProductApi productApi;

  @Inject
  public RemoveWishlistItemMutation(
      ObjectMapper objectMapper,
      RemoveProductFromWishlist removeProductFromWishlist,
      ProductApi productApi) {
    super(objectMapper);
    this.removeProductFromWishlist = removeProductFromWishlist;
    this.productApi = productApi;
  }

  @Override
  public WishlistProduct get(DataFetchingEnvironment env) {
    WishlistItemInput wishlistItemInput = getWishlistItemInput(env);
    Locale locale = getLocale(wishlistItemInput.getLocale());

    Product product = productApi.loadProduct(wishlistItemInput.getSku());
    removeProductFromWishlist.execute(product, wishlistItemInput.getCustomerId(), locale);

    return new WishlistProduct(
        product.getId(), product.getSku(), null, null, null, product.getPrice());
  }
}
