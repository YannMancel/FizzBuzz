public class Kata {
    public static Object fizzBuzz(int value) {
        return isFizz(value) && isBuzz(value)
                ? "FizzBuzz"
                : isFizz(value)
                    ? "Fizz"
                    : isBuzz(value)
                        ? "Buzz"
                        : value;
    }

    public static boolean isFizz(int value) {
        return value % 3 == 0;
    }

    public static boolean isBuzz(int value) {
        return value % 5 == 0;
    }
}
