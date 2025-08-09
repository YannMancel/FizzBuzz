import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
        if (Kata.isDivisibleBy3(input) && Kata.isDivisibleBy5(input)) return "FizzBuzz";
        if (Kata.isDivisibleBy3(input) || Kata.contains3(input)) return "Fizz";
        if (Kata.isDivisibleBy5(input) || Kata.contains5(input)) return "Buzz";
        return input;
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
        final int[] inputs = iterateFrom1To100().toArray();
        final StringBuilder builder = new StringBuilder(inputs.length);
        for (int input : inputs) {
            builder.append(input);
            builder.append(" -> ");
            builder.append(Kata.fizzBuzz(input));
            builder.append("\n");
        }

        assertThat(builder.toString())
            .isNotEmpty()
            .isEqualTo(Kata.compute(inputs));
    }
}
