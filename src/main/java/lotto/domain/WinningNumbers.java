package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.winningLotto = new Lotto(numbers);
        validateBonusNumber(bonusNumber, numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        validateBonusRange(bonusNumber);
        validateBonusDuplicate(bonusNumber, numbers);
    }

    private void validateBonusRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusDuplicate(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
