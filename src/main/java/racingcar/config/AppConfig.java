package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.domain.NameParser;
import racingcar.domain.distance.RandomDistanceStrategy;
import racingcar.service.RacingCarService;

public class AppConfig {

    private RacingCarService service() {
        return new RacingCarService(new NameParser(), new RandomDistanceStrategy());
    }

    public RacingController controller() {
        return new RacingController(service());
    }

}
