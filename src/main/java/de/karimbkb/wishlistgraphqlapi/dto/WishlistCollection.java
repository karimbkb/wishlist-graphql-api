package de.karimbkb.wishlistgraphqlapi.dto;

import io.micronaut.context.annotation.Prototype;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Prototype
@Builder
public class WishlistCollection {
  private final String wishlistId;
  private final String customerId;
  private final String locale;
  private final String createdAt;
  private final int count;
  private final List<WishlistProduct> items;
}
