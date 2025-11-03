package lotto.domain;

import lotto.common.Numbers;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static List<Lotto> buyLottos(int purchaseAmount) {
        Validator.validatePurchaseAmount(purchaseAmount);

        int count = purchaseAmount / Numbers.LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.createRandomLotto());
        }
        return lottos;
    }
}