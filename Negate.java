package expression;

import expression.calculator.Calculator;
import expression.exceptions.OverflowException;

import java.util.function.BiPredicate;

public class Negate<T> extends UnaryOperation<T> {

    public Negate(Operand arg, Calculator<T> calc) {
        super(arg, calc, "-");
    }

    @Override
    protected T f(T x) {
        return calc.negate(x);
    }
}
