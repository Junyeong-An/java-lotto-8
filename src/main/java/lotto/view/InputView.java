package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Messages;

public class InputView {

    public static String readPurchaseAmount() {
        System.out.println(Messages.PROMPT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String readWinningNumbers() {
        System.out.println(Messages.PROMPT_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(Messages.PROMPT_BONUS_NUMBER);
        return Console.readLine();
    }
}