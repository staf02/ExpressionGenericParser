package expression;

import expression.calculator.Calculator;
import expression.exceptions.DivisionByZeroException;
import expression.exceptions.OverflowException;

import java.math.BigDecimal;

public class Divide<T> extends BinaryOperation<T> {

    public Divide(Operand<T> arg1, Operand<T> arg2, Calculator<T> calc) {
        super(arg1, arg2, calc, "/");
    }

    @Override
    protected T f(T x, T y) throws OverflowException, DivisionByZeroException {
        return calc.divide(x, y);
    }
}
