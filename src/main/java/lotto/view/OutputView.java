package lotto.view;

import lotto.common.Messages;
import java.util.List;
import java.util.Map;

import static lotto.common.Messages.STATISTICS_LINE;

public class OutputView {

    public static void printPurchaseCount(int count) {
        System.out.println(String.format(Messages.PURCHASE_COUNT, count));
    }

    public static void printLottos(List<List<Integer>> lottos) {
        lottos.forEach(System.out::println);
    }

    public static void printStatisticsHeader() {
        System.out.println(Messages.STATISTICS_HEADER);
    }

    public static void printStatistics(Map<String, Integer> results) {
        results.forEach((condition, count) ->
                System.out.printf((STATISTICS_LINE) + "%n", condition, count)
        );
    }

    public static void printProfitRate(double profitRate) {
        System.out.println(String.format(Messages.PROFIT_RATE, profitRate));
    }

    public static void printErrorMessage(String message) {
        System.out.println(Messages.ERROR_PREFIX + message);
    }
}