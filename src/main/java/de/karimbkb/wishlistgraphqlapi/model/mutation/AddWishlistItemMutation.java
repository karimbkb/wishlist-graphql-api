package de.karimbkb.wishlistgraphqlapi.model.mutation;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.karimbkb.wishlistgraphqlapi.dto.Product;
import de.karimbkb.wishlistgraphqlapi.dto.WishlistProduct;
import de.karimbkb.wishlistgraphqlapi.model.ProductApi;
import de.karimbkb.wishlistgraphqlapi.model.input.WishlistItemInput;
import de.karimbkb.wishlistgraphqlapi.service.AddProductToWishlist;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.Locale;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class AddWishlistItemMutation extends GraphBase implements DataFetcher<WishlistProduct> {

  private final AddProductToWishlist addProductToWishlist;
  private final ProductApi productApi;

  public AddWishlistItemMutation(
      ObjectMapper objectMapper, AddProductToWishlist addProductToWishlist, ProductApi productApi) {
    super(objectMapper);
    this.addProductToWishlist = addProductToWishlist;
    this.productApi = productApi;
  }

  @Override
  public WishlistProduct get(DataFetchingEnvironment environment) throws Exception {
    WishlistItemInput wishlistItemInput = getWishlistItemInput(environment);
    Locale locale = getLocale(wishlistItemInput.getLocale());

    Product product = productApi.loadProduct(wishlistItemInput.getSku());
    addProductToWishlist.execute(product, wishlistItemInput.getCustomerId(), locale);

    return new WishlistProduct(
        product.getId(), product.getSku(), null, null, null, product.getPrice());
  }
}
