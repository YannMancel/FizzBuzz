import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataTest {

    static Stream<KataInput> iterateFrom1To100() {
        return Stream
                .iterate(1, i -> i + 1)
                .limit(100)
                .map(KataInput::new);
    }

    static Stream<Arguments> iterateArgumentsFrom1To100() {
        return iterateFrom1To100()
                .map(input -> arguments(input, Kata.fizzBuzz(input)));
    }

    String getExpectedOutput(KataInput input) {
        if (input.isDivisibleBy3() && input.isDivisibleBy5()) return "FizzBuzz";
        if (input.isDivisibleBy3() || input.contains3()) return "Fizz";
        if (input.isDivisibleBy5() || input.contains5()) return "Buzz";
        return input.toString();
    }

    @DisplayName(
        "Given input is a number between [1 , 100], " +
        "When fizzbuzz is called, " +
        "Then displays correct output")
    @ParameterizedTest(name = "{index} -> {1}")
    @MethodSource("iterateArgumentsFrom1To100")
    void should_display_correct_output_when_fizzbuzz_is_called(KataInput input, String output) {
        assertThat(input)
                .is(new Condition<>(
                        e -> e.input() >= 1 && e.input() <= 100,
                        "is a number between [1 , 100]"))
                .extracting(this::getExpectedOutput)
                .isEqualTo(output);
    }

    @DisplayName(
        "Given inputs are numbers between [1 , 100], " +
        "When compute is called, " +
        "Then displays correct output")
    @Test
    void should_display_correct_output_when_compute_is_called() {
        final List<KataInput> inputs = iterateFrom1To100().toList();
        final StringBuilder builder = new StringBuilder(inputs.size());
        for (KataInput input : inputs) {
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
