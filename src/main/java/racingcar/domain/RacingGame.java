package racingcar.domain;

import java.util.List;
import racingcar.domain.distance.DistanceStrategy;
import racingcar.dto.RacingResultDto;

public class RacingGame {
    private final List<Participant> participants;
    private int maxDistance;

    RacingGame(List<Participant> participants) {
        this.participants = participants;
    }

    public static RacingGame racingGroupBy(List<String> people, DistanceStrategy distance) {
        List<Participant> participants = people.stream()
                .map(s -> Participant.nameWith(s, distance))
                .toList();
        return new RacingGame(participants);
    }

    public List<RacingResultDto> race() {
        updateDistance();
        return toDtos();
    }

    private void updateDistance() {
        int distance = participants.stream()
                .mapToInt(Participant::move)
                .max()
                .orElse(0);
        maxDistance = Math.max(maxDistance, distance);
    }

    private List<RacingResultDto> toDtos() {
        return participants.stream()
                .map(Participant::toDto)
                .toList();
    }


    public List<RacingResultDto> chooseWinner() {
        return participants.stream()
                .filter(participant -> participant.match(maxDistance))
                .map(Participant::toDto)
                .toList();
    }
}
