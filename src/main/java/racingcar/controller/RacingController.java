package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingResultDto;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final RacingCarService service;

    public RacingController(RacingCarService service) {
        this.service = service;
    }

    public void run() {
        String nameString = InputView.readName();
        String move = InputView.readMoveCount();
        int moveNumber = validateMove(move);
        for (int i = 0; i < moveNumber; i++) {
            List<RacingResultDto> result = service.race(nameString);
            OutputView.printScreen(result);
        }
        OutputView.printScreen(service.chooseWinner());
    }

    private int validateMove(String move) {
        try {
            int moveCount = Integer.parseInt(move);
            validatePositive(moveCount);
            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void validatePositive(int moveCount) {
        if (moveCount <= 0) {
            throw new IllegalArgumentException("0이하는 허용되지 않습니다.");
        }
    }
}
