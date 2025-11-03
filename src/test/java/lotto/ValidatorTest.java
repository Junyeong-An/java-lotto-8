package lotto;

import lotto.domain.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    @DisplayName("구입 금액은 1000원 단위가 아니면 예외")
    @Test
    void 금액_단위_검증() {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 파싱 성공")
    @Test
    void 당첨번호_파싱_성공() {
        List<Integer> numbers = Validator.parseNumbers("1,2,3,4,5,6");
        assertThat(numbers).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 번호 파싱 실패(숫자 아님)")
    @Test
    void 당첨번호_파싱_실패_숫자아님() {
        assertThatThrownBy(() -> Validator.parseNumbers("1,2,a,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 검증 - 중복/범위 예외")
    @Test
    void 보너스번호_검증() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> Validator.validateBonusNumber(winning, 3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateBonusNumber(winning, 0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateBonusNumber(winning, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}