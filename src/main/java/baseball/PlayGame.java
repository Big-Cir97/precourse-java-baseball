package baseball;

public class PlayGame {

    private static final String INPUT_RESTART_NUMBER = "1";

    private final InputView inputView;
    private final OutputView outputView;
    private final Judge judge;

    public PlayGame(InputView inputView, OutputView outputView, Judge juge) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.judge = juge;
    }

    public void startGame() {
        outputView.printStartGameMessage();
        ComputerBaseBall computerBaseBall = initComputer();
        PlayerBaseBall playerBaseBall = initPlayer();
        playGame(computerBaseBall, playerBaseBall);
        // playGame(initComputer(), initPlayer());
    }

    private void playGame(ComputerBaseBall computerBaseBall, PlayerBaseBall playerBaseBall) {
        computerBaseBall.reset();
        judge.init();

        while (!judge.isSuccessed()) {
            outputView.printInputMessage();
            playerBaseBall.update(inputView.inputNumbers());
            JudgeResult jugeResult = judge.inProgress(computerBaseBall, playerBaseBall);

            outputView.printGameResult(jugeResult);
        }
        outputView.printGameSuccessMessage();
        restartGame(inputView.inputRestartOrEndGame());
    }

    private void restartGame(String inputNumber) {
        if (inputNumber.equals(INPUT_RESTART_NUMBER)) {
            playGame(initComputer(), initPlayer());
        }
    }

    private ComputerBaseBall initComputer() {
        return new ComputerBaseBall();
    }

    private PlayerBaseBall initPlayer() {
        return new PlayerBaseBall();
    }
}
