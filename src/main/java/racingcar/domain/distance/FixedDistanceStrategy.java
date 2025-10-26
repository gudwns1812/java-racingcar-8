package racingcar.domain.distance;

public class FixedDistanceStrategy implements DistanceStrategy {

    private final int fixed;

    public FixedDistanceStrategy(int fixed) {
        this.fixed = fixed;
    }

    @Override
    public int calculateDistance() {
        return fixed;
    }
}
