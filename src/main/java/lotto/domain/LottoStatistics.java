package lotto.domain;

import lotto.Lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<Rank, Integer> statistics;

    public LottoStatistics(List<Lotto> lottos, WinningNumbers winningNumbers) {
        this.statistics = new EnumMap<>(Rank.class);
        initializeStatistics();
        calculateStatistics(lottos, winningNumbers);
    }

    private void initializeStatistics() {
        for (Rank rank : Rank.values()) {
            if (rank.isWinning()) {
                statistics.put(rank, 0);
            }
        }
    }

    private void calculateStatistics(List<Lotto> lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(lotto, winningNumbers);
            updateStatistics(rank);
        }
    }

    private Rank calculateRank(Lotto lotto, WinningNumbers winningNumbers) {
        LottoResult result = new LottoResult(lotto, winningNumbers);
        return result.calculateRank();
    }

    private void updateStatistics(Rank rank) {
        if (rank.isWinning()) {
            statistics.put(rank, statistics.get(rank) + 1);
        }
    }

    public int getCount(Rank rank) {
        return statistics.getOrDefault(rank, 0);
    }

    public long getTotalPrize() {
        long total = 0;
        for (Rank rank : statistics.keySet()) {
            total += (long) rank.getPrize() * statistics.get(rank);
        }
        return total;
    }
}
