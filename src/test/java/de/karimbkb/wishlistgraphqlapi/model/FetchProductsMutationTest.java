package de.karimbkb.wishlistgraphqlapi.model;

import de.karimbkb.wishlistgraphqlapi.Mocks;
import de.karimbkb.wishlistgraphqlapi.dto.Product;
import de.karimbkb.wishlistgraphqlapi.model.mutation.FetchProductsMutation;
import de.karimbkb.wishlistgraphqlapi.service.AddProductToWishlist;
import de.karimbkb.wishlistgraphqlapi.service.FetchProducts;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingEnvironmentImpl;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.test.support.TestPropertyProvider;
import org.junit.ClassRule;
import org.junit.jupiter.api.*;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
@MicronautTest(transactional = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FetchProductsMutationTest extends Mocks implements TestPropertyProvider {

  @Inject FetchProducts fetchProducts;
  @Inject AddProductToWishlist addProductToWishlist;
  @Inject FetchProductsMutation fetchProductsMutation;

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

  @BeforeAll
  void populateWishlistData() throws InterruptedException {
    Product product = loadProductMock();
    addProductToWishlist.execute(
        product, "8e5ef1ec-d115-49af-b431-85da02ff3ee6", Locale.forLanguageTag("pl-PL"));
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
  void addProductMutation() throws InterruptedException {
    LinkedHashMap<String, String> data = new LinkedHashMap<>();
    data.put("customerId", "8e5ef1ec-d115-49af-b431-85da02ff3ee6");
    data.put("locale", "pl-PL");

    Map<String, Object> map = new HashMap<>();
    map.put("input", data);

    DataFetchingEnvironment dataFetchingEnvironment =
        DataFetchingEnvironmentImpl.newDataFetchingEnvironment().arguments(map).build();

    assertNotNull(fetchProductsMutation.get(dataFetchingEnvironment));
  }
}
