# Wishlist Api Function
>  This app is responsible for the wishlist crud operations 

[![codecov](https://codecov.io/gh/karimbkb/wishlist-graphql-api/branch/master/graph/badge.svg?token=tprxgsRDGg)](https://codecov.io/gh/karimbkb/wishlist-graphql-api)
[![Build Status](https://travis-ci.com/karimbkb/wishlist-graphql-api.svg?branch=master)](https://travis-ci.com/karimbkb/wishlist-graphql-api)
[![made-with-Micronaut](https://img.shields.io/badge/Micronaut-2.3.1-1f425f.svg)](https://micronaut.io/)
[![made-with-Commercetools](https://img.shields.io/badge/GraphQL-1.3.0-1f425f.svg)](https://commercetools.com/)


## Contents

- [Setup](#setup)
- [Dependencies](#dependencies)
- [Endpoints](#endpoints)
- [Unit Tests](#unit-tests)
- [Code Coverage](#code-coverage)
- [Coding Style](#coding-style)
- [Static Code Analyzer](#static-code-analyzer)

## Setup

Go into the root directory of the application and run

```
docker-compse up -d --build
```

After that the api can be accessed via `http://localhost:8080/graphql`

## Dependencies

- Java 11
- Gradle 6.1
- JUnit 5
- Micronaut
- Testcontainers

## Endpoints

Add product to wishlist:

```
mutation {
  addProductToWishlist(input: {
    customerId: "8e5ef1ec-d115-49af-b431-85da02ff3ee6"
    sku: "product-1"
    locale: "pl-PL"
  }) {
    sku
  }
}
```

Remove product from wishlist:

```
mutation {
  removeProductFromWishlist(input: {
    customerId: "8e5ef1ec-d115-49af-b431-85da02ff3ee6"
    sku: "product-2"
    locale: "pl-PL"
  }) {
    id
    sku
  }
}
```

Fetch all products available on the wishlist:

```
mutation {
  fetchProducts(input: {
    customerId: "8e5ef1ec-d115-49af-b431-85da02ff3ee6"
    locale: "pl-PL"
    offset: 0
    limit: 10
  }) {
    items {
      id
      sku
    }
    count 
  }
}
```

## Unit Tests

To execute Unit Tests run:

```
./gradlew test
```

## Code Coverage

To check if the code coverage ratio was reached run this command:

**INFO: You have to run `./gradlew test` first!**

```
./gradlew jacocoTestCoverageVerification
```

To create a code coverage report run this command:

```
./gradlew jacocoTestReport
```

## Coding Style

Coding style is based on the Google Java Format.

To verify if all java files are formatted right:

```
./gradlew verGJF
```

To format all java files:

```
./gradlew goJF
```

## Static Code Analyzer

Not used
