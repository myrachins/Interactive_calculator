package Variables;

import java.lang.reflect.Type;

public class FloatVariable extends Variable {
    private float value;

    public FloatVariable(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public Type getType() {
        return float.class;
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }
}
