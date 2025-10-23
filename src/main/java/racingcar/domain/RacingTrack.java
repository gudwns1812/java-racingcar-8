package racingcar.domain;

import java.util.List;
import racingcar.dto.WinnerDto;

public class RacingTrack {
    private Participants participants;

    public void participateBy(Participants participants) {
        this.participants = participants;
    }

    public List<WinnerDto> chooseWinner(String move) {
        return participants.compareParticipants(move);
    }
}
