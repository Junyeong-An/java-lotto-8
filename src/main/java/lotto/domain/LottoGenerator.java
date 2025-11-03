package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.Numbers;
import java.util.List;

public class LottoGenerator {

    private LottoGenerator() {
    }

    public static Lotto createRandomLotto() {
        List<Integer> numbers = Randoms
                .pickUniqueNumbersInRange(Numbers.MIN_NUMBER, Numbers.MAX_NUMBER, Numbers.LOTTO_SIZE)
                .stream()
                .sorted()
                .toList();
        return new Lotto(numbers);
    }
}