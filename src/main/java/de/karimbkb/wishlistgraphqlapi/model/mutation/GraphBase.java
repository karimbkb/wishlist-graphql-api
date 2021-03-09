package de.karimbkb.wishlistgraphqlapi.model.mutation;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.karimbkb.wishlistgraphqlapi.model.input.WishlistCollectionInput;
import de.karimbkb.wishlistgraphqlapi.model.input.WishlistItemInput;
import graphql.schema.DataFetchingEnvironment;
import io.micronaut.context.annotation.Prototype;
import java.util.Locale;

@Prototype
public class GraphBase {
  public static final String ENV_INPUT = "input";

  private final ObjectMapper objectMapper;

  public GraphBase(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  protected WishlistItemInput getWishlistItemInput(DataFetchingEnvironment env) {
    Object rawInput = env.getArgument(ENV_INPUT);
    return objectMapper.convertValue(rawInput, WishlistItemInput.class);
  }

  protected WishlistCollectionInput getWishlistCollectionInput(DataFetchingEnvironment env) {
    Object rawInput = env.getArgument(ENV_INPUT);
    return objectMapper.convertValue(rawInput, WishlistCollectionInput.class);
  }

  protected Locale getLocale(final String locale) {
    return Locale.forLanguageTag(locale);
  }
}
