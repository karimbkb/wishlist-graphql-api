package de.karimbkb.wishlistgraphqlapi.service;

import de.karimbkb.wishlistgraphqlapi.Mocks;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class RemoveProductFromWishlistTest extends Mocks {
//
//  @Inject BlockingSphereClient blockingSphereClient;
//  @Inject WishlistUtil wishlistUtil;
//  @Inject RemoveProductFromWishlist removeProductFromWishlist;
//
//  @Test
//  void execute() {
//    Product product = loadProduct2Mock();
//    ShoppingList shoppingList = loadWishlistMock();
//    LineItem lineItem = shoppingList.getLineItems().get(0);
//    Customer customer = loadCustomerMock();
//
//    when(wishlistUtil.loadCustomer("abc")).thenReturn(customer);
//    when(wishlistUtil.loadWishlist(customer, "pl-PL")).thenReturn(shoppingList);
//    when(blockingSphereClient.executeBlocking(
//        ShoppingListUpdateCommand.of(
//            shoppingList, RemoveLineItem.of(lineItem).withQuantity(1L)))).thenReturn(null);
//
//    removeProductFromWishlist.execute(product, 1, "abc", Locale.forLanguageTag("pl-PL"));
//  }
//
//  @Test
//  void executeWithDifferentVariantId() {
//    Product product = loadProduct2Mock();
//    ShoppingList shoppingList = loadWishlistMock();
//    LineItem lineItem = shoppingList.getLineItems().get(0);
//    Customer customer = loadCustomerMock();
//
//    when(wishlistUtil.loadCustomer("abc")).thenReturn(customer);
//    when(wishlistUtil.loadWishlist(customer, "pl-PL")).thenReturn(shoppingList);
//    when(blockingSphereClient.executeBlocking(
//        ShoppingListUpdateCommand.of(
//            shoppingList, RemoveLineItem.of(lineItem).withQuantity(1L)))).thenReturn(null);
//
//    removeProductFromWishlist.execute(product, 2, "abc", Locale.forLanguageTag("pl-PL"));
//  }
//
//  @Test
//  void executeWithDifferentProductId() {
//    Product product = loadProductMock();
//    ShoppingList shoppingList = loadWishlistMock();
//    LineItem lineItem = shoppingList.getLineItems().get(0);
//    Customer customer = loadCustomerMock();
//
//    when(wishlistUtil.loadCustomer("abc")).thenReturn(customer);
//    when(wishlistUtil.loadWishlist(customer, "pl-PL")).thenReturn(shoppingList);
//    when(blockingSphereClient.executeBlocking(
//        ShoppingListUpdateCommand.of(
//            shoppingList, RemoveLineItem.of(lineItem).withQuantity(1L)))).thenReturn(null);
//
//    removeProductFromWishlist.execute(product, 2, "abc", Locale.forLanguageTag("pl-PL"));
//  }
//
//  @Test
//  void executeWithCustomerIsNull() {
//    Product product = loadProduct2Mock();
//
//    when(wishlistUtil.loadCustomer("abc")).thenReturn(null);
//    assertThrows(CustomerNotFoundException.class,
//        () -> removeProductFromWishlist.execute(product, 1, "abc", Locale.forLanguageTag("pl-PL")));
//  }
//
//  @Test
//  void executeWithProductAlreadyExistsException() {
//    Product product = loadProduct2Mock();
//    ShoppingList shoppingList = loadWishlistWithSameProductsMock();
//    Customer customer = loadCustomerMock();
//
//    when(wishlistUtil.loadCustomer("abc")).thenReturn(customer);
//    doReturn(null).when(wishlistUtil).loadWishlist(customer, "pl-PL");
//
//    assertThrows(
//        WishlistDoesntExistException.class,
//        () -> {
//          removeProductFromWishlist.execute(product, 1, "abc", Locale.forLanguageTag("pl-PL"));
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
