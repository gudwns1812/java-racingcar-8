package racingcar.domain.distancestrategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDistanceStrategy implements DistanceStrategy {

    @Override
    public int calculateDistance() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
