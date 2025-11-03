package lotto;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @Test
    void 매칭수_보너스_조합별_등수() {
        assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.valueOf(6, true)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.valueOf(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.valueOf(2, false)).isEqualTo(LottoRank.NONE);
    }
}