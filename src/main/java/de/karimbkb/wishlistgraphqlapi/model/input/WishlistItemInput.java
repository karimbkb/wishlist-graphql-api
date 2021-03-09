package de.karimbkb.wishlistgraphqlapi.model.input;

import io.micronaut.context.annotation.Prototype;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Prototype
@AllArgsConstructor
@NoArgsConstructor
public class WishlistItemInput {
  private String customerId;
  private String sku;
  private String locale;
}
