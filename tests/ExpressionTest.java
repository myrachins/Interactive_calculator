import Manage.Jarvis;
import Variables.*;
import Expressions.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ExpressionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final double maxDiffToEqualsFloat = 1e-8;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testAssignNewVariable() {
        String line = "x = 10";
        AssignExpression expression = new AssignExpression();
        Assert.assertTrue(expression.isMatch(line));
        String error = expression.execute(line);
        Assert.assertSame("", error);
        Variable variable = Jarvis.variables.get("x");
        IntVariable intVariable = (IntVariable) variable;
        Assert.assertEquals(10, intVariable.getValue());
    }

    @Test
    public void testAssignReassign() {
        String line1 = "x = 10";
        String line2 = "x = 15.0";
        AssignExpression expression = new AssignExpression();
        expression.execute(line1);
        expression.execute(line2);
        Variable variable = Jarvis.variables.get("x");
        FloatVariable intVariable = (FloatVariable) variable;
        Assert.assertTrue(Math.abs(intVariable.getValue() - 15.0) < maxDiffToEqualsFloat);
    }

    @Test
    public void testAssignFloat() {
        String line = "x = 10.16 ";
        AssignExpression expression = new AssignExpression();
        Assert.assertTrue(expression.isMatch(line));
        expression.execute(line);
        Variable variable = Jarvis.variables.get("x");
        FloatVariable intVariable = (FloatVariable) variable;
        Assert.assertTrue(Math.abs(intVariable.getValue() - 10.16) < 0.001);
    }

    @Test
    public void testFullDivideOperation() {
        String line1 = "x = 10";
        String line2 = "y = 5.0";
        String line3 = "x / y";
        AssignExpression assignExpression = new AssignExpression();
        assignExpression.execute(line1);
        assignExpression.execute(line2);
        OperationExpression operationExpression = new OperationExpression();
        operationExpression.execute(line3);
        Assert.assertEquals("10 / 5.0 = 2.0" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testSmallDivideOperation() {
        String line1 = "x =   100";
        String line2 = "y = 5.0";
        String line3 = " / ";
        AssignExpression assignExpression = new AssignExpression();
        assignExpression.execute(line1);
        assignExpression.execute(line2);
        OperationExpression operationExpression = new OperationExpression();
        operationExpression.execute(line3);
        Assert.assertEquals("100 / 5.0 = 20.0" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testFullMultOperation() {
        String line1 = "x = 30";
        String line2 = "y = 2.0";
        String line3 = "x * y";
        AssignExpression assignExpression = new AssignExpression();
        assignExpression.execute(line1);
        assignExpression.execute(line2);
        OperationExpression operationExpression = new OperationExpression();
        operationExpression.execute(line3);
        Assert.assertEquals("30 * 2.0 = 60.0" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testSmallMultOperation() {
        String line1 = "x =   100";
        String line2 = "y = 3.1";
        String line3 = "* ";
        AssignExpression assignExpression = new AssignExpression();
        assignExpression.execute(line1);
        assignExpression.execute(line2);
        OperationExpression operationExpression = new OperationExpression();
        operationExpression.execute(line3);
        Assert.assertEquals("100 * 3.1 = 310.0" + System.lineSeparator(), outContent.toString());
    }
}
