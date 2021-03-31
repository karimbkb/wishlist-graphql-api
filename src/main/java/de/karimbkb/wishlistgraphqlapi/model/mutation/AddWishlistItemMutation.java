package de.karimbkb.wishlistgraphqlapi.model.mutation;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.karimbkb.wishlistgraphqlapi.dto.Product;
import de.karimbkb.wishlistgraphqlapi.dto.WishlistCollection;
import de.karimbkb.wishlistgraphqlapi.model.ProductApi;
import de.karimbkb.wishlistgraphqlapi.model.input.WishlistItemInput;
import de.karimbkb.wishlistgraphqlapi.service.AddProductToWishlist;
import de.karimbkb.wishlistgraphqlapi.service.FetchProducts;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.Locale;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class AddWishlistItemMutation extends GraphBase implements DataFetcher<WishlistCollection> {

  private final AddProductToWishlist addProductToWishlist;
  private final FetchProducts fetchProducts;
  private final ProductApi productApi;

  public AddWishlistItemMutation(
      ObjectMapper objectMapper,
      AddProductToWishlist addProductToWishlist,
      FetchProducts fetchProducts,
      ProductApi productApi) {
    super(objectMapper);
    this.addProductToWishlist = addProductToWishlist;
    this.fetchProducts = fetchProducts;
    this.productApi = productApi;
  }

  @Override
  public WishlistCollection get(DataFetchingEnvironment environment) throws Exception {
    WishlistItemInput wishlistItemInput = getWishlistItemInput(environment);
    Locale locale = getLocale(wishlistItemInput.getLocale());

    Product product = productApi.loadProduct(wishlistItemInput.getSku());
    addProductToWishlist.execute(product, wishlistItemInput.getCustomerId(), locale);

    return fetchProducts.execute(wishlistItemInput.getCustomerId(), locale);
  }
}
