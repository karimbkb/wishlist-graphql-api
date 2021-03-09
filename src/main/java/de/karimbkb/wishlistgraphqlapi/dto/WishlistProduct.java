package de.karimbkb.wishlistgraphqlapi.dto;

import io.micronaut.core.annotation.Introspected;
import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Introspected
public class WishlistProduct {
  @NotNull @NotEmpty private String id;
  @NotNull @NotEmpty private String sku;
  @NotNull @NotEmpty private String wishlistId;
  @NotNull @NotEmpty private String createdAt;
  @NotNull @NotEmpty private String updatedAt;
  @NotNull @NotEmpty private BigDecimal price;
}
