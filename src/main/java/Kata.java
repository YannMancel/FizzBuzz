public class Kata {
    public static Object fizzBuzz(int value) {
        return canDisplayFizzBuzz(value)
            ? "FizzBuzz"
            : canDisplayFizz(value)
                ? "Fizz"
                : canDisplayBuzz(value)
                    ? "Buzz"
                    : value;
    }

    public static boolean canDisplayFizzBuzz(int value) {
        return isDivisibleBy3(value) && isDivisibleBy5(value);
    }

    public static boolean canDisplayFizz(int value) {
        return isDivisibleBy3(value) || contains3(value);
    }

    public static boolean canDisplayBuzz(int value) {
        return isDivisibleBy5(value) || contains5(value);
    }

    public static boolean isDivisibleBy3(int value) {
        return value % 3 == 0;
    }

    public static boolean isDivisibleBy5(int value) {
        return value % 5 == 0;
    }

    public static boolean contains3(int value) {
        return String.valueOf(value).contains(String.valueOf(3));
    }

    public static boolean contains5(int value) {
        return String.valueOf(value).contains(String.valueOf(5));
    }
}
