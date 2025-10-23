package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;
import racingcar.util.Validator;

public class Distance {
    private int count;

    public Distance(String moveNumber) {
        Validator.validateNumber(moveNumber);
        int count = Integer.parseInt(moveNumber);
        Validator.validateNumberNegative(count);
        this.count = count;
    }

    public long calculateDistance() {
        return IntStream.rangeClosed(0, count)
                .mapToLong(i -> Randoms.pickNumberInRange(0, 9))
                .sum();
    }
}
