package lotto.validator;

public class PurchaseAmountValidator {
    private static final int LOTTO_PRICE = 1000;
    private static final int MINIMUM_AMOUNT = LOTTO_PRICE;

    public static void validate(int amount) {
        validatePositive(amount);
        validateDivisible(amount);
    }

    private static void validatePositive(int amount) {
        if (amount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + MINIMUM_AMOUNT + "원 이상이어야 합니다.");
        }
    }

    private static void validateDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_PRICE + "원 단위로 입력해야 합니다.");
        }
    }
}
