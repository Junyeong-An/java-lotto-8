package lotto.domain;

import lotto.common.Messages;
import lotto.common.Numbers;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Numbers.LOTTO_SIZE) {
            throw new IllegalArgumentException(Messages.ERROR_LOTTO_SIZE);
        }
        if (numbers.stream().distinct().count() != Numbers.LOTTO_SIZE) {
            throw new IllegalArgumentException(Messages.ERROR_LOTTO_DUPLICATE);
        }
        boolean invalid = numbers.stream()
                .anyMatch(n -> n < Numbers.MIN_NUMBER || n > Numbers.MAX_NUMBER);
        if (invalid) {
            throw new IllegalArgumentException(Messages.ERROR_NUMBER_RANGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatching(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}