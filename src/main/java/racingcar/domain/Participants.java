package racingcar.domain;

import java.util.List;
import racingcar.domain.distance.DistanceStrategy;
import racingcar.dto.RacingResultDto;

public class Participants {
    private final List<Participant> participants;
    private long maxDistance;

    Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants participate(List<String> people, DistanceStrategy distance) {
        List<Participant> participants = people.stream()
                .map(s -> Participant.nameWith(s, distance))
                .toList();
        return new Participants(participants);
    }

    public List<RacingResultDto> race() {
        updateDistance();
        return toDtos();
    }

    private void updateDistance() {
        long distance = participants.stream()
                .mapToLong(Participant::move)
                .max()
                .orElse(0L);
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
