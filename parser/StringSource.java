package expression.parser;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class StringSource implements CharSource {
    private final String data;
    private int pos;

    public StringSource(final String data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return pos < data.length();
    }

    @Override
    public char next() {
        return data.charAt(pos++);
    }

    @Override
    public IllegalArgumentException error(final String message) {
        return new IllegalArgumentException(pos + ": " + message);
    }

    @Override
    public boolean hasString(String s) {
        int oldPos = pos, sPos = 0;
        for (char c : s.toCharArray()) {
            if (pos - 1 >= data.length() || data.charAt(pos - 1) != c) {
                pos = oldPos;
                return false;
            } else {
                pos++;
            }
        }
        pos = oldPos;
        return true;
    }

    @Override
    public int getPositon() {
        return pos;
    }
}
