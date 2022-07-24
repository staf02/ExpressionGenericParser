package expression;

import expression.calculator.Calculator;
import expression.exceptions.CalculateException;

public class Count<T> extends UnaryOperation<T> {

    public Count(Operand arg, Calculator<T> calc) {
        super(arg, calc, "count");
    }

    @Override
    protected T f(T x) {
        return calc.count(x);
    }
}
