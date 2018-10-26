package Expressions;

import Manage.Jarvis;
import Operations.MathOperation;
import Variables.Variable;

public class OperationExpression extends Expression {
    private final String PATTERN_ADD = "\\s*[a-zA-Z]+\\s*[-+*/]\\s*[a-zA-Z]+\\s*";
    private final String PATTERN_MAIN = "\\s*[-+*/]\\s*";

    @Override
    public boolean isMatch(String line) {
        return line.matches(PATTERN_ADD) || line.matches(PATTERN_MAIN);
    }

    /**
     * Could work with expression like '+' as with 'x + y' expressions
     * @param line input line
     * @return executed value or "" if something happened
     */
    @Override
    public String execute(String line) {
        if(line.matches(PATTERN_MAIN)) {
            // We just transform main case to the more common one
            final String fullLine = String.format("x %s y", line);
            return calculate(fullLine);
        }
        else {
            return calculate(line);
        }
    }

    private String calculate(String line) {
        String trimLine = line.replaceAll("\\s", "");
        String[] tokens = trimLine.split("[-+*/]");
        String operand1 = tokens[0];
        String operand2 = tokens[1];
        if(!Jarvis.variables.containsKey(operand1))
            return String.format("Variable '%s' wasn't declared", operand1);
        if(!Jarvis.variables.containsKey(operand2))
            return String.format("Variable '%s' wasn't declared", operand2);
        Variable var1 = Jarvis.variables.get(operand1);
        Variable var2 = Jarvis.variables.get(operand2);
        for(MathOperation operation : Jarvis.operations) {
            if(operation.isMatch(line)) {
                try {
                    Variable result = operation.execute(var1, var2);
                    String output = String.format("%s %s %s = %s",
                            var1.toString(), operation.getOperName(), var2.toString(), result.toString());
                    System.out.println(output);
                }
                catch (ArithmeticException exc) {
                    System.out.println("Divide by zero is forbidden");
                }
                break;
            }
        }
        return "";
    }
}
