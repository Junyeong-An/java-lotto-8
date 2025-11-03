package lotto.common;

public final class Messages {
    public static final String ERROR_PREFIX = "[ERROR] ";

    public static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static final String PURCHASE_COUNT = "%d개를 구매했습니다.";
    public static final String STATISTICS_HEADER = "\n당첨 통계\n---";
    public static final String PROFIT_RATE = "총 수익률은 %.1f%%입니다.";
    public static final String STATISTICS_LINE = "%s - %d개";

    public static final String ERROR_PURCHASE_UNIT = ERROR_PREFIX + "구입 금액은 1000원 단위여야 합니다.";
    public static final String ERROR_AMOUNT_NUMBER = ERROR_PREFIX + "금액은 숫자만 입력 가능합니다.";
    public static final String ERROR_NUMBER_ONLY = ERROR_PREFIX + "숫자만 입력 가능합니다.";
    public static final String ERROR_LOTTO_SIZE = ERROR_PREFIX + "로또 번호는 6개여야 합니다.";
    public static final String ERROR_LOTTO_DUPLICATE = ERROR_PREFIX + "로또 번호에 중복이 있습니다.";
    public static final String ERROR_NUMBER_RANGE = ERROR_PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_BONUS_DUP = ERROR_PREFIX + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String ERROR_BONUS_RANGE = ERROR_PREFIX + "보너스 번호는 1~45 사이여야 합니다.";

    private Messages() {
    }
}