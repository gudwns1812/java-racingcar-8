package racingcar.view.printer;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingResultDto;

public abstract class OutputView {

    protected String MiddleResultString(List<RacingResultDto> results) {
        return results.stream()
                .map(dto -> dto.name() + " : " + "-".repeat(dto.distance()))
                .collect(Collectors.joining("\n"));
    }

    protected String WinnerString(List<RacingResultDto> results) {
        return results.stream()
                .map(RacingResultDto::name)
                .collect(Collectors.joining(", "));
    }

    public abstract void printInputNameRequest();
    public abstract void printInputMoveCountRequest();
    public abstract void printNotifyResult();
    public abstract void printMiddleResult(List<RacingResultDto> results);
    public abstract void printWinner(List<RacingResultDto> results);
}
