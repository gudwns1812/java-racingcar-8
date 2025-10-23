package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {

    private static final String INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private InputView() {
    }

    public static String readName() {
        System.out.println(INPUT_NAME);
        return Console.readLine();
    }
}
