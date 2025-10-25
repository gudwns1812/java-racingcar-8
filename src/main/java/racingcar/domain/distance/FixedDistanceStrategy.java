package racingcar.domain.distance;

public class FixedDistanceStrategy extends DistanceStrategy {

    private int fixed;

    public FixedDistanceStrategy(int fixed) {
        this.fixed = fixed;
    }

    @Override
    public int calculateDistance() {
        return fixed;
    }
}
