package racingcar.view.reader;

public abstract class InputView {

    protected static final String INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    protected static final String INPUT_MOVE_COUNT = "시도할 횟수는 몇 회인가요?";

    public abstract String readName();

    public abstract String readMoveCount();
}
