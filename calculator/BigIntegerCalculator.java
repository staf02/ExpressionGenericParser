package expression.calculator;

import expression.exceptions.DivisionByZeroException;
import java.math.BigInteger;

public class BigIntegerCalculator extends AbstractCalculator<BigInteger> {
    @Override
    public BigInteger valueOf(int x) {
        return BigInteger.valueOf(x);
    }

    @Override
    protected BigInteger parse(String str) {
        return new BigInteger(str);
    }

    @Override
    public BigInteger add(BigInteger x, BigInteger y) {
        return x.add(y);
    }

    @Override
    public BigInteger subtract(BigInteger x, BigInteger y) {
        return x.subtract(y);
    }

    @Override
    public BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    @Override
    public BigInteger max(BigInteger x, BigInteger y) {
        return x.max(y);
    }

    @Override
    public BigInteger min(BigInteger x, BigInteger y) {
        return x.min(y);
    }

    @Override
    public BigInteger count(BigInteger x) {
        int t = x.bitCount();
        return BigInteger.valueOf(t);
    }

    @Override
    public BigInteger divide(BigInteger x, BigInteger y) {
        if (y.equals(BigInteger.ZERO)) {
            throw new DivisionByZeroException(String.format("Division by zero: %d / %d", x, y));
        }
        return x.divide(y);
    }

    @Override
    public BigInteger negate(BigInteger x) {
        return x.negate();
    }

    @Override
    public boolean isValidSymbol(char symbol) {
        return Character.isDigit(symbol);
    }
}
