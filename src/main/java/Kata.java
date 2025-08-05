public class Kata {
    public static Object fizzBuzz(int value) {
        return canReturnValue(value)
            ? value
            : "%s%s".formatted(
                canDisplayFizz(value) ? "Fizz" : "",
                canDisplayBuzz(value) ? "Buzz" : "");
    }

    public static boolean canReturnValue(int value) {
        return !isDivisibleBy3(value) && !isDivisibleBy5(value);
    }

    public static boolean canDisplayFizz(int value) {
        return isDivisibleBy3(value);
    }

    public static boolean canDisplayBuzz(int value) {
        return isDivisibleBy5(value);
    }

    public static boolean isDivisibleBy3(int value) {
        return value % 3 == 0;
    }

    public static boolean isDivisibleBy5(int value) {
        return value % 5 == 0;
    }
}
