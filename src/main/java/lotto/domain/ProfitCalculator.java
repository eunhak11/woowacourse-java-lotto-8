package lotto.domain;

public class ProfitCalculator {
    private static final int SCALE = 10;

    public static double calculateProfitRate(long totalPrize, int purchaseAmount) {
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        return round(profitRate);
    }

    private static double round(double value) {
        return Math.round(value * SCALE) / (double) SCALE;
    }
}
