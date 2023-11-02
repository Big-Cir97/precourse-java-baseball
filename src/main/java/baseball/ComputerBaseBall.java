package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerBaseBall {

    private static final int COMPUTER_NUMBER_SIZE = 3;
    private List<Ball> balls;

    public ComputerBaseBall() {
    }

    public void reset() {
        balls = createBaseBall();
    }

    private List<Ball> createBaseBall() {
        List<Ball> createBalls = new ArrayList<>();
        while (createBalls.size() < COMPUTER_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            Ball createBall = new Ball(String.valueOf(randomNumber));
            if (!createBalls.contains(createBall)) {
                createBalls.add(createBall);
            }
        }
        return createBalls;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public Ball toBall(int index) {
        return balls.get(index);
    }
}
