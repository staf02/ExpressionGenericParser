package expression;

import expression.calculator.Calculator;
import expression.exceptions.CalculateException;

public class Min<T> extends BinaryOperation<T> {

    public Min(Operand<T> arg1, Operand<T> arg2, Calculator<T> calc) {
        super(arg1, arg2, calc, "min");
    }

    @Override
    protected T f(T x, T y) throws CalculateException {
        return calc.min(x, y);
    }
}
