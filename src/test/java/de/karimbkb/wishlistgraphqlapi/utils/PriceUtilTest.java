package de.karimbkb.wishlistgraphqlapi.utils;

import de.karimbkb.wishlistgraphqlapi.Mocks;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class PriceUtilTest extends Mocks {
//
//  private final ZonedDateTime dateTime = ZonedDateTime
//      .of(2020, 10, 10, 0, 0, 0, 0, ZoneId.of("UTC"));
//  @Inject
//  PriceUtil priceUtil;
//
//  @Test
//  void getPrice() {
//    Product product = loadProductWithoutValidDatesMock();
//
//    try (MockedStatic<ZonedDateTime> mockedDateTime = Mockito.mockStatic(ZonedDateTime.class)) {
//      mockedDateTime.when(ZonedDateTime::now).thenReturn(dateTime);
//
//      assertTrue(
//          priceUtil
//              .getPrice(
//                  product.getMasterData().getCurrent().getMasterVariant(),
//                  Locale.forLanguageTag("de-DE"))
//              .contains("22,95"));
//    }
//  }
//
//  @Test
//  void getSpecialPrice() {
//    Product product = loadProductMock();
//
//    try (MockedStatic<ZonedDateTime> mockedDateTime = Mockito.mockStatic(ZonedDateTime.class)) {
//      mockedDateTime.when(ZonedDateTime::now).thenReturn(dateTime);
//
//      assertEquals(
//          "103,00 zł",
//          priceUtil.getSpecialPrice(
//              product.getMasterData().getCurrent().getVariant(1), Locale.forLanguageTag("pl-PL")));
//    }
//  }
//
//  @Test
//  void getSpecialPriceWithNullDates() {
//    Product product = loadProductWithoutValidDatesMock();
//
//    try (MockedStatic<ZonedDateTime> mockedDateTime = Mockito.mockStatic(ZonedDateTime.class)) {
//      mockedDateTime.when(ZonedDateTime::now).thenReturn(dateTime);
//
//      assertNotNull(
//          priceUtil.getSpecialPrice(
//              product.getMasterData().getCurrent().getVariant(1), Locale.forLanguageTag("pl-PL")));
//    }
//  }
}
