package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStoreTest {
    @DisplayName("구입 금액에 비례해 로또 장수를 발행한다")
    @Test
    void 로또_발행_개수() {
        List<Lotto> lottos = LottoStore.buyLottos(8000);
        assertThat(lottos).hasSize(8);
    }

    @DisplayName("발행된 각 로또는 1~45의 중복 없는 6개 번호를 가진다")
    @Test
    void 발행된_로또_형식() {
        Lotto lotto = LottoStore.buyLottos(1000).get(0);
        List<Integer> nums = lotto.getNumbers();
        Set<Integer> set = new HashSet<>(nums);

        assertThat(nums).hasSize(6);
        assertThat(set).hasSize(6);
        assertThat(nums).allMatch(n -> n >= 1 && n <= 45);
        assertThat(isSorted(nums)).isTrue();
    }

    @DisplayName("잘못된 금액으로는 발행할 수 없다")
    @Test
    void 잘못된_금액_예외() {
        assertThatThrownBy(() -> LottoStore.buyLottos(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private boolean isSorted(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                return false;
            }
        }
        return true;
    }
}