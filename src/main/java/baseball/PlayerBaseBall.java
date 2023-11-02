package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerBaseBall {
    private List<Ball> balls;

    public PlayerBaseBall() {
        this.balls = new ArrayList<>();
    }

    public PlayerBaseBall(List<Ball> balls) {
        this.balls = balls;
    }

    public void update(String numbers) {
        this.balls = createBaseBall(numbers);
    }

    private List<Ball> createBaseBall(String numbers) {
        return Arrays.stream(numbers.split(""))
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public Ball toBall(int index) {
        return balls.get(index);
    }
}
