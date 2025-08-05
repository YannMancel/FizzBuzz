import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    static Stream<Arguments> iterateArgumentsFrom1To100() {
        return IntStream
            .rangeClosed(1, 100)
            .mapToObj((e) -> arguments(e, Kata.fizzBuzz(e)));
    }

    @DisplayName(
        "When input is a number between [1 , 100], " +
        "Should display correct output")
    @ParameterizedTest(name = "{index} -> {1}")
    @MethodSource("iterateArgumentsFrom1To100")
    void should_display_number(int value, Object output) {
        assertThat(value)
            .isBetween(1, 100)
            .extracting((e) -> Kata.isDivisibleBy3(e) && Kata.isDivisibleBy5(e)
                ? "FizzBuzz"
                : Kata.isDivisibleBy3(e) || Kata.contains3(e)
                    ? "Fizz"
                    : Kata.isDivisibleBy5(e) || Kata.contains5(e)
                        ? "Buzz"
                        : e
            )
            .isEqualTo(output);
    }
}