package racingcar.config;

import racingcar.controller.RacingController;

public class AppConfig {

    public RacingController controller() {
        return new RacingController();
    }

}
