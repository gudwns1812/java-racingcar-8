package racingcar.view.printer;

import java.util.List;
import racingcar.dto.RacingResultDto;

public class ConsolePrinter implements OutputView {
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String Middle = "실행 결과";


    @Override
    public void printNotifyRunning() {
        System.out.println();
        System.out.println(Middle);
    }

    @Override
    public void printMiddleResult(List<RacingResultDto> dtos) {
        System.out.println(MiddleResultString(dtos));
        System.out.println();
    }

    @Override
    public void printWinner(List<RacingResultDto> dtos) {
        System.out.println(FINAL_WINNER + WinnerString(dtos));
    }
}
