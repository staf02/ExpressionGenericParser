package expression;

import expression.calculator.Calculator;

import java.math.BigDecimal;

public class Const<T> implements Operand<T> {
    private T value;

    String constString;

    public Const(String str, Calculator<T> calc) {
        this.value = calc.valueOf(str);
        constString = str;
    }

    public T getValue() {
        return this.value;
    }

    public String toString() {
        return constString;
    }

    public T evaluate(int x) {
        return this.value;
    }

    public T evaluate(int x, int y, int z) {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Const v = (Const) obj;
        return this.toString().equals(v.toString());
    }

    public int hashCode() {
        return this.toString().hashCode();
    }
}
