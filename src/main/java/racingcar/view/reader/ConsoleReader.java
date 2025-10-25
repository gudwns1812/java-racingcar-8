package racingcar.view.reader;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader extends InputView {
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
