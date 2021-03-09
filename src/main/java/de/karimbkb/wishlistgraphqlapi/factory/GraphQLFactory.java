package de.karimbkb.wishlistgraphqlapi.factory;

import de.karimbkb.wishlistgraphqlapi.model.mutation.AddWishlistItemMutation;
import de.karimbkb.wishlistgraphqlapi.model.mutation.FetchProductsMutation;
import de.karimbkb.wishlistgraphqlapi.model.mutation.RemoveWishlistItemMutation;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.core.io.ResourceResolver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.inject.Singleton;

@Factory
public class GraphQLFactory {

  @Bean
  @Singleton
  public GraphQL graphQL(
      ResourceResolver resourceResolver,
      AddWishlistItemMutation addWishlistItemMutation,
      RemoveWishlistItemMutation removeWishlistItemMutation,
      FetchProductsMutation fetchProductsMutation) {
    SchemaParser schemaParser = new SchemaParser();
    SchemaGenerator schemaGenerator = new SchemaGenerator();

    TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();
    typeRegistry.merge(
        schemaParser.parse(
            new BufferedReader(
                new InputStreamReader(
                    resourceResolver
                        .getResourceAsStream("classpath:schemas/Wishlist.graphqls")
                        .get()))));

    RuntimeWiring runtimeWiring =
        RuntimeWiring.newRuntimeWiring()
            .type(
                "Mutation",
                typeWiring ->
                    typeWiring.dataFetcher("addProductToWishlist", addWishlistItemMutation))
            .type(
                "Mutation",
                typeWiring ->
                    typeWiring.dataFetcher("removeProductFromWishlist", removeWishlistItemMutation))
            .type(
                "Mutation",
                typeWiring -> typeWiring.dataFetcher("fetchProducts", fetchProductsMutation))
            .build();

    GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);

    return GraphQL.newGraphQL(graphQLSchema).build();
  }
}
