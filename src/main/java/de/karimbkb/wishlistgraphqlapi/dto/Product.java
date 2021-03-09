package de.karimbkb.wishlistgraphqlapi.dto;

import io.micronaut.core.annotation.Introspected;
import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Introspected
public class Product {
  @NotNull @NotEmpty private String id;
  @NotNull @NotEmpty private String name;
  @NotNull @NotEmpty private String sku;
  @NotNull @NotEmpty private BigDecimal price;
}
