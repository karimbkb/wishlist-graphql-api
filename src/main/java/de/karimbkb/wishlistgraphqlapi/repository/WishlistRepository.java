package de.karimbkb.wishlistgraphqlapi.repository;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import de.karimbkb.wishlistgraphqlapi.dto.Customer;
import de.karimbkb.wishlistgraphqlapi.dto.Wishlist;
import de.karimbkb.wishlistgraphqlapi.dto.WishlistProduct;
import io.micronaut.context.annotation.Prototype;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Prototype
public class WishlistRepository {
  private MongoClient mongoClient;
  private WishlistProductRepository wishlistProductRepository;

  @Inject
  public WishlistRepository(
      MongoClient mongoClient, WishlistProductRepository wishlistProductRepository) {
    this.mongoClient = mongoClient;
    this.wishlistProductRepository = wishlistProductRepository;
  }

  public Wishlist loadWishlist(@Valid Customer customer, String locale) {
    Wishlist wishlist =
        getWishlistCollection()
            .find(and(eq("customerId", customer.getId()), eq("locale", locale)))
            .limit(1)
            .first();

    if (Objects.isNull(wishlist)) {
      return null;
    }

    List<WishlistProduct> products = new ArrayList<>();
    wishlistProductRepository.loadProducts(wishlist).forEach(products::add);

    wishlist.setProducts(products);

    return wishlist;
  }

  public void saveWishlist(@Valid Wishlist wishlist) {
    getWishlistCollection().insertOne(wishlist);
  }

  private MongoCollection<Wishlist> getWishlistCollection() {
    return mongoClient.getDatabase("wishlists").getCollection("wishlist", Wishlist.class);
  }
}
