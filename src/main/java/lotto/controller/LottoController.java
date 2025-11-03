package lotto.controller;

import lotto.common.Messages;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {

    public void run() {
        int purchaseAmount = readPurchaseAmount();
        List<Lotto> lottos = LottoStore.buyLottos(purchaseAmount);

        OutputView.printPurchaseCount(lottos.size());
        printLottos(lottos);

        List<Integer> winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber(winningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoResult result = new LottoResult(lottos, winningLotto);

        OutputView.printStatisticsHeader();
        OutputView.printStatistics(toDisplayMap(result.getResult()));
        OutputView.printProfitRate(result.calculateProfitRate(purchaseAmount));
    }

    private int readPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.readPurchaseAmount();
                int amount = Integer.parseInt(input.trim());
                Validator.validatePurchaseAmount(amount);
                return amount;
            } catch (NumberFormatException e) {
                System.out.println(Messages.ERROR_AMOUNT_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> readWinningNumbers() {
        while (true) {
            try {
                String input = InputView.readWinningNumbers();
                return Validator.parseNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int readBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String input = InputView.readBonusNumber();
                int bonus = Integer.parseInt(input.trim());
                Validator.validateBonusNumber(winningNumbers, bonus);
                return bonus;
            } catch (NumberFormatException e) {
                System.out.println(Messages.ERROR_NUMBER_ONLY);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLottos(List<Lotto> lottos) {
        List<List<Integer>> numbers = lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
        OutputView.printLottos(numbers);
    }

    private Map<String, Integer> toDisplayMap(Map<LottoRank, Integer> result) {
        Map<String, Integer> ordered = new LinkedHashMap<>();
        put(ordered, result, LottoRank.FIFTH);
        put(ordered, result, LottoRank.FOURTH);
        put(ordered, result, LottoRank.THIRD);
        put(ordered, result, LottoRank.SECOND);
        put(ordered, result, LottoRank.FIRST);
        return ordered;
    }

    private void put(Map<String, Integer> out, Map<LottoRank, Integer> src, LottoRank rank) {
        String key = rank.getDisplayName();
        if (key == null) {
            return;
        }
        out.put(key, src.getOrDefault(rank, 0));
    }
}