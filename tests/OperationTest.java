import Operations.*;
import Variables.*;
import org.junit.Assert;
import org.junit.Test;

public class OperationTest {
    @Test
    public void testSumOperation() {
        SumOperation operation = new SumOperation();
        Variable xInt = new IntVariable(10);
        Variable yInt = new IntVariable(20);

        Variable result = operation.execute(xInt, yInt);

        Assert.assertSame(result.getType(), int.class);
        IntVariable intResult = (IntVariable) result;
        Assert.assertEquals(30, intResult.getValue());
    }

    @Test
    public void testMultOperation() {
        MultOperation operation = new MultOperation();
        Variable xInt = new IntVariable(-100);
        Variable yInt = new IntVariable(20);

        Variable result = operation.execute(xInt, yInt);

        Assert.assertSame(result.getType(), int.class);
        IntVariable intResult = (IntVariable) result;
        Assert.assertEquals(-2000, intResult.getValue());
    }

    @Test
    public void testDivOperation() {
        DivOperation operation = new DivOperation();
        Variable xInt = new IntVariable(10);
        Variable yInt = new IntVariable(3);

        Variable result = operation.execute(xInt, yInt);

        Assert.assertSame(result.getType(), int.class);
        IntVariable intResult = (IntVariable) result;
        Assert.assertEquals(3, intResult.getValue());
    }

    @Test
    public void testSubOperation() {
        SubOperation operation = new SubOperation();
        Variable xInt = new IntVariable(-100);
        Variable yInt = new IntVariable(-11);

        Variable result = operation.execute(xInt, yInt);

        Assert.assertSame(result.getType(), int.class);
        IntVariable intResult = (IntVariable) result;
        Assert.assertEquals(-89, intResult.getValue());
    }
}
