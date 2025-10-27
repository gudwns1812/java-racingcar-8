package racingcar.domain.distancestrategy;

public class NoneDistanceStrategy implements DistanceStrategy {
    @Override
    public int calculateDistance() {
        return 0;
    }
}
