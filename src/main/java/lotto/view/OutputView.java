package lotto.view;

import lotto.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String STATISTICS_HEADER = "\n당첨 통계\n---";
    private static final DecimalFormat PRIZE_FORMAT = new DecimalFormat("#,###");

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

    public static void printStatistics(LottoStatistics statistics, double profitRate) {
        System.out.println(STATISTICS_HEADER);
        printRankStatistics(statistics);
        printProfitRate(profitRate);
    }

    private static void printRankStatistics(LottoStatistics statistics) {
        printRank(Rank.FIFTH, statistics);
        printRank(Rank.FOURTH, statistics);
        printRank(Rank.THIRD, statistics);
        printRank(Rank.SECOND, statistics);
        printRank(Rank.FIRST, statistics);
    }

    private static void printRank(Rank rank, LottoStatistics statistics) {
        String message = formatRankMessage(rank, statistics.getCount(rank));
        System.out.println(message);
    }

    private static String formatRankMessage(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                    rank.getMatchCount(),
                    PRIZE_FORMAT.format(rank.getPrize()),
                    count);
        }
        return String.format("%d개 일치 (%s원) - %d개",
                rank.getMatchCount(),
                PRIZE_FORMAT.format(rank.getPrize()),
                count);
    }

    private static void printProfitRate(double profitRate) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profitRate));
    }
}
