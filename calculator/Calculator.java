package expression.calculator;

public interface Calculator<T> {
    T valueOf(int x);

    T valueOf(String str) throws IllegalArgumentException;

    T add(T x, T y);

    T subtract(T x, T y);

    T multiply(T x, T y);

    T divide(T x, T y);

    T negate(T x);

    T count(T x);

    T max(T x, T y);

    T min(T x, T y);

    boolean isValidSymbol(char symbol);
}
