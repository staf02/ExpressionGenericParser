package expression.parser;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */

public class BaseParser {
    private static final char END = '\0';
    private final CharSource source;
    private char ch = 0xffff;

    protected BaseParser(final CharSource source) {
        this.source = source;
        take();
    }

    protected BaseParser() {
        this.source = new StringSource("");
    }

    protected char take() {
        final char result = ch;
        ch = source.hasNext() ? source.next() : END;
        return result;
    }

    protected boolean test(final char expected) {
        return ch == expected;
    }

    protected boolean take(final char expected) {
        if (test(expected)) {
            take();
            return true;
        }
        return false;
    }

    protected void expect(final char expected) {
        if (!take(expected)) {
            throw error("Expected '" + expected + "', found '" + ch + "'");
        }
    }

    protected void expect(final String value) {
        for (final char c : value.toCharArray()) {
            expect(c);
        }
    }

    protected boolean eof() {
        return take(END);
    }

    protected IllegalArgumentException error(final String message) {
        return source.error(message);
    }

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }

    protected void skipWhitespaces() {
        while (Character.isWhitespace(ch)) {
            take();
        };
    }

    protected boolean hasString(String s) {
        return source.hasString(s);
    }

    protected boolean getString(String s) {
        if (hasString(s)) {
            for (int i = 0; i < s.length(); i++) {
                take();
            }
            return true;
        }
        return false;
    }

    protected boolean nextIsDigit() {
        return Character.isDigit(ch);
    }
    protected boolean nextIsWhitespace() {
        return Character.isWhitespace(ch);
    }

    public int getPosition() {
        return source.getPositon();
    }

    public char getCh() {
        return ch;
    }
}
