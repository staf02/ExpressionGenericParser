package expression.calculator;

public class TCalculator extends UncheckedIntegerCalculator {

    private Integer round(Integer x) {
        return x - x % 10;
    }

    @Override
    public Integer valueOf(int x) {
        return round(x);
    }

    @Override
    protected Integer parse(String str) {
        return valueOf(Integer.parseInt(str));
    }

    @Override
    public Integer add(Integer x, Integer y) {
        return round(x + y);
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        return round(x - y);
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        return round(x * y);
    }

    @Override
    public Integer divide(Integer x, Integer y) {
        return round(x / y);
    }

    @Override
    public Integer negate(Integer x) {
        return -round(x);
    }

    @Override
    public Integer count(Integer x) {
        return round(Integer.bitCount(x));
    }

    @Override
    public Integer max(Integer x, Integer y) {
        return round(Math.max(x, y));
    }

    @Override
    public Integer min(Integer x, Integer y) {
        return round(Math.min(x, y));
    }

    @Override
    public boolean isValidSymbol(char symbol) {
        return Character.isDigit(symbol);
    }
}
