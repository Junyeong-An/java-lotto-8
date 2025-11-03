package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    @DisplayName("로또와 당첨 번호 매칭 시 등수 반환")
    @Test
    void 매칭_등수_반환() {
        WinningLotto winning = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(winning.match(new Lotto(List.of(1, 2, 3, 10, 11, 12))))
                .isEqualTo(LottoRank.FIFTH);
        assertThat(winning.match(new Lotto(List.of(1, 2, 3, 4, 5, 40))))
                .isEqualTo(LottoRank.THIRD);
        assertThat(winning.match(new Lotto(List.of(1, 2, 3, 4, 5, 7))))
                .isEqualTo(LottoRank.SECOND);
        assertThat(winning.match(new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isEqualTo(LottoRank.FIRST);
    }
}