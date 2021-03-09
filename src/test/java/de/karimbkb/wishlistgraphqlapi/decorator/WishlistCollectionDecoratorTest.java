package de.karimbkb.wishlistgraphqlapi.decorator;

import de.karimbkb.wishlistgraphqlapi.Mocks;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class WishlistCollectionDecoratorTest extends Mocks {
//
//  @Inject WishlistUtil wishlistUtil;
//  @Inject PriceUtil priceUtil;
//  @Inject WishlistCollectionDecorator wishlistCollectionDecorator;
//
//  @Test
//  void enrichWithProductData() {
//    Product product = loadProductMock();
//    HashMap<String, Product> productHashMap = new HashMap<>();
//    productHashMap.put(product.getId(), product);
//
//    when(wishlistUtil.loadProducts(List.of(product.getId()))).thenReturn(productHashMap);
//
//    when(priceUtil.getPrice(product.getMasterData().getCurrent().getMasterVariant(), Locale.forLanguageTag("pl-PL")))
//        .thenReturn("PLN 103,00");
//    when(priceUtil.getSpecialPrice(product.getMasterData().getCurrent().getMasterVariant(), Locale.forLanguageTag("pl-PL")))
//        .thenReturn("PLN 103,00");
//
//    when(wishlistUtil.isSaleable(product.getMasterData().getCurrent().getMasterVariant().getSku(), 1, Locale.forLanguageTag("pl-PL")))
//        .thenReturn(true);
//    when(wishlistUtil.isProductInStock(product.getMasterData().getCurrent().getMasterVariant().getSku()))
//        .thenReturn(true);
//
//    WishlistItem wishlistItem =
//        WishlistItem.builder()
//            .id(product.getId())
//            .variantId(1)
//            .sku("abc")
//            .build();
//
//    List<WishlistItem> wishlistItemList = new ArrayList<>();
//    wishlistItemList.add(wishlistItem);
//    WishlistCollection wishlistCollection = WishlistCollection.builder()
//        .items(wishlistItemList).count(1).build();
//
//    Assertions.assertNotNull(wishlistCollectionDecorator.enrichWithProductData(wishlistCollection, Locale
//        .forLanguageTag("pl-PL")));
//  }
//
//  @Test
//  void enrichWithProductDataWithDifferentProductId() {
//    Product product = loadProductMock();
//    HashMap<String, Product> productHashMap = new HashMap<>();
//    productHashMap.put("123", product);
//
//    when(wishlistUtil.loadProducts(List.of(product.getId()))).thenReturn(productHashMap);
//
//    when(priceUtil.getPrice(product.getMasterData().getCurrent().getMasterVariant(), Locale.forLanguageTag("pl-PL")))
//        .thenReturn("PLN 103,00");
//    when(priceUtil.getSpecialPrice(product.getMasterData().getCurrent().getMasterVariant(), Locale.forLanguageTag("pl-PL")))
//        .thenReturn("PLN 103,00");;
//
//
//    WishlistItem wishlistItem =
//        WishlistItem.builder()
//            .id(product.getId())
//            .variantId(1)
//            .sku("abc")
//            .build();
//
//    List<WishlistItem> wishlistItemList = new ArrayList<>();
//    wishlistItemList.add(wishlistItem);
//    WishlistCollection wishlistCollection = WishlistCollection.builder()
//        .items(wishlistItemList).count(1).build();
//
//    Assertions.assertNotNull(wishlistCollectionDecorator.enrichWithProductData(wishlistCollection, Locale
//        .forLanguageTag("pl-PL")));
//  }
//
//  @MockBean(WishlistUtil.class)
//  WishlistUtil wishlistUtil() {
//    return mock(WishlistUtil.class);
//  }
//
//  @MockBean(PriceUtil.class)
//  PriceUtil proceUtil() {
//    return mock(PriceUtil.class);
//  }
//
//  @MockBean(BlockingSphereClient.class)
//  BlockingSphereClient blockingSphereClient() {
//    return mock(BlockingSphereClient.class);
//  }
}
