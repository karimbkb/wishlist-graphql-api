package de.karimbkb.wishlistgraphqlapi.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import de.karimbkb.wishlistgraphqlapi.dto.Customer;
import de.karimbkb.wishlistgraphqlapi.dto.Wishlist;
import io.micronaut.context.annotation.Prototype;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import javax.inject.Inject;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bson.Document;

@RequiredArgsConstructor
@Prototype
public class WishlistRepository {
  private MongoClient mongoClient;

  @Inject
  public WishlistRepository(MongoClient mongoClient) {
    this.mongoClient = mongoClient;
  }

  public Wishlist loadWishlist(@Valid Customer customer, Locale locale) {
    return getWishlistCollection()
        .aggregate(
            Arrays.asList(
                new Document(
                    "$lookup",
                    new Document("from", "wishlistProduct")
                        .append("let", new Document("wId", "$_id"))
                        .append(
                            "pipeline",
                            Collections.singletonList(
                                new Document(
                                    "$match",
                                    new Document(
                                        "$expr",
                                        new Document(
                                            "$eq", Arrays.asList("$wishlistId", "$$wId"))))))
                        .append("as", "products")),
                new Document(
                    "$match",
                    new Document(
                        "$expr",
                        new Document(
                            "$and",
                            Arrays.asList(
                                new Document("$eq", Arrays.asList("$customerId", customer.getId())),
                                new Document(
                                    "$eq", Arrays.asList("$locale", locale.toLanguageTag()))))))))
        .first();
  }

  public void saveWishlist(@Valid Wishlist wishlist) {
    getWishlistCollection().insertOne(wishlist);
  }

  private MongoCollection<Wishlist> getWishlistCollection() {
    return mongoClient.getDatabase("wishlists").getCollection("wishlist", Wishlist.class);
  }
}
