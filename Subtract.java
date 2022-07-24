package expression;

import expression.calculator.Calculator;
import expression.exceptions.CalculateException;
import expression.exceptions.OverflowException;

import java.math.BigDecimal;

public class Subtract<T> extends BinaryOperation<T> {

    public Subtract(Operand<T> arg1, Operand<T> arg2, Calculator<T> calc) {
        super(arg1, arg2, calc, "-");
    }

    @Override
    protected T f(T x, T y) throws CalculateException {
        return calc.subtract(x, y);
    }
}
