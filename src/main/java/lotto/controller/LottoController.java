package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMachine;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoMachine = new LottoMachine(new LottoGenerator());
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = purchaseLottos(purchaseAmount);
        displayLottos(lottos);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                int amount = InputView.readPurchaseAmount();
                PurchaseAmountValidator.validate(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> purchaseLottos(int amount) {
        return lottoMachine.purchaseLottos(amount);
    }

    private void displayLottos(List<Lotto> lottos) {
        OutputView.printPurchaseCount(lottos.size());
        OutputView.printLottos(lottos);
    }
}
