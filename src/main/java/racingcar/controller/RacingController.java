package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingResultDto;
import racingcar.service.RacingCarService;
import racingcar.view.reader.InputView;
import racingcar.view.printer.OutputView;

public class RacingController {
    private final RacingCarService service;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(RacingCarService service, InputView inputView, OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String nameString = inputView.readName();
        String move = inputView.readMoveCount();
        int moveNumber = validateMove(move);
        outputView.printNotifyRunning();
        for (int i = 0; i < moveNumber; i++) {
            outputView.printMiddleResult(service.race(nameString));
        }
        outputView.printWinner(service.chooseWinner());
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
