package racingcar.domain;

import java.util.List;
import racingcar.util.Validator;

public class Participants {
    private static final String NAME_DELIMITER = ",";
    private final List<String> participants;

    private Participants(List<String> participants) {
        validateNameLength(participants);
        this.participants = participants;
    }

    private void validateNameLength(List<String> list) {
        list.forEach(Validator::validateNameLength);
    }

    public static Participants participate(String people) {
        List<String> list = List.of(people.split(NAME_DELIMITER));
        return new Participants(list);
    }
}
