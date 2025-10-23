package racingcar.controller;

import racingcar.domain.Participants;
import racingcar.view.InputView;

public class RacingController {

    public RacingController() {
        ;
    }

    public void run() {
        String nameString = InputView.readName();
        Participants participants = Participants.participate(nameString);
    }
}
