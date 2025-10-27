package racingcar.domain;

import java.util.List;
import racingcar.dto.RacingResultDto;

public class RacingGame {
    private final List<Participant> participants;
    private final Distance maxDistance;

    private RacingGame(List<Participant> participants) {
        this.participants = participants;
        maxDistance = Distance.DEFAULT;
    }

    public static RacingGame createRacingGame(List<Participant> participants) {
        return new RacingGame(participants);
    }

    public List<RacingResultDto> race() {
        updateDistance();
        return toResultDtoList();
    }

    private void updateDistance() {
        participants.forEach(participant -> {
            participant.move();
            updateMaxDistanceIfLessThan(participant.getDistance());
        });
    }

    private List<RacingResultDto> toResultDtoList() {
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

    private void updateMaxDistanceIfLessThan(Distance otherDistance) {
        maxDistance.updateIfGreaterThan(otherDistance);
    }
}
