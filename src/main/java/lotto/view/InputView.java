package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";

    public static int readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        String input = Console.readLine();
        return parseAmount(input);
    }

    private static int parseAmount(String input) {
        validateNotEmpty(input);
        return parseInteger(input);
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해주세요.");
        }
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
        }
    }
}
