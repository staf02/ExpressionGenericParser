package expression;

import expression.calculator.Calculator;
import expression.exceptions.CalculateException;

public class Max<T> extends BinaryOperation<T>{
    public Max(Operand<T> arg1, Operand<T> arg2, Calculator<T> calc) {
        super(arg1, arg2, calc, "+");
    }

    @Override
    protected T f(T x, T y) throws CalculateException {
        return calc.max(x, y);
    }
}
