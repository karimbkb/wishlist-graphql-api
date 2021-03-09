package de.karimbkb.wishlistgraphqlapi.service;

import de.karimbkb.wishlistgraphqlapi.Mocks;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class AddProductToWishlistTest extends Mocks {
//
//  @Inject BlockingSphereClient blockingSphereClient;
//  @Inject WishlistUtil wishlistUtil;
//  @Inject AddProductToWishlist addProductToWishlist;
//
//  @Test
//  void execute() {
//    Product product = loadProductMock();
//    ShoppingList shoppingList = loadWishlistMock();
//    Customer customer = loadCustomerMock();
//
//    when(wishlistUtil.loadCustomer("abc")).thenReturn(customer);
//    when(wishlistUtil.loadWishlist(customer, "pl-PL")).thenReturn(shoppingList);
//    when(blockingSphereClient.executeBlocking(
//        ShoppingListUpdateCommand.of(
//            shoppingList, AddLineItem.of(product).withVariantId(1).withQuantity(1L)))).thenReturn(null);
//
//    addProductToWishlist.execute(product, 1, "abc", Locale.forLanguageTag("pl-PL"));
//  }
//
//  @Test
//  void executeWithDifferentVariantId() {
//    Product product = loadProductMock();
//    ShoppingList shoppingList = loadWishlistMock();
//    Customer customer = loadCustomerMock();
//
//    when(wishlistUtil.loadCustomer("abc")).thenReturn(customer);
//    when(wishlistUtil.loadWishlist(customer, "pl-PL")).thenReturn(shoppingList);
//    when(blockingSphereClient.executeBlocking(
//        ShoppingListUpdateCommand.of(
//            shoppingList, AddLineItem.of(product).withVariantId(1).withQuantity(1L)))).thenReturn(null);
//
//    addProductToWishlist.execute(product, 2, "abc", Locale.forLanguageTag("pl-PL"));
//  }
//
//  @Test
//  void executeWithDifferentProductId() {
//    Product product = loadProduct2Mock();
//    ShoppingList shoppingList = loadWishlistMock();
//    Customer customer = loadCustomerMock();
//
//    when(wishlistUtil.loadCustomer("abc")).thenReturn(customer);
//    when(wishlistUtil.loadWishlist(customer, "pl-PL")).thenReturn(shoppingList);
//    when(blockingSphereClient.executeBlocking(
//        ShoppingListUpdateCommand.of(
//            shoppingList, AddLineItem.of(product).withVariantId(1).withQuantity(1L)))).thenReturn(null);
//
//    addProductToWishlist.execute(product, 2, "abc", Locale.forLanguageTag("pl-PL"));
//  }
//
//  @Test
//  void executeWithCustomerHasNoWishlist() {
//    Product product = loadProductMock();
//    ShoppingList shoppingList = loadWishlistMock();
//    Customer customer = loadCustomerMock();
//
//    when(wishlistUtil.loadCustomer("abc")).thenReturn(customer);
//    when(wishlistUtil.loadWishlist(customer, "pl-PL")).thenReturn(null);
//    when(wishlistUtil.createShoppingList(customer, Locale.forLanguageTag("pl-PL"))).thenReturn(shoppingList);
//    when(blockingSphereClient.executeBlocking(
//        ShoppingListUpdateCommand.of(
//            shoppingList, AddLineItem.of(product).withVariantId(1).withQuantity(1L)))).thenReturn(null);
//
//    addProductToWishlist.execute(product, 1, "abc", Locale.forLanguageTag("pl-PL"));
//  }
//
//  @Test
//  void executeWithCustomerIsNull() {
//    Product product = loadProductMock();
//
//    when(wishlistUtil.loadCustomer("abc")).thenReturn(null);
//    assertThrows(CustomerNotFoundException.class,
//        () -> addProductToWishlist.execute(product, 1, "abc", Locale.forLanguageTag("pl-PL")));
//  }
//
//  @Test
//  void executeWithProductAlreadyExistsException() {
//    Product product = loadProductMock();
//    ShoppingList shoppingList = loadWishlistWithSameProductsMock();
//    Customer customer = loadCustomerMock();
//
//    when(wishlistUtil.loadCustomer("abc")).thenReturn(customer);
//    doReturn(shoppingList).when(wishlistUtil).loadWishlist(customer, "pl-PL");
//
//    Assertions.assertThrows(
//        ProductAlreadyExistsException.class,
//        () -> {
//          addProductToWishlist.execute(product, 1, "abc", Locale.forLanguageTag("pl-PL"));
//        });
//  }
//
//  @MockBean(BlockingSphereClient.class)
//  BlockingSphereClient blockingSphereClient() {
//    return mock(BlockingSphereClient.class);
//  }
//
//  @MockBean(WishlistUtil.class)
//  WishlistUtil wishlistUtil() {
//    return mock(WishlistUtil.class);
//  }
}