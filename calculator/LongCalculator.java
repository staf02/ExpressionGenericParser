package expression.calculator;

public class LongCalculator extends AbstractCalculator<Long> {
    @Override
    public Long valueOf(int x) {
        return Long.valueOf(x);
    }

    @Override
    protected Long parse(String str) {
        return Long.parseLong(str);
    }

    @Override
    public Long add(Long x, Long y) {
        return x + y;
    }

    @Override
    public Long subtract(Long x, Long y) {
        return x - y;
    }

    @Override
    public Long multiply(Long x, Long y) {
        return x * y;
    }

    @Override
    public Long divide(Long x, Long y) {
        return x / y;
    }

    @Override
    public Long negate(Long x) {
        return -x;
    }

    @Override
    public Long max(Long x, Long y) {
        return x > y ? x : y;
    }

    @Override
    public Long min(Long x, Long y) {
        return x < y ? x : y;
    }

    @Override
    public Long count(Long x) {
        return Long.valueOf(Long.bitCount(x.longValue()));
    }

    @Override
    public boolean isValidSymbol(char symbol) {
        return symbol == '.' || Character.isDigit(symbol);
    }
}
