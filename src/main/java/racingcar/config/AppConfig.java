package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.domain.RacingEntrance;
import racingcar.domain.distance.RandomDistanceStrategy;
import racingcar.service.RacingCarService;
import racingcar.view.printer.ConsolePrinter;
import racingcar.view.reader.ConsoleReader;

public class AppConfig {

    private RacingCarService service() {
        return new RacingCarService(new RacingEntrance(), new RandomDistanceStrategy());
    }

    public RacingController controller() {
        return new RacingController(service(), new ConsoleReader(), new ConsolePrinter());
    }

}
