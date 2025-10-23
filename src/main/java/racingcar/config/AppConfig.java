package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.domain.RacingTrack;
import racingcar.service.RacingCarService;

public class AppConfig {
    private RacingTrack track() {
        return new RacingTrack();
    }

    private RacingCarService service() {
        return new RacingCarService(track());
    }

    public RacingController controller() {
        return new RacingController(service());
    }

}
