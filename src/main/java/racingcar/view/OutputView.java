package racingcar.view;

import java.util.List;
import racingcar.dto.WinnerDto;

public final class OutputView {
    private OutputView() {
    }

    public static void printScreen(List<WinnerDto> dto) {
        System.out.println();
    }
}
