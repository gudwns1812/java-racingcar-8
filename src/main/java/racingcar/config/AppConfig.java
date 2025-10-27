package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.view.printer.ConsolePrinter;
import racingcar.view.reader.ConsoleReader;

public class AppConfig {

    public RacingController controller() {
        return new RacingController(new ConsoleReader(), new ConsolePrinter());
    }

}
