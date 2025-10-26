package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.RacingEntrance;
import racingcar.domain.distance.FixedDistanceStrategy;
import racingcar.service.RacingCarService;
import racingcar.view.printer.ConsolePrinter;
import racingcar.view.reader.ConsoleReader;

class RacingControllerTest extends NsTest {

    private RacingController controller;

    @BeforeEach
    void setUp() {
        RacingCarService service = new RacingCarService(new RacingEntrance(), new FixedDistanceStrategy(5));
        controller = new RacingController(service, new ConsoleReader(), new ConsolePrinter());
    }

    @Test
    void 반복회수로_0이하가_오면_예외를_발생시킨다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}