package racingcar.controller;

import racingcar.domain.Participants;
import racingcar.domain.RacingTrack;
import racingcar.view.InputView;

public class RacingController {

    public RacingController() {
    }

    public void run() {
        String nameString = InputView.readName();
        Participants participants = Participants.participate(nameString);
        RacingTrack.participateBy(participants);
        String move = InputView.readName();
    }
}
