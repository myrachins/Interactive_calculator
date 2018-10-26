package Variables;

import java.lang.reflect.Type;

public class IntVariable extends Variable {
    private int value;

    public IntVariable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public Type getType() {
        return int.class;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
