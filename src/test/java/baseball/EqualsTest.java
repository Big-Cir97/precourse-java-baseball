package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EqualsTest {

    @Test
    @DisplayName("같은 객체를 equals 비교")
    void equals() {
        Ball ball = new Ball("1");
        Ball ball2 = new Ball("1");

        System.out.println(ball.equals(ball2));
        Assertions.assertThat(ball).isEqualTo(ball2);
    }

    @Test
    @DisplayName("같은 객체를 hashCode 비교")
    void hash() {
        Ball ball = new Ball("1");
        Ball ball2 = new Ball("1");

        System.out.println(ball.hashCode());
        System.out.println(ball2.hashCode());
        Assertions.assertThat(ball.hashCode()).isEqualTo(ball2.hashCode());
    }
}
