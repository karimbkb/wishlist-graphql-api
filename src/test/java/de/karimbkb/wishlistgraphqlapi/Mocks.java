package de.karimbkb.wishlistgraphqlapi;

import de.karimbkb.wishlistgraphqlapi.dto.Customer;
import de.karimbkb.wishlistgraphqlapi.dto.Product;
import de.karimbkb.wishlistgraphqlapi.dto.Wishlist;
import de.karimbkb.wishlistgraphqlapi.dto.WishlistProduct;

import java.math.BigDecimal;
import java.util.List;

public class Mocks {

  protected Product loadProductMock() {
    return new Product("f7665cf1-529b-4e64-b7fb-a613d4ccabb3", "Product 1", "product-1", new BigDecimal("12.99"));
  }

  protected Product loadProduct2Mock() {
    return new Product("c1363d4f-4ab0-47f4-b9e0-d5dd4e73f8a0", "Product 2", "product-2", new BigDecimal("5.99"));
  }
  //
  //  protected Product loadProductWithoutValidDatesMock() {
  //    return SphereJsonUtils.readObjectFromResource(
  //        "mocks/product-without-valid-dates-in-price-entity.json", Product.typeReference());
  //  }
  //
  //  protected Product loadProduct2Mock() {
  //    return SphereJsonUtils.readObjectFromResource(
  //        "mocks/product-2.json", Product.typeReference());
  //  }
  //
  //  protected PagedQueryResult<Product> loadProductCollectionMock() {
  //    return SphereJsonUtils.readObjectFromResource(
  //        "mocks/product-collection.json", new TypeReference<PagedQueryResult<Product>>() {});
  //  }
  //
  //  protected PagedQueryResult<Product> loadEmptyProductCollectionMock() {
  //    return SphereJsonUtils.readObjectFromResource(
  //        "mocks/product-collection-empty.json", new TypeReference<PagedQueryResult<Product>>()
  // {});
  //  }
  //
  //  protected PagedQueryResult<Product> loadProductCollectionWithUnpublishedProductMock() {
  //    return SphereJsonUtils.readObjectFromResource(
  //        "mocks/product-collection-with-unpublished-product.json", new
  // TypeReference<PagedQueryResult<Product>>() {});
  //  }
  //
  protected Wishlist loadWishlistMock() {
    return new Wishlist(
        "9ba298fe-58a8-4f7d-99ad-c1fcd68d949f",
        "3e9e0680-9ff5-4b9a-88e9-84b17cbf1be2",
        "de-DE",
        true,
        "2020-02-12 12:12:12",
        "2020-02-12 12:12:12",
        List.of(
            new WishlistProduct(
                "d332a2dd-010f-4201-a1f0-e27a7f07da81",
                "product-sku-123",
                "9ba298fe-58a8-4f7d-99ad-c1fcd68d949f",
                "2020-02-12 11:11:11",
                "2020-02-12 04:04:04",
                new BigDecimal("4.99"))));
  }
  //
  //  protected ShoppingList loadWishlistWithZeroLineItemsMock() {
  //    return SphereJsonUtils.readObjectFromResource(
  //        "mocks/wishlist-with-zero-lineitems.json", ShoppingList.typeReference());
  //  }
  //
  //  protected PagedQueryResult<ShoppingList> loadWishlistCollectionMock() {
  //    return SphereJsonUtils.readObjectFromResource(
  //        "mocks/wishlist-collection.json", new TypeReference<PagedQueryResult<ShoppingList>>()
  // {});
  //  }
  //
  //  protected PagedQueryResult<ShoppingList> loadEmptyWishlistCollectionMock() {
  //    return SphereJsonUtils.readObjectFromResource(
  //        "mocks/wishlist-collection-empty.json", new
  // TypeReference<PagedQueryResult<ShoppingList>>() {});
  //  }
  //
  //  protected ShoppingList loadWishlistWithSameProductsMock() {
  //    return SphereJsonUtils.readObjectFromResource(
  //        "mocks/wishlist-with-same-products.json", ShoppingList.typeReference());
  //  }
  //
    protected Customer loadCustomerMock() {
      return new Customer(
      "3e9e0680-9ff5-4b9a-88e9-84b17cbf1be2",
      "John Doe",
      "john.doe@email.com"
      );
    }
  //
  //  protected PagedQueryResult<InventoryEntry> loadInventoryEntryMock() {
  //    return SphereJsonUtils.readObjectFromResource(
  //        "mocks/inventory-entry.json", new TypeReference<PagedQueryResult<InventoryEntry>>() {});
  //  }
  //
  //  protected PagedQueryResult<InventoryEntry> loadEmptyInventoryEntryMock() {
  //    return SphereJsonUtils.readObjectFromResource(
  //        "mocks/inventory-entry-empty.json", new
  // TypeReference<PagedQueryResult<InventoryEntry>>() {});
  //  }
  //
  //  protected PagedQueryResult<InventoryEntry> loadInventoryEntryWithZeroQtyMock() {
  //    return SphereJsonUtils.readObjectFromResource(
  //        "mocks/inventory-entry-with-zero-qty.json", new
  // TypeReference<PagedQueryResult<InventoryEntry>>() {});
  //  }
}
