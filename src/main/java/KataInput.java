public record KataInput(Integer input) {

    @Override
    public String toString() {
        return input.toString();
    }

    public boolean isDivisibleBy3() {
        return input % 3 == 0;
    }

    public boolean isDivisibleBy5() {
        return input % 5 == 0;
    }

    public boolean contains3() {
        return String.valueOf(input).contains(String.valueOf(3));
    }

    public boolean contains5() {
        return String.valueOf(input).contains(String.valueOf(5));
    }
}
