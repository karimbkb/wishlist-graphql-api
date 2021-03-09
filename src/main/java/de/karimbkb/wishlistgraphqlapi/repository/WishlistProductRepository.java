package de.karimbkb.wishlistgraphqlapi.repository;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import de.karimbkb.wishlistgraphqlapi.dto.Product;
import de.karimbkb.wishlistgraphqlapi.dto.Wishlist;
import de.karimbkb.wishlistgraphqlapi.dto.WishlistProduct;
import io.micronaut.context.annotation.Prototype;
import java.time.LocalDateTime;
import javax.inject.Inject;
import javax.validation.Valid;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Prototype
public class WishlistProductRepository {
  public static final int WISHLIST_PRODUCT_LIMIT = 999;
  private MongoClient mongoClient;

  @Inject
  public WishlistProductRepository(MongoClient mongoClient) {
    this.mongoClient = mongoClient;
  }

  public FindIterable<WishlistProduct> loadProducts(@Valid Wishlist wishlist) {
    return getWishlistCollection()
        .find(eq("wishlistId", wishlist.getId()))
        .limit(WISHLIST_PRODUCT_LIMIT);
  }

  public void saveProduct(Product product, @Valid Wishlist wishlist) {
    WishlistProduct wishlistProduct =
        new WishlistProduct(
            product.getId(),
            product.getSku(),
            wishlist.getId(),
            LocalDateTime.now().toString(),
            LocalDateTime.now().toString(),
            product.getPrice());

    getWishlistCollection().insertOne(wishlistProduct);
  }

  public void removeProduct(@Valid WishlistProduct wishlistProductToRemove) {
    getWishlistCollection().deleteOne(eq("_id", wishlistProductToRemove.getId()));
  }

  private MongoCollection<WishlistProduct> getWishlistCollection() {
    return mongoClient
        .getDatabase("wishlists")
        .getCollection("wishlistProduct", WishlistProduct.class);
  }
}
