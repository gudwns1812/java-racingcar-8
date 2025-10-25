package racingcar.domain.distance;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDistanceStrategy extends DistanceStrategy {

    @Override
    public int calculateDistance() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
