package de.karimbkb.wishlistgraphqlapi.model.mutation;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.karimbkb.wishlistgraphqlapi.dto.WishlistCollection;
import de.karimbkb.wishlistgraphqlapi.model.input.WishlistCollectionInput;
import de.karimbkb.wishlistgraphqlapi.service.FetchProducts;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class FetchProductsMutation extends GraphBase implements DataFetcher<WishlistCollection> {
  private final FetchProducts fetchProducts;

  @Inject
  public FetchProductsMutation(ObjectMapper objectMapper, FetchProducts fetchProducts) {
    super(objectMapper);
    this.fetchProducts = fetchProducts;
  }

  @Override
  public WishlistCollection get(DataFetchingEnvironment env) throws InterruptedException {
    WishlistCollectionInput wishlistCollectionInput = getWishlistCollectionInput(env);

    return fetchProducts.execute(
        wishlistCollectionInput.getCustomerId(),
        Locale.forLanguageTag(wishlistCollectionInput.getLocale()));
  }
}
