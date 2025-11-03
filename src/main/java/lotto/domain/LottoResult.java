package lotto.domain;

import lotto.common.Numbers;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);

    public LottoResult(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        for (Lotto lotto : purchasedLottos) {
            LottoRank rank = winningLotto.match(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
        return ((double) totalPrize / purchaseAmount) * Numbers.PERCENT;
    }
}