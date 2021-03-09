package de.karimbkb.wishlistgraphqlapi.model;

import de.karimbkb.wishlistgraphqlapi.Mocks;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class AddWishlistItemMutationTest extends Mocks {
//
//  @Inject WishlistUtil wishlistUtil;
//  @Inject AddProductToWishlist addProductToWishlist;
//  @Inject AddWishlistItemMutation addWishlistItemMutation;
//
//  @Test
//  void get() {
//    LinkedHashMap<String, String> data = new LinkedHashMap<>();
//    data.put("customerId", "fcd1b7a1-f061-492b-ae75-f41edeac7be2");
//    data.put("sku", "80010381-15");
//    data.put("locale", "pl-PL");
//
//    Map<String, Object> map = new HashMap<>();
//    map.put("input", data);
//
//    DataFetchingEnvironment dataFetchingEnvironment =
//        DataFetchingEnvironmentImpl.newDataFetchingEnvironment().arguments(map).build();
//    Product product = loadProductMock();
//
//    when(wishlistUtil.loadProduct(anyString())).thenReturn(product);
//    when(wishlistUtil.getVariantBySku(product, "80010381-15")).thenReturn(product.getMasterData().getCurrent().getMasterVariant());
//    doNothing()
//        .when(addProductToWishlist)
//        .execute(
//            product,
//            product.getMasterData().getCurrent().getMasterVariant().getId(),
//            data.get("customerId"),
//            Locale.forLanguageTag("pl-PL"));
//
//    assertNotNull(addWishlistItemMutation.get(dataFetchingEnvironment));
//  }
//
//  @MockBean(WishlistUtil.class)
//  WishlistUtil wishlistUtil() {
//    return mock(WishlistUtil.class);
//  }
//
//  @MockBean(AddProductToWishlist.class)
//  AddProductToWishlist addProductToWishlist() {
//    return mock(AddProductToWishlist.class);
//  }
//
//  @MockBean(BlockingSphereClient.class)
//  BlockingSphereClient blockingSphereClient() {
//    return mock(BlockingSphereClient.class);
//  }
}
