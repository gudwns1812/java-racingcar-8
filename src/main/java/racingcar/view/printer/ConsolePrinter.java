package racingcar.view.printer;

import java.util.List;
import racingcar.dto.RacingResultDto;

public class ConsolePrinter implements OutputView {
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String Middle = "실행 결과";
    private static final String INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MOVE_COUNT = "시도할 횟수는 몇 회인가요?";


    @Override
    public void printInputNameRequest() {
        System.out.println(INPUT_NAME);
    }

    @Override
    public void printInputMoveCountRequest() {
        System.out.println(INPUT_MOVE_COUNT);
    }

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
