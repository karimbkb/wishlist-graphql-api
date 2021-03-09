package de.karimbkb.wishlistgraphqlapi.dto;

import io.micronaut.context.annotation.Prototype;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Prototype
@Builder
public class WishlistCollection {
  private final List<WishlistProduct> items;
  private final int count;
}
