package de.karimbkb.wishlistgraphqlapi.dto;

import io.micronaut.core.annotation.Introspected;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Introspected
public class Customer {
  @NotNull @NotEmpty private String id;
  @NotNull @NotEmpty private String name;
  @NotNull @NotEmpty private String email;
}
