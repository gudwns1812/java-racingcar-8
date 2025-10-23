package racingcar.service;

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

    public WinnerDto race(String move) {
        WinnerDto dto = racingTrack.chooseWinner(move);
        return dto;
    }
}
