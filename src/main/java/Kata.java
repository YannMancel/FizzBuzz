public class Kata {
    public static Object fizzBuzz(int value) {
        return isFizz(value)
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
