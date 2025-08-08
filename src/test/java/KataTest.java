import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    static IntStream iterateFrom1To100() {
        return IntStream.rangeClosed(1, 100);
    }

    static Stream<Arguments> iterateArgumentsFrom1To100() {
        return iterateFrom1To100().mapToObj((e) -> arguments(e, Kata.fizzBuzz(e)));
    }

    Object getExpectedOutput(int input) {
        return Kata.isDivisibleBy3(input) && Kata.isDivisibleBy5(input)
            ? "FizzBuzz"
            : Kata.isDivisibleBy3(input) || Kata.contains3(input)
                ? "Fizz"
                : Kata.isDivisibleBy5(input) || Kata.contains5(input)
                    ? "Buzz"
                    : input;
    }

    @DisplayName(
        "Given input is a number between [1 , 100], " +
        "When fizzbuzz is called, " +
        "Then displays correct output")
    @ParameterizedTest(name = "{index} -> {1}")
    @MethodSource("iterateArgumentsFrom1To100")
    void should_display_correct_output_when_fizzbuzz_is_called(int input, Object output) {
        assertThat(input)
            .isBetween(1, 100)
            .extracting(this::getExpectedOutput)
            .isEqualTo(output);
    }

    @DisplayName(
        "Given inputs are numbers between [1 , 100], " +
        "When compute is called, " +
        "Then displays correct output")
    @Test
    void should_display_correct_output_when_compute_is_called() {
        final List<Integer> inputs = iterateFrom1To100()
            .boxed()
            .toList();

        final StringBuilder buffer = new StringBuilder(inputs.size());
        inputs.forEach((input) -> {
            final String line = "input: " + input + " -> output: " + getExpectedOutput(input) + "\n";
            buffer.append(line);
        });

        assertThat(buffer.toString())
            .isNotEmpty()
            .isEqualTo("foo");
    }
}
