package de.karimbkb.wishlistgraphqlapi.utils;

import de.karimbkb.wishlistgraphqlapi.Mocks;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class WishlistUtilTest extends Mocks {
//
//  @Inject BlockingSphereClient blockingSphereClient;
//
//  @Inject WishlistUtil wishlistUtil;
//
//  Customer customer;
//  Product product;
//  PagedQueryResult<Product> productCollection;
//  PagedQueryResult<Product> emptyProductCollection;
//  PagedQueryResult<Product> productCollectionWithUnpublishedProduct;
//  ShoppingList shoppingList;
//  PagedQueryResult<ShoppingList> shoppingListCollection;
//  PagedQueryResult<ShoppingList> emptyShoppingListCollection;
//  PagedQueryResult<InventoryEntry> inventoryEntry;
//  PagedQueryResult<InventoryEntry> emptyInventoryEntry;
//  PagedQueryResult<InventoryEntry> InventoryEntryWithZeroQty;
//
//  @BeforeEach
//  void setUp() {
//    customer = loadCustomerMock();
//    product = loadProductMock();
//    productCollection = loadProductCollectionMock();
//    productCollectionWithUnpublishedProduct = loadProductCollectionWithUnpublishedProductMock();
//    emptyProductCollection = loadEmptyProductCollectionMock();
//    shoppingList = loadWishlistMock();
//    shoppingListCollection = loadWishlistCollectionMock();
//    emptyShoppingListCollection = loadEmptyWishlistCollectionMock();
//    inventoryEntry = loadInventoryEntryMock();
//    emptyInventoryEntry = loadEmptyInventoryEntryMock();
//    InventoryEntryWithZeroQty = loadInventoryEntryWithZeroQtyMock();
//  }
//
//  @Test
//  void loadCustomer() {
//    when(wishlistUtil.loadCustomer("28a4faaa-acfe-459d-ae31-2bbae7f045cb")).thenReturn(customer);
//
//    assertEquals(
//        customer.getId(),
//        wishlistUtil.loadCustomer("28a4faaa-acfe-459d-ae31-2bbae7f045cb").getId());
//  }
//
//  @Test
//  void loadCustomerWithNullResponse() {
//    when(wishlistUtil.loadCustomer("abc")).thenReturn(null);
//    assertNull(wishlistUtil.loadCustomer("abc"));
//  }
//
//  @Test
//  void loadWishlist() {
//    when(blockingSphereClient.executeBlocking(
//        ShoppingListQuery.of()
//            .withPredicates(m -> m.key().is(customer.getId() + "-pl-PL"))))
//        .thenReturn(shoppingListCollection);
//
//    assertEquals(shoppingListCollection.head().get().getId(),
//        wishlistUtil.loadWishlist(customer, "pl-PL").getId());
//  }
//
//  @Test
//  void loadWishlistWithEmptyCollection() {
//    when(blockingSphereClient.executeBlocking(
//        ShoppingListQuery.of()
//            .withPredicates(m -> m.key().is(customer.getId() + "-pl-PL"))))
//        .thenReturn(emptyShoppingListCollection);
//
//    assertNull(wishlistUtil.loadWishlist(customer, "pl-PL"));
//  }
//
//  @Test
//  void createShoppingList() {
//    Locale locale = Locale.forLanguageTag("pl-PL");
//    final ShoppingListDraftDsl shoppingListDraftDsl =
//        ShoppingListDraftBuilder.of(LocalizedString.of(locale, customer.getId()))
//            .key(customer.getId() + "-" + locale.toLanguageTag())
//            .slug(LocalizedString.of(locale, customer.getId() + "-" + locale.toLanguageTag()))
//            .customer(customer.toReference())
//            .build();
//
//    when(blockingSphereClient.executeBlocking(
//            ShoppingListCreateCommand.of(shoppingListDraftDsl)))
//        .thenReturn(shoppingList);
//
//    assertEquals(
//        shoppingList.getId(),
//        wishlistUtil.createShoppingList(customer, locale).getId());
//  }
//
//  @Test
//  void loadProduct() {
//    when(blockingSphereClient.executeBlocking(
//            ProductQuery.of().bySku("80023829-C", ProductProjectionType.CURRENT)))
//        .thenReturn(productCollection);
//
//    assertEquals(
//        productCollection.head().get().getId(), wishlistUtil.loadProduct("80023829-C").getId());
//  }
//
//  @Test
//  void loadProductWithEmptyCollection() {
//    when(blockingSphereClient.executeBlocking(
//            ProductQuery.of().bySku("80023829-C", ProductProjectionType.CURRENT)))
//        .thenReturn(emptyProductCollection);
//
//    assertNull(wishlistUtil.loadProduct("80023829-C"));
//  }
//
//  @Test
//  void getVariantBySku() {
//    Assertions.assertNotNull(wishlistUtil.getVariantBySku(product, "80023829-3-1"));
//  }
//
//  @Test
//  void getVariantBySkuWithNullResponse() {
//    assertNull(wishlistUtil.getVariantBySku(product, "test"));
//  }
//
//  @Test
//  void buildWishlistId() {
//    Locale locale = Locale.forLanguageTag("pl-PL");
//
//    assertEquals(
//        customer.getId() + "-" + locale.toLanguageTag(),
//        wishlistUtil.buildWishlistId(customer, locale.toLanguageTag()));
//  }
//
//  @Test
//  void loadProducts() {
//    when(blockingSphereClient.executeBlocking(
//        ProductQuery.of().withPredicates(p -> p.id().isIn(List.of("abc")))))
//        .thenReturn(loadProductCollectionMock());
//
//    Assertions.assertEquals(1, wishlistUtil.loadProducts(List.of("abc")).size());
//  }
//
//  @Test
//  void isSaleable() {
//    assertFalse(wishlistUtil.isSaleable(null, 0, null));
//    assertFalse(wishlistUtil.isSaleable("abc", 0, null));
//    assertFalse(wishlistUtil.isSaleable("abc", 1, null));
//
//    when(blockingSphereClient.executeBlocking(
//        ProductQuery.of().bySku("80023829-3-1", ProductProjectionType.CURRENT))).thenReturn(productCollection);
//    assertTrue(wishlistUtil.isSaleable("80023829-3-1", 1, Locale.forLanguageTag("pl-PL")));
//  }
//
//  @Test
//  void isSaleableWithEmptyCollection() {
//    when(blockingSphereClient.executeBlocking(
//        ProductQuery.of().bySku("80023829-3-1", ProductProjectionType.CURRENT))).thenReturn(emptyProductCollection);
//
//    assertFalse(wishlistUtil.isSaleable("80023829-3-1", 2, Locale.forLanguageTag("pl-PL")));
//  }
//
//  @Test
//  void isSaleableWithNotPublishedProduct() {
//    when(blockingSphereClient.executeBlocking(
//        ProductQuery.of().bySku("80023829-3-1", ProductProjectionType.CURRENT)))
//        .thenReturn(productCollectionWithUnpublishedProduct);
//
//    assertFalse(wishlistUtil.isSaleable("80023829-3-1", 2, Locale.forLanguageTag("pl-PL")));
//  }
//
//  @Test
//  void isSaleableWithIsActiveAttributeFalse() {
//    when(blockingSphereClient.executeBlocking(
//        ProductQuery.of().bySku("80023829-3-1", ProductProjectionType.CURRENT)))
//        .thenReturn(emptyProductCollection);
//
//    assertFalse(wishlistUtil.isSaleable("80023829-3-1", 2, Locale.forLanguageTag("pl-PL")));
//  }
//
//  @Test
//  void isProductInStock() {
//    assertFalse(wishlistUtil.isProductInStock(null));
//    assertFalse(wishlistUtil.isProductInStock(""));
//    String sku = "abc";
//
//    when(blockingSphereClient.executeBlocking(
//            InventoryEntryQuery.of()
//                .withPredicates(QueryPredicate.of("sku=\"" + sku + "\""))))
//        .thenReturn(inventoryEntry);
//
//    assertTrue(wishlistUtil.isProductInStock(sku));
//  }
//
//  @Test
//  void isProductInStockWithInventoryEqualsZero() {
//    String sku = "abc";
//
//    when(blockingSphereClient.executeBlocking(
//        InventoryEntryQuery.of()
//            .withPredicates(QueryPredicate.of("sku=\"" + sku + "\""))))
//        .thenReturn(InventoryEntryWithZeroQty);
//
//    assertFalse(wishlistUtil.isProductInStock(sku));
//  }
//
//  @Test
//  void isProductInStockWithEmptyCollection() {
//    String sku = "abc";
//    when(blockingSphereClient.executeBlocking(
//        InventoryEntryQuery.of().withPredicates(QueryPredicate.of("sku=\"" + sku + "\""))))
//        .thenReturn(emptyInventoryEntry);
//
//    assertFalse(wishlistUtil.isProductInStock(sku));
//  }
//
//  @MockBean(BlockingSphereClient.class)
//  BlockingSphereClient blockingSphereClient() {
//    return mock(BlockingSphereClient.class);
//  }
}
