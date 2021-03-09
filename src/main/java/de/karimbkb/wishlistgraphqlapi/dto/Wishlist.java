package de.karimbkb.wishlistgraphqlapi.dto;

import io.micronaut.core.annotation.Introspected;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Introspected
public class Wishlist {
  @NotNull @NotEmpty private String id;
  @NotNull @NotEmpty private String customerId;
  @NotNull @NotEmpty private String locale;
  @NotNull @NotEmpty private boolean isActive;
  @NotNull @NotEmpty private String createdAt;
  @NotNull @NotEmpty private String updatedAt;
  private List<WishlistProduct> products;
}
