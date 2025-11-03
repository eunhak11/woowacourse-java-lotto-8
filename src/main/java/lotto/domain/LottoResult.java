package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class LottoResult {
    private final Lotto lotto;
    private final WinningNumbers winningNumbers;

    public LottoResult(Lotto lotto, WinningNumbers winningNumbers) {
        this.lotto = lotto;
        this.winningNumbers = winningNumbers;
    }

    public Rank calculateRank() {
        int matchCount = countMatches();
        boolean bonusMatch = isBonusMatch();
        return Rank.of(matchCount, bonusMatch);
    }

    private int countMatches() {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winning = winningNumbers.getWinningNumbers();

        int count = 0;
        for (Integer number : lottoNumbers) {
            if (winning.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isBonusMatch() {
        return lotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }
}
