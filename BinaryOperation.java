package expression;

import expression.calculator.Calculator;
import expression.exceptions.CalculateException;
import expression.exceptions.OverflowException;

public abstract class BinaryOperation<T> implements Operand<T> {
    protected final Operand<T> arg1, arg2;
    protected final String operation;
    protected final Calculator<T> calc;

    public BinaryOperation(Operand<T> arg1, Operand<T> arg2, Calculator<T> calc, String operation) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.calc = calc;
        this.operation = operation;
    }

    protected String getOperation() {
        return operation;
    }

    public String toString() {
        return "(" + arg1.toString() + " " + this.getOperation() + " " + arg2.toString() + ")";
    }

    public int hashCode() {
        long hash1 = this.arg1.hashCode();
        long hash2 = this.arg2.hashCode();
        hash1 *= 4e9 + 17;
        hash1 += hash2 * (2e9 + 7);
        hash1 *= getOperation().hashCode();
        hash1 %= 2e9 + 3;
        return (int) hash1;
    }

    protected abstract T f(T x, T y) throws CalculateException;

    public T evaluate(int x) {
        T res = arg1.evaluate(x);
        return f(res, arg2.evaluate(x));
    }

    public T evaluate(int x, int y, int z) {
        T res = arg1.evaluate(x, y, z);
        return f(res, arg2.evaluate(x, y, z));
    }

    protected Operand getArg1() {
        return arg1;
    }

    protected Operand getArg2() {
        return arg2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        BinaryOperation e = (BinaryOperation) obj;
        return this.getArg1().equals(e.getArg1()) && this.getArg2().equals(e.getArg2());
    }
}