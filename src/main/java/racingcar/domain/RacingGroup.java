package racingcar.domain;

import java.util.List;
import racingcar.domain.distance.DistanceStrategy;
import racingcar.dto.RacingResultDto;

public class RacingGroup {
    private final List<Participant> participants;
    private int maxDistance;

    RacingGroup(List<Participant> participants) {
        this.participants = participants;
    }

    public static RacingGroup participate(List<String> people, DistanceStrategy distance) {
        List<Participant> participants = people.stream()
                .map(s -> Participant.nameWith(s, distance))
                .toList();
        return new RacingGroup(participants);
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
        if (maxDistance < distance) {
            maxDistance = distance;
        }
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
