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
        String move = InputView.readName();
        int moveNumber = validateNumber(move);
        List<WinnerDto> result = service.race(nameString, moveNumber);
        OutputView.printScreen(result);
    }

    private int validateNumber(String move) {
        try {
            return Integer.parseInt(move);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
