package de.karimbkb.wishlistgraphqlapi.model.input;

import io.micronaut.context.annotation.Prototype;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Prototype
@AllArgsConstructor
@NoArgsConstructor
public class WishlistCollectionInput {
  private String customerId;
  private String locale;
  private int offset;
  private int limit;
}
