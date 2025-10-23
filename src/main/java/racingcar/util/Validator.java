package racingcar.util;

public final class Validator {
    private Validator() {
    }

    public static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이가 5보다 큽니다");
        }
    }

    public static void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
        }
    }

    public static void validateNumberNegative(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }
}
