package racingcar.view.reader;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements InputView {
    private static final String INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MOVE_COUNT = "시도할 횟수는 몇 회인가요?";

    @Override
    public String readName() {
        System.out.println(INPUT_NAME);
        return Console.readLine();
    }

    @Override
    public String readMoveCount() {
        System.out.println(INPUT_MOVE_COUNT);
        return Console.readLine();
    }
}
