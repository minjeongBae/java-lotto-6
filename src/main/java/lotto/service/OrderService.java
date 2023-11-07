package lotto.service;

import lotto.domain.OrderCalculator;

import static lotto.values.ExceptionMessage.*;

public class OrderService {
    int lottoNumber;

    public int generateLottoNumber(String input) {
        checkException(input);
        return lottoNumber;
    }

    private void checkException(String input) {
        checkMoneyException(input);
        checkComputeException(input);
    }

    private void checkMoneyException(String input) {
        if (input.length() == 0) throw new IllegalArgumentException(NOT_NULL.getMessage());
        if (!input.matches(ONLY_NUMBER.getMessage())) throw new IllegalArgumentException(NOT_NUMBER.getMessage());
    }

    private void checkComputeException(String input) {
        OrderCalculator calculator = new OrderCalculator(input);
        if (!calculator.checkThousands()) throw new IllegalArgumentException(CAN_NOT_PURCHASE.getMessage());
        if (calculator.tooMuchValue()) throw new IllegalArgumentException(TOO_MUCH_MONEY.getMessage());

        lottoNumber = calculator.computeInt();
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

}