package racingcar.view.printer;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingResultDto;

public abstract class OutputView {

    protected String MiddleResultString(List<RacingResultDto> dtos) {
        return dtos.stream()
                .map(dto -> dto.name() + " : " + "-".repeat(dto.distance()))
                .collect(Collectors.joining("\n"));
    }

    protected String WinnerString(List<RacingResultDto> dtos) {
        return dtos.stream()
                .map(RacingResultDto::name)
                .collect(Collectors.joining(", "));
    }

    public abstract void printInputNameRequest();
    public abstract void printInputMoveCountRequest();
    public abstract void printNotifyRunning();
    public abstract void printMiddleResult(List<RacingResultDto> dtos);
    public abstract void printWinner(List<RacingResultDto> dtos);
}
