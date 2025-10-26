package racingcar.domain;

import java.util.List;
import racingcar.dto.RacingResultDto;

public class RacingGame {
    private final List<Participant> participants;
    private int maxDistance;

    private RacingGame(List<Participant> participants) {
        this.participants = participants;
    }

    public static RacingGame createRacingGame(List<Participant> participants) {
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
