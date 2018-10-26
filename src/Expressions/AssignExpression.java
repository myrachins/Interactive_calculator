package Expressions;

import Manage.Jarvis;
import Variables.Variable;

import java.util.Arrays;

public class AssignExpression extends Expression {
    private static final String PATTERN_INT = "\\s*[a-zA-Z]+\\s*=\\s*-?\\d+\\s*";
    private static final String PATTERN_FLOAT = "\\s*[a-zA-Z]+\\s*=\\s*-?\\d+.\\d+\\s*";
    private static final String[] SUITABLE_VAR_NAMES = {"x", "y"};

    @Override
    public boolean isMatch(String line) {
        return line.matches(PATTERN_INT) || line.matches(PATTERN_FLOAT);
    }

    @Override
    public String execute(String line) {
        String trimLine = line.replaceAll("\\s", "");
        String[] tokens = trimLine.split("=");
        String varName = tokens[0];
        String varValue = tokens[1];
        Variable variable = Variable.createVariable(varValue);
        if(variable == null)
            return "Unexpected value";

        if(Jarvis.variables.containsKey(varName)) {
            Jarvis.variables.replace(varName, variable);
        } else {
            boolean isSuitable = Arrays.asList(SUITABLE_VAR_NAMES).contains(varName);
            if(isSuitable) {
                Jarvis.variables.put(varName, variable);
            }
            else {
                System.out.println("Calculator operates only with 'x' and 'y' variable names");
            }
        }

        return "";
    }
}
