package expression;

import expression.calculator.Calculator;
import expression.common.Op;

import java.math.BigDecimal;

public class Variable<T> implements Operand<T> {
    private final String letter;
    private final Calculator<T> calc;


    public Variable(String letter, Calculator<T> calc) {
        this.calc = calc;
        this.letter = letter;
    }

    public T evaluate(int x) {
        return calc.valueOf(x);
    }

    public T evaluate(int x, int y, int z) {
        if (letter.equals("y"))
            return calc.valueOf(y);
        if (letter.equals("z"))
            return calc.valueOf(z);
        return calc.valueOf(x);
    }

    public String getLetter() {
        return this.letter;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Variable v = (Variable) obj;
        return this.getLetter().equals(v.getLetter());
    }

    public String toString() {
        return letter;
    }


    public int hashCode() {
        return this.getLetter().hashCode();
    }
}