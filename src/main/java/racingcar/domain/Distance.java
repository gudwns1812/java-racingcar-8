package racingcar.domain;

import racingcar.domain.distancestrategy.DistanceStrategy;

public class Distance {
    private static final int MOVE_THRESHOLD = 4;

    private final DistanceStrategy distanceStrategy;
    private int totalDistance;

    private Distance(DistanceStrategy distanceStrategy) {
        this.distanceStrategy = distanceStrategy;
    }

    public static Distance createDistanceWith(DistanceStrategy strategy) {
        return new Distance(strategy);
    }

    public void move() {
        int nextMove = distanceStrategy.calculateDistance();

        if (nextMove >= MOVE_THRESHOLD) {
            totalDistance += nextMove;
        }
    }

    public void updateIfGreaterThan(Distance other) {
        if (other.totalDistance > totalDistance) {
            this.totalDistance = other.totalDistance;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Distance distance = (Distance) o;
        return totalDistance == distance.totalDistance;
    }

    int toResultDto() {
        return totalDistance;
    }
}
