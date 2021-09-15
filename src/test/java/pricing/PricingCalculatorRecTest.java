package pricing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PricingCalculatorRecTest {

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "/pricing/pricing0Discount.csv")
    void test_calculatePriceFor_Given0KindsOfDiscounts(int boughtQuantity, int unitPrice, long expectedTotalPrice) {
        long actualTotalPrice = PricingCalculatorRec.bestTotalPriceFor(boughtQuantity, unitPrice, Collections.emptyList());
        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "/pricing/pricing1Discount.csv")
    void test_calculatePriceFor_Given1KindsOfDiscount(int boughtQuantity,
                                                      int unitPrice,
                                                      int discountQuantity0,
                                                      int discountUnitPrice0,
                                                      long expectedTotalPrice) {
        List<PriceRule> priceRules = List.of(
                PriceRule.of(discountQuantity0, discountUnitPrice0));
        long actualTotalPrice = PricingCalculatorRec.bestTotalPriceFor(boughtQuantity, unitPrice, priceRules);
        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "/pricing/pricing2Discount.csv")
    void test_calculatePriceFor_Given2KindsOfDiscount(int boughtQuantity,
                                                      int unitPrice,
                                                      int discountQuantity0,
                                                      int discountUnitPrice0,
                                                      int discountQuantity1,
                                                      int discountUnitPrice1,
                                                      long expectedTotalPrice) {
        List<PriceRule> priceRules = List.of(
                PriceRule.of(discountQuantity0, discountUnitPrice0),
                PriceRule.of(discountQuantity1, discountUnitPrice1));
        long actualTotalPrice = PricingCalculatorRec.bestTotalPriceFor(boughtQuantity, unitPrice, priceRules);
        assertEquals(expectedTotalPrice, actualTotalPrice);
    }
}