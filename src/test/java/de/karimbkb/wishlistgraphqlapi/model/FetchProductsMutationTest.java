package de.karimbkb.wishlistgraphqlapi.model;

import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class FetchProductsMutationTest {
//
//  @Inject FetchProducts fetchProducts;
//  @Inject WishlistCollectionDecorator wishlistCollectionDecorator;
//  @Inject FetchProductsMutation fetchProductsMutation;
//
//  @Test
//  void get() {
//    LinkedHashMap<String, String> data = new LinkedHashMap<>();
//    data.put("customerId", "fcd1b7a1-f061-492b-ae75-f41edeac7be2");
//    data.put("locale", "pl-PL");
//
//    Map<String, Object> map = new HashMap<>();
//    map.put("input", data);
//
//    DataFetchingEnvironment dataFetchingEnvironment =
//        DataFetchingEnvironmentImpl.newDataFetchingEnvironment().arguments(map).build();
//
//    WishlistCollection wishlistCollection = WishlistCollection.builder().count(5).build();
//
//    when(fetchProducts.execute(
//            data.get("customerId"),
//            Locale.forLanguageTag(data.get("locale"))))
//            .thenReturn(wishlistCollection);
//
//    when(wishlistCollectionDecorator.enrichWithProductData(wishlistCollection, Locale.forLanguageTag(data.get("locale"))))
//        .thenReturn(wishlistCollection);
//
//    assertNotNull(fetchProductsMutation.get(dataFetchingEnvironment));
//  }
//
//  @MockBean(WishlistCollectionDecorator.class)
//  WishlistCollectionDecorator wishlistCollectionDecorator() {
//    return mock(WishlistCollectionDecorator.class);
//  }
//
//  @MockBean(FetchProducts.class)
//  FetchProducts fetchProducts() {
//    return mock(FetchProducts.class);
//  }
//
//  @MockBean(BlockingSphereClient.class)
//  BlockingSphereClient blockingSphereClient() {
//    return mock(BlockingSphereClient.class);
//  }
}
