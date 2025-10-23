package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.config.AppConfig;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RacingController controller = appConfig.controller();

        Runtime.getRuntime().addShutdownHook(new Thread(Console::close,"shutdownHook"));

        controller.run();

    }
}
