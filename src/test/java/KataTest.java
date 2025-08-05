import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class KataTest {

    static IntStream iterateFrom1To100() {
        return IntStream.iterate(1, (previous) -> previous + 1).limit(100);
    }

    @DisplayName("For a number between [1 , 100]")
    @ParameterizedTest(name = "{index} -> Should display correct output")
    @MethodSource("iterateFrom1To100")
    void should_display_number(int value) {
        assertThat(value)
                .isBetween(1, 100)
                .extracting((e) -> e % 3 == 0
                        ? "Fizz"
                        : e % 5 == 0
                            ? "Buzz"
                            : e)
                .isEqualTo(Kata.fizzBuzz(value));
    }
}