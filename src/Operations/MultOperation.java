package Operations;

import Variables.*;

public class MultOperation extends MathOperation {

    @Override
    public String getOperName() {
        return "*";
    }

    @Override
    public Variable execute(IntVariable var1, IntVariable var2) {
        int value = var1.getValue() * var2.getValue();
        return new IntVariable(value);
    }

    @Override
    public Variable execute(FloatVariable var1, IntVariable var2) {
        float value = var1.getValue() * var2.getValue();
        return new FloatVariable(value);
    }

    @Override
    public Variable execute(IntVariable var1, FloatVariable var2) {
        float value = var1.getValue() * var2.getValue();
        return new FloatVariable(value);
    }

    @Override
    public Variable execute(FloatVariable var1, FloatVariable var2) {
        float value = var1.getValue() * var2.getValue();
        return new FloatVariable(value);
    }
}
