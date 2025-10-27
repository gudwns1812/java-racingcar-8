package racingcar.view.reader;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements InputView {


    @Override
    public String readName() {
        return Console.readLine();
    }

    @Override
    public String readMoveCount() {
        return Console.readLine();
    }
}
