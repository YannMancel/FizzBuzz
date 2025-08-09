import java.util.List;

public class Kata {
    public static String fizzBuzz(KataInput input) {
        if (canDisplayFizzBuzz(input)) return "FizzBuzz";
        if (canDisplayFizz(input)) return "Fizz";
        if (canDisplayBuzz(input)) return "Buzz";
        return input.toString();
    }

    private static boolean canDisplayFizzBuzz(KataInput input) {
        return input.isDivisibleBy3() && input.isDivisibleBy5();
    }

    private static boolean canDisplayFizz(KataInput input) {
        return input.isDivisibleBy3() || input.contains3();
    }

    private static boolean canDisplayBuzz(KataInput input) {
        return input.isDivisibleBy5() || input.contains5();
    }

    public static String compute(List<KataInput> inputs) {
        final StringBuilder builder = new StringBuilder(inputs.size());
        for (KataInput input : inputs) {
            builder.append(input);
            builder.append(" -> ");
            builder.append(fizzBuzz(input));
            builder.append("\n");
        }
        return builder.toString();
    }
}
