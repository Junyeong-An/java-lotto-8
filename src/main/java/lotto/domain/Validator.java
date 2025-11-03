package lotto.domain;

import lotto.common.Messages;
import lotto.common.Numbers;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    public static void validatePurchaseAmount(int amount) {
        if (amount < Numbers.LOTTO_PRICE || amount % Numbers.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Messages.ERROR_PURCHASE_UNIT);
        }
    }

    public static List<Integer> parseNumbers(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            new Lotto(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.ERROR_NUMBER_ONLY);
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Messages.ERROR_BONUS_DUP);
        }
        if (bonusNumber < Numbers.MIN_NUMBER || bonusNumber > Numbers.MAX_NUMBER) {
            throw new IllegalArgumentException(Messages.ERROR_BONUS_RANGE);
        }
    }
}