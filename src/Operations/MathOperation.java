package Operations;

import Variables.*;

public abstract class MathOperation {
    public abstract String getOperName();

    public abstract Variable execute(IntVariable var1, IntVariable var2);
    public abstract Variable execute(FloatVariable var1, IntVariable var2);
    public abstract Variable execute(IntVariable var1, FloatVariable var2);
    public abstract Variable execute(FloatVariable var1, FloatVariable var2);

    /**
     * Execute specified operation on two given parameters
     * @param var1 Parameter #1
     * @param var2 Parameter #2
     * @return Completed operation
     */
    public Variable execute(Variable var1, Variable var2) {
        if(var1.getType() == int.class && var2.getType() == int.class)
            return execute((IntVariable) var1, (IntVariable) var2);
        if(var1.getType() == float.class && var2.getType() == int.class)
            return execute((FloatVariable) var1, (IntVariable) var2);
        if(var1.getType() == int.class && var2.getType() == float.class)
            return execute((IntVariable) var1, (FloatVariable) var2);
        if(var1.getType() == float.class && var2.getType() == float.class)
            return execute((FloatVariable) var1, (FloatVariable) var2);

        throw new IllegalArgumentException();
    }

    /**
     * Tests is expression contains specified operation
     * @param line Line with expression
     * @return Is Match or not
     */
    public boolean isMatch(String line) {
        return line.contains(getOperName());
    }
}
