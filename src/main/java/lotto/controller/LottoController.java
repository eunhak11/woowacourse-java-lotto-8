package lotto.controller;

import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        int purchaseAmount = getPurchaseAmount();
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
}
