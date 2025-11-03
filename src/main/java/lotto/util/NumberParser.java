package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberParser {
    private static final String DELIMITER = ",";

    public static List<Integer> parseNumbers(String input) {
        validateNotEmpty(input);
        String[] tokens = input.split(DELIMITER);
        return convertToIntegers(tokens);
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해주세요.");
        }
    }

    private static List<Integer> convertToIntegers(String[] tokens) {
        try {
            return Arrays.stream(tokens)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로 입력해야 합니다.");
        }
    }
}
