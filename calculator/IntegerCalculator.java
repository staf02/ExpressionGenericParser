package expression.calculator;

import expression.exceptions.*;

public class IntegerCalculator extends UncheckedIntegerCalculator {
    @Override
    public Integer add(Integer x, Integer y) throws OverflowException{
        if (y < 0 && x < Integer.MIN_VALUE - y) {
            throw new OverflowException(String.format("%d + %d is less than %d", x, y, Integer.MIN_VALUE));
        } else if (y > 0 && x > Integer.MAX_VALUE - y) {
            throw new OverflowException(String.format("%d + %d is more than %d", x, y, Integer.MAX_VALUE));
        }
        return x + y;
    }

    @Override
    public Integer subtract(Integer x, Integer y) throws OverflowException {
        if (y > 0 && x < Integer.MIN_VALUE + y) {
            throw new OverflowException(String.format("%d - %d is less than %d", x, y, Integer.MIN_VALUE));
        } else if (y < 0 && x > Integer.MAX_VALUE + y) {
            throw new OverflowException(String.format("%d - %d is more than %d", x, y, Integer.MAX_VALUE));
        }
        return x - y;
    }

    @Override
    public Integer multiply(Integer x, Integer y) throws OverflowException {
        if (x == 0 || y == 0) {
            return 0;
        }
        if (x == -1 || y == -1) {
            return x == -1 ? negate(y) : negate(x);
        }
        if (y < 0) {
            if (x < Integer.MAX_VALUE / y || x > Integer.MIN_VALUE / y) {
                throw new OverflowException(String.format("%d * %d is too big or too less for int", x, y));
            }
        } else {
            if (x > Integer.MAX_VALUE / y || x < Integer.MIN_VALUE / y) {
                throw new OverflowException(String.format("%d * %d is too big or too less for int", x, y));
            }
        }
        return x * y;
    }

    @Override
    public Integer divide(Integer x, Integer y) throws OverflowException, DivisionByZeroException{
        if (y == 0) {
            throw new DivisionByZeroException("Division by zero");
        }
        else if (y == -1) {
            return negate(x);
        }
        return x / y;
    }

    @Override
    public Integer negate(Integer x) throws OverflowException {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException(String.format("Overflow: -(%d) is greater than Integer.MAX_VALUE", x));
        }
        return -x;
    }

    private Integer abs(Integer x) {
        return x < 0 ? negate(x) : x;
    }

    @Override
    public Integer count(Integer x) {
        return Integer.bitCount(x);
    }

    @Override
    public Integer min(Integer x, Integer y) {
        return x < y ? x : y;
    }

    @Override
    public Integer max(Integer x, Integer y) {
        return x > y ? x : y;
    }
}
