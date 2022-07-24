package expression;

import expression.calculator.Calculator;
import expression.common.Op;

public abstract class UnaryOperation<T> implements Operand<T> {

    protected final Operand<T> arg;
    private final String operation;
    protected final Calculator<T> calc;

    public UnaryOperation(Operand arg, Calculator<T> calc, String operation) {
        this.arg = arg;
        this.operation = operation;
        this.calc = calc;
    }

    protected abstract T f(T x);

    public T evaluate(int x) {
        return f(arg.evaluate(x));
    }

    public T evaluate(int x, int y, int z) {
        return f(arg.evaluate(x, y, z));
    }

    protected String getOperation() {
        return operation;
    }

    public String toString() {
        return getOperation() + "(" + arg.toString() + ")";
    }
}