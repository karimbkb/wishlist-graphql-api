package de.karimbkb.wishlistgraphqlapi.service;

import de.karimbkb.wishlistgraphqlapi.Mocks;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class FetchProductsTest extends Mocks {
//  @Inject WishlistUtil wishlistUtil;
//  @Inject FetchProducts fetchProducts;
//
//  @Test
//  void execute() {
//    final Customer customer = loadCustomerMock();
//    when(wishlistUtil.loadCustomer("customer-abc")).thenReturn(customer);
//
//    final ShoppingList shoppingList = loadWishlistMock();
//    when(wishlistUtil.loadWishlist(customer, "pl-PL")).thenReturn(shoppingList);
//
//    assertNotNull(fetchProducts.execute("customer-abc", Locale.forLanguageTag("pl-PL")));
//  }
//
//  @Test
//  void executeWithCustomerException() {
//    when(wishlistUtil.loadCustomer("customer-abc")).thenReturn(null);
//    assertThrows(CustomerNotFoundException.class,
//        () -> fetchProducts.execute("customer-abc", Locale.forLanguageTag("pl-PL")));
//  }
//
//  @Test
//  void executeWithWishlistException() {
//    final Customer customer = loadCustomerMock();
//    when(wishlistUtil.loadCustomer("customer-abc")).thenReturn(customer);
//
//    when(wishlistUtil.loadWishlist(customer, "pl-PL")).thenReturn(null);
//
//    assertThrows(WishlistDoesntExistException.class,
//        () -> fetchProducts.execute("customer-abc", Locale.forLanguageTag("pl-PL")));
//  }
//
//  @MockBean(WishlistUtil.class)
//  WishlistUtil wishlistUtil() {
//    return mock(WishlistUtil.class);
//  }
//
//  @MockBean(BlockingSphereClient.class)
//  BlockingSphereClient blockingSphereClient() {
//    return mock(BlockingSphereClient.class);
//  }
}