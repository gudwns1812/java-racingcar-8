package racingcar.service;

import java.util.List;
import racingcar.domain.Participants;
import racingcar.domain.RacingTrack;
import racingcar.dto.WinnerDto;

public class RacingCarService {

    private final RacingTrack racingTrack;

    public RacingCarService(RacingTrack racingTrack) {
        this.racingTrack = racingTrack;
    }

    public void setUpTrack(String nameString) {
        Participants participants = Participants.participate(nameString);
        racingTrack.participateBy(participants);
    }

    public List<WinnerDto> race(String move) {
        return racingTrack.chooseWinner(move);
    }
}
