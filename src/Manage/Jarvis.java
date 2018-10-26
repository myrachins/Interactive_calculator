package Manage;

import java.util.ArrayList;
import java.util.HashMap;

import Expressions.*;
import Operations.*;
import Variables.*;

public class Jarvis {
    /**
     * All variables of executing program
     */
    public static HashMap<String, Variable> variables = new HashMap<>();
    /**
     * All operations, that support program
     */
    public static ArrayList<MathOperation> operations = new ArrayList<>();
    /**
     * All expressions, that support program to input from shell
     */
    public static ArrayList<Expression> expressions = new ArrayList<>();

    static {
        operations.add(new SumOperation());
        operations.add(new SubOperation());
        operations.add(new MultOperation());
        operations.add(new DivOperation());

        expressions.add(new AssignExpression());
        expressions.add(new OperationExpression());
    }


}
