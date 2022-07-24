package expression.calculator;

public class DoubleCalculator extends AbstractCalculator<Double> {
    @Override
    public Double valueOf(int x) {
        return (double) x;
    }

    @Override
    protected Double parse(String str) {
        return Double.parseDouble(str);
    }

    @Override
    public Double add(Double x, Double y) {
        return x + y;
    }

    @Override
    public Double subtract(Double x, Double y) {
        return x - y;
    }

    @Override
    public Double multiply(Double x, Double y) {
        return x * y;
    }

    @Override
    public Double divide(Double x, Double y) {
        return x / y;
    }

    @Override
    public Double negate(Double x) {
        return -x;
    }

    @Override
    public Double max(Double x, Double y) {
        return Double.max(x, y);
    }

    @Override
    public Double min(Double x, Double y) {
        return Double.min(x, y);
    }

    @Override
    public Double count(Double x) {
        return (double) Long.bitCount(Double.doubleToLongBits(x));
    }

    @Override
    public boolean isValidSymbol(char symbol) {
        return symbol == '.' || Character.isDigit(symbol);
    }
}
