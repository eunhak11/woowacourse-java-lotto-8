package lotto.view;

import lotto.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printPurchaseCount(int count) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        List<Integer> sortedNumbers = getSortedNumbers(lotto);
        System.out.println(sortedNumbers);
    }

    private static List<Integer> getSortedNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
