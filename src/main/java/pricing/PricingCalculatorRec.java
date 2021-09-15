package pricing;

import java.util.List;

public class PricingCalculatorRec {

    private PricingCalculatorRec() {

    }

    public static long bestTotalPriceFor(int purchasedQuantity, int unitPrice, final List<PriceRule> priceRules) {
        final var uniqueMinimalPriceRules = PriceRules.getUniqueMinimalPriceRulesFor(unitPrice, priceRules);
        return calculateBestTotalPriceFor(purchasedQuantity,
                unitPrice,
                uniqueMinimalPriceRules);
    }

    private static long calculateBestTotalPriceFor(int remainingQuantity, int unitPrice, final List<PriceRule> priceRules) {
        if (priceRules.isEmpty()) {
            return (long) remainingQuantity * unitPrice;
        }
        if (remainingQuantity < 1) {
            return 0;
        }
        PriceRule priceRule = priceRules.get(0);
        int discountQuantity = priceRule.getDiscountQuantity();
        int discountPrice = priceRule.getDiscountUnitPrice();
        List<PriceRule> remainingPricingRules = priceRules.subList(1, priceRules.size());
        long min = Long.MAX_VALUE;
        long p;
        for (int chosenQuantity = 0; chosenQuantity <= remainingQuantity; chosenQuantity += discountQuantity) {
            p = chosenQuantity * discountPrice + calculateBestTotalPriceFor(remainingQuantity-chosenQuantity,
                    unitPrice,
                    remainingPricingRules);
            min = Math.min(min, p);
        }
        return min;
    }
}
