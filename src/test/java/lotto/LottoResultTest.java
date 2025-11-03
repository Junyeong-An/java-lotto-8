package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Percentage.withPercentage;

class LottoResultTest {
    @DisplayName("등수별 결과 집계")
    @Test
    void 결과_집계() {
        WinningLotto winning = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> bought = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)), // FIFTH
                new Lotto(List.of(8, 9, 10, 11, 12, 13)), // NONE
                new Lotto(List.of(1, 2, 3, 4, 5, 7)) // SECOND
        );

        LottoResult result = new LottoResult(bought, winning);
        Map<LottoRank, Integer> map = result.getResult();

        assertThat(map.getOrDefault(LottoRank.FIFTH, 0)).isEqualTo(1);
        assertThat(map.getOrDefault(LottoRank.SECOND, 0)).isEqualTo(1);
        assertThat(map.getOrDefault(LottoRank.NONE, 0)).isEqualTo(1);
    }

    @DisplayName("수익률 계산(소수점 한 자리 반올림은 출력 책임)")
    @Test
    void 수익률_계산() {
        WinningLotto winning = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> bought = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)) // FIFTH(5,000)
        );

        LottoResult result = new LottoResult(bought, winning);
        double profitRate = result.calculateProfitRate(1000);

        assertThat(profitRate).isCloseTo(500.0, withPercentage(0.01));
    }
}