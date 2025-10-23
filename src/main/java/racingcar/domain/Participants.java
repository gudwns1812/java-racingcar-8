package racingcar.domain;

import java.util.List;
import racingcar.dto.WinnerDto;
import racingcar.util.Validator;

public class Participants {
    private static final String NAME_DELIMITER = ",";
    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants participate(String people) {
        List<String> peopleNames = List.of(people.split(NAME_DELIMITER));
        validateNameLength(peopleNames);
        List<Participant> participants = peopleNames.stream()
                .map(Participant::nameWith)
                .toList();
        return new Participants(participants);
    }

    private static void validateNameLength(List<String> list) {
        list.forEach(Validator::validateNameLength);
    }

    public List<WinnerDto> compareParticipants(String moveCount) {
        Long maxDistance = participants.stream()
                .map(s -> s.move(moveCount))
                .max(Long::compareTo)
                .orElse(0L);
        return participants.stream()
                .filter(participant -> participant.match(maxDistance))
                .map(Participant::toDto)
                .toList();
    }
}
