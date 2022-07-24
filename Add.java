package expression;

import expression.calculator.Calculator;
import expression.exceptions.OverflowException;

import java.math.BigDecimal;
import java.util.*;

public class Add<T> extends BinaryOperation<T> {

    public Add(Operand arg1, Operand arg2, Calculator<T> calc) {
        super(arg1, arg2, calc, "+");
    }

    @Override
    protected T f(T x, T y) throws OverflowException {
        return calc.add(x, y);
    }
}