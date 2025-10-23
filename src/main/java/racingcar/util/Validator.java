package racingcar.util;

public final class Validator {
    private Validator() {
    }

    public static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이가 5보다 큽니다");
        }
    }
}
