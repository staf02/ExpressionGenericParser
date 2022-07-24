package expression.parser;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface CharSource {
    boolean hasNext();
    char next();
    IllegalArgumentException error(final String message);
    boolean hasString(String s);
    int getPositon();
}
