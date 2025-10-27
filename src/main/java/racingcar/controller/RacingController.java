package racingcar.controller;

import racingcar.domain.RacingEntrance;
import racingcar.domain.RacingGame;
import racingcar.view.printer.OutputView;
import racingcar.view.reader.InputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private RacingEntrance entrance;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String nameString = readName();
        int moveNumber = readMoveCount();

        RacingGame racingGame = entrance.createRacingGame(nameString);

        outputView.printNotifyResult();

        for (int i = 0; i < moveNumber; i++) {
            outputView.printMiddleResult(racingGame.race());
        }

        outputView.printWinner(racingGame.chooseWinner());
    }

    private String readName() {
        outputView.printInputNameRequest();
        return inputView.readName();
    }

    private int readMoveCount() {
        outputView.printInputMoveCountRequest();
        String move = inputView.readMoveCount();
        return validateMove(move);
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
