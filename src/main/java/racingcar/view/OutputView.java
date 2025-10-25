package racingcar.view;

import java.util.List;
import racingcar.dto.RacingResultDto;

public final class OutputView {
    private OutputView() {
    }

    public static void printScreen(List<RacingResultDto> dto) {
        System.out.println();
    }

    public static void printWinner(List<RacingResultDto> dto) {
    }
}
