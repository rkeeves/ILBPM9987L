package pricing;

public class PriceRule {

    private final int discountQuantity;

    private final int discountUnitPrice;

    private PriceRule(int discountQuantity, int discountUnitPrice) {
        this.discountUnitPrice = discountUnitPrice;
        this.discountQuantity = discountQuantity;
    }

    public static PriceRule of(int discountQuantity, int discountPrice) {
        if (discountQuantity < 1) {
            throw new IllegalArgumentException("Discount quantity cannot be lower than 1!");
        }
        if (discountPrice < 0) {
            throw new IllegalArgumentException("Discount price cannot be lower than 0!");
        }
        return new PriceRule(discountQuantity,discountPrice);
    }

    public int getDiscountUnitPrice() {
        return discountUnitPrice;
    }

    public int getDiscountQuantity() {
        return discountQuantity;
    }
}

