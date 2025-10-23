package racingcar.controller;

import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.dto.WinnerDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final RacingCarService service;

    public RacingController(RacingCarService service) {
        this.service = service;
    }

    public void run() {
        String nameString = InputView.readName();
        service.setUpTrack(nameString);
        String move = InputView.readName();
        List<WinnerDto> result = service.race(move);
        OutputView.printScreen(result);
    }
}
