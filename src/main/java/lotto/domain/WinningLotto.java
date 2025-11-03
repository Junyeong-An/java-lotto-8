package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        Validator.validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank match(Lotto lotto) {
        int matchCount = lotto.countMatching(winningNumbers);
        boolean bonusMatch = lotto.contains(bonusNumber);
        return LottoRank.valueOf(matchCount, bonusMatch);
    }
}
