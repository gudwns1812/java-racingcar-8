package racingcar.view.printer;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingResultDto;

public interface OutputView {
    void printNotifyRunning();
    void printMiddleResult(List<RacingResultDto> dtos);
    void printWinner(List<RacingResultDto> dtos);

    default String MiddleResultString(List<RacingResultDto> dtos) {
        return dtos.stream()
                .map(dto -> dto.name() + " : " + "-".repeat(dto.distance()))
                .collect(Collectors.joining("\n"));
    }

    default String WinnerString(List<RacingResultDto> dtos) {
        return dtos.stream()
                .map(RacingResultDto::name)
                .collect(Collectors.joining(", "));
    }
}
