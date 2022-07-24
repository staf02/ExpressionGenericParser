package expression.calculator;

public abstract class AbstractCalculator<T> implements Calculator<T> {
    @Override
    public T valueOf(int x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T valueOf(String str) throws IllegalArgumentException {
        try {
            return parse(str);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid argument: cannot cast " + str + " to required type");
        }
    }

    protected T parse(String str) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T add(T x, T y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T subtract(T x, T y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T multiply(T x, T y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T divide(T x, T y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T negate(T x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T count(T x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T min (T x, T y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T max (T x, T y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isValidSymbol(char symbol) {
        throw new UnsupportedOperationException();
    }
}
