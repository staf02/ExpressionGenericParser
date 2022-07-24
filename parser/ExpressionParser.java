package expression.parser;
import expression.*;
import expression.calculator.Calculator;
import expression.common.Op;
import expression.exceptions.*;

public final class ExpressionParser {

    public static <T> Operand<T> parse(String expression, Calculator<T> calc) throws ParseException {
        return new InnerParser<>(expression, calc).parse();
    }

    private static class InnerParser<T> extends BaseParser {
        private final Calculator<T> calc;

        private InnerParser(String expression, Calculator<T> calc) {
            super(new StringSource(expression));
            this.calc = calc;
        }

        private Operand parse() {
            Operand res = parseMinMax();
            if (!eof()) {
                throw new NotEndOfFileException("Not all string parsed");
            }
            return res;
        }

        private Operand parseMinMax() {
            Operand exp = parseAdditiveGroup();
            while (true) {
                if (getString("min")) {
                    exp = new Min(exp, parseAdditiveGroup(), calc);
                } else if (getString("max")) {
                    exp = new Max(exp, parseAdditiveGroup(), calc);
                } else {
                    return exp;
                }
            }
        }

        private Operand parseAdditiveGroup() {
            Operand exp = parseMultiplicativeGroup();
            while (true) {
                if (take('+')) {
                    exp = new Add(exp, parseMultiplicativeGroup(), calc);
                } else if (take('-')) {
                    exp = new Subtract(exp, parseMultiplicativeGroup(), calc);
                } else {
                    return exp;
                }
            }
        }

        private Operand parseMultiplicativeGroup() {
            Operand exp = parseBasicObject();
            while (true) {
                if (take('*')) {
                    exp = new Multiply(exp, parseBasicObject(), calc);
                } else if (take('/')) {
                    exp = new Divide(exp, parseBasicObject(), calc);
                } else {
                    return exp;
                }
            }
        }

        private Operand parseBasicObject() {
            skipWhitespaces();
            boolean sign = false, constSign = false;
            while (take('-')) {
                if (nextIsDigit()) {
                    constSign = true;
                    break;
                }
                sign ^= true;
                skipWhitespaces();
            }
            Operand res = null;
            if (getString("count")) {
                if (!nextIsWhitespace() && !test('(')) {
                    throw new IllegalSymbolException(String.format("Illegal symbol %c on position %d", take(), getPosition()));
                }
                res = new Count(parseBasicObject(), calc);

            } else if (take('(')) {
                res = parseMinMax();
                if (!take(')')) {
                    throw new BracketBalanceException(String.format("Expected ')' on position %d", getPosition()));
                }
            } else if (nextIsDigit()) {
                res = parseConst(constSign);
            } else if (test('x') || test('y') || test('z')) {
                res = parseVariable();
            }
            if (res == null) {
                throw new IllegalSymbolException(
                    String.format("Illegal symbol %c on position %d", take(), getPosition()));
            }
            if (sign) {
                res = new Negate(res, calc);
            }
            skipWhitespaces();
            return res;
        }

        private Const parseConst(boolean sign) {
            StringBuilder str = new StringBuilder();
            if (sign) {
                str.append("-");
            }
            while (nextIsDigit()) {
                str.append(take());
            }
            return new Const(str.toString(), calc);
        }

        private Variable parseVariable() {
            switch (take()) {
                case 'x':
                    return new Variable("x", calc);
                case 'y':
                    return new Variable("y", calc);
                case 'z':
                    return new Variable("z", calc);
                default:
                    return null;
            }
        }
    }
}
