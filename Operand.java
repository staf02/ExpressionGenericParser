package expression;

public interface Operand<T> {
    T evaluate(int x);
    T evaluate(int x, int y, int z);
    String toString();
}
