package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "\n보너스 번호를 입력해 주세요.";

    public static int readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        String input = Console.readLine();
        return parseAmount(input);
    }

    public static String readWinningNumbers() {
        System.out.println(WINNING_NUMBERS_PROMPT);
        return Console.readLine();
    }

    public static int readBonusNumber() {
        System.out.println(BONUS_NUMBER_PROMPT);
        String input = Console.readLine();
        return parseBonusNumber(input);
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

    private static int parseBonusNumber(String input) {
        validateBonusNotEmpty(input);
        return parseBonusInteger(input);
    }

    private static void validateBonusNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해주세요.");
        }
    }

    private static int parseBonusInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
        }
    }
}
