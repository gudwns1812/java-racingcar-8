package racingcar.domain;

import java.util.List;
import racingcar.domain.distance.DistanceStrategy;
import racingcar.dto.WinnerDto;

public class Participants {
    private final List<Participant> participants;

    Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants participate(List<String> people, DistanceStrategy distance) {
        List<Participant> participants = people.stream()
                .map(s -> Participant.nameWith(s, distance))
                .toList();
        return new Participants(participants);
    }

    public List<WinnerDto> race(int moveCount) {
        validatePositive(moveCount);
        long maxDistance = participants.stream()
                .mapToLong(s -> s.move(moveCount))
                .max()
                .orElse(0L);
        return participants.stream()
                .filter(participant -> participant.match(maxDistance))
                .map(Participant::toDto)
                .toList();
    }

    private void validatePositive(int moveCount) {
        if (moveCount <= 0) {
            throw new IllegalArgumentException("0이하는 허용되지 않습니다.");
        }
    }
}
