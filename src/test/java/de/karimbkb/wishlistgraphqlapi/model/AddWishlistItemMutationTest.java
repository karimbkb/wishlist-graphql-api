package de.karimbkb.wishlistgraphqlapi.model;

import de.karimbkb.wishlistgraphqlapi.Mocks;
import de.karimbkb.wishlistgraphqlapi.dto.Product;
import de.karimbkb.wishlistgraphqlapi.dto.Wishlist;
import de.karimbkb.wishlistgraphqlapi.dto.WishlistCollection;
import de.karimbkb.wishlistgraphqlapi.exception.ProductAlreadyOnWishlistException;
import de.karimbkb.wishlistgraphqlapi.exception.ProductNotFoundException;
import de.karimbkb.wishlistgraphqlapi.model.mutation.AddWishlistItemMutation;
import de.karimbkb.wishlistgraphqlapi.repository.WishlistRepository;
import de.karimbkb.wishlistgraphqlapi.service.AddProductToWishlist;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingEnvironmentImpl;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.support.TestPropertyProvider;
import org.junit.ClassRule;
import org.junit.jupiter.api.*;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Testcontainers
@MicronautTest(transactional = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddWishlistItemMutationTest extends Mocks implements TestPropertyProvider {

  @Inject AddProductToWishlist addProductToWishlist;
  @Inject WishlistRepository wishlistRepository;
  @Inject AddWishlistItemMutation addWishlistItemMutation;

  @ClassRule
  public static GenericContainer<?> mongoDBContainer =
      new GenericContainer<>("mongo:latest")
          .withReuse(true)
          .withCopyFileToContainer(
              MountableFile.forClasspathResource("init-mongo.js"),
              "/docker-entrypoint-initdb.d/init-mongo.js")
          .withCopyFileToContainer(
              MountableFile.forClasspathResource("clean-collections.js"), "/clean-collections.js");

  static {
    mongoDBContainer.start();
  }

  @AfterEach
  void cleanDatabase() throws IOException, InterruptedException {
    mongoDBContainer.execInContainer("/bin/sh", "-c", "mongo wishlists < clean-collections.js");
  }

  @AfterAll
  void tearDown() {
    mongoDBContainer.close();
  }

  @Nonnull
  @Override
  public Map<String, String> getProperties() {
    return CollectionUtils.mapOf(
        "mongodb.uri",
        "mongodb://localhost:" + mongoDBContainer.getMappedPort(27017) + "/wishlists");
  }

  @Test
  void addWishlistItemMuationWithWishlistNull() throws Exception {
    LinkedHashMap<String, String> data = getRequestData();

    Map<String, Object> map = new HashMap<>();
    map.put("input", data);

    DataFetchingEnvironment dataFetchingEnvironment =
        DataFetchingEnvironmentImpl.newDataFetchingEnvironment().arguments(map).build();

    WishlistCollection wishlistCollection = addWishlistItemMutation.get(dataFetchingEnvironment);

    assertNotEquals(wishlistCollection.getWishlistId(), "");
    assertEquals(wishlistCollection.getCustomerId(), data.get("customerId"));
    assertEquals(wishlistCollection.getLocale(), data.get("locale"));
    assertNotEquals(wishlistCollection.getCreatedAt(), "");
    assertEquals(wishlistCollection.getItems().size(), 1);
    assertEquals(wishlistCollection.getItems().get(0).getSku(), data.get("sku"));
  }

  @Test
  void addWishlistItemMuation() throws Exception {
    LinkedHashMap<String, String> data = getRequestData();

    Map<String, Object> map = new HashMap<>();
    map.put("input", data);

    DataFetchingEnvironment dataFetchingEnvironment =
        DataFetchingEnvironmentImpl.newDataFetchingEnvironment().arguments(map).build();

    Wishlist wishlist =
        new Wishlist(
            UUID.randomUUID().toString(),
            data.get("customerId"),
            data.get("locale"),
            true,
            LocalDateTime.now().toString(),
            LocalDateTime.now().toString(),
            List.of());
    wishlistRepository.saveWishlist(wishlist);

    WishlistCollection wishlistCollection = addWishlistItemMutation.get(dataFetchingEnvironment);

    assertNotEquals(wishlistCollection.getWishlistId(), "");
    assertEquals(wishlistCollection.getCustomerId(), data.get("customerId"));
    assertEquals(wishlistCollection.getLocale(), data.get("locale"));
    assertNotEquals(wishlistCollection.getCreatedAt(), "");
    assertEquals(wishlistCollection.getItems().size(), 1);
    assertEquals(wishlistCollection.getItems().get(0).getSku(), data.get("sku"));
  }

  @Test
  void addWishlistItemMuationWithProductNotFoundException() throws Exception {
    LinkedHashMap<String, String> data = getRequestData();

    Map<String, Object> map = new HashMap<>();
    map.put("input", data);

    data.put("sku", "abc");

    DataFetchingEnvironment dataFetchingEnvironment =
        DataFetchingEnvironmentImpl.newDataFetchingEnvironment().arguments(map).build();

    Assertions.assertThrows(
        ProductNotFoundException.class,
        () -> {
          addWishlistItemMutation.get(dataFetchingEnvironment);
        });
  }

  private LinkedHashMap<String, String> getRequestData() {
    LinkedHashMap<String, String> data = new LinkedHashMap<>();
    data.put("customerId", "8e5ef1ec-d115-49af-b431-85da02ff3ee6");
    data.put("sku", "product-1");
    data.put("locale", "pl-PL");
    return data;
  }

  @Test
  void AddWishlistItemMuationWithProductAlreadyOnWishlistException() throws Exception {
    LinkedHashMap<String, String> data = getRequestData();

    Map<String, Object> map = new HashMap<>();
    map.put("input", data);

    DataFetchingEnvironment dataFetchingEnvironment =
        DataFetchingEnvironmentImpl.newDataFetchingEnvironment().arguments(map).build();

    Product product = loadProductMock();
    addProductToWishlist.execute(product, data.get("customerId"), Locale.forLanguageTag("pl-PL"));

    Product product2 = loadProduct2Mock();
    addProductToWishlist.execute(product2, data.get("customerId"), Locale.forLanguageTag("pl-PL"));

    Assertions.assertThrows(
        ProductAlreadyOnWishlistException.class,
        () -> {
          addWishlistItemMutation.get(dataFetchingEnvironment);
        });
  }
}
