package Expressions;

public abstract class Expression {
    /**
     * Checks if line match specified expression
     * @param line Inut line
     * @return is line match expression
     */
    public abstract boolean isMatch(String line);

    /**
     * Executes specified expression by input line
     * @param line input line
     * @return errors, if they occurred or ""
     */
    public abstract String execute(String line);
}
