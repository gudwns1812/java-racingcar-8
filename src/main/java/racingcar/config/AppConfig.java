package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.domain.RacingEntrance;
import racingcar.view.printer.ConsolePrinter;
import racingcar.view.reader.ConsoleReader;

public class AppConfig {
    public RacingEntrance entrance() {
       return new RacingEntrance();
    }

    public RacingController controller() {
        return new RacingController(entrance(), new ConsoleReader(), new ConsolePrinter());
    }
}
