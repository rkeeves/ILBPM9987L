package pricing;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PriceRules {

    private PriceRules() {

    }

    public static List<PriceRule> getUniqueMinimalPriceRulesFor(int unitPrice, final List<PriceRule> rules) {
        final var map = new HashMap<Integer, Integer>();
        for (var rule : rules) {
            int quantity = rule.getDiscountQuantity();
            int price = rule.getDiscountUnitPrice();
            if (unitPrice > price) {
                var lastPrice = map.getOrDefault(quantity, Integer.MAX_VALUE);
                map.put(rule.getDiscountQuantity(), Math.min(price, lastPrice));
            }
        }
        return map.entrySet()
                .stream()
                .map(entry-> PriceRule.of(entry.getKey(), entry.getValue())).collect(Collectors.toList());
    }
}
