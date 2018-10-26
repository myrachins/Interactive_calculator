package Variables;

import java.lang.reflect.Type;

public abstract class Variable {
    /**
     * This method gets "real" data type of instance.
     * @return 'int', 'float' etc
     */
    public abstract Type getType();

    /**
     * Creates variable from string input
     * @param strNumber String input
     * @return New Variable object or null if its can not be created
     */
    public static Variable createVariable(String strNumber) {
        try {
            int number = Integer.parseInt(strNumber);
            return new IntVariable(number);
        } catch (NumberFormatException exc) { }
        try {
            float number = Float.parseFloat(strNumber);
            return new FloatVariable(number);
        } catch (NumberFormatException exc) { }

        return null;
    }
}
