package expression.calculator;

public class UncheckedIntegerCalculator extends AbstractCalculator<Integer> {
    @Override
    public Integer valueOf(int x) {
        return x;
    }

    @Override
    protected Integer parse(String str) {
        return valueOf(Integer.parseInt(str));
    }

    @Override
    public Integer add(Integer x, Integer y) {
        return x + y;
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        return x - y;
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        return x * y;
    }

    @Override
    public Integer divide(Integer x, Integer y) {
        return x / y;
    }

    @Override
    public Integer negate(Integer x) {
        return -x;
    }

    @Override
    public Integer count(Integer x) {
        return Integer.bitCount(x);
    }

    @Override
    public Integer max(Integer x, Integer y) {
        return Math.max(x, y);
    }

    @Override
    public Integer min(Integer x, Integer y) {
        return Math.min(x, y);
    }

    @Override
    public boolean isValidSymbol(char symbol) {
        return Character.isDigit(symbol);
    }
}
