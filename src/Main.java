import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Expressions.Expression;
import Manage.Jarvis;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String END_OF_DIALOG = "exit";
    private static final String EMPTY_STRING = "";

    public static void main(String[] args) {
        while (true) {
            System.out.print("> ");
            String line = SCANNER.nextLine();
            if(line.equalsIgnoreCase(END_OF_DIALOG)) {
                GregorianCalendar now = new GregorianCalendar();
                System.out.printf("%d:%d:%d", now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE),
                        now.get(Calendar.SECOND));
                break; // after input 'exit' the program ends
            }
            boolean isExecuted = false; // Has a input line invoked any activity in the program
            for(Expression expression : Jarvis.expressions) {
                if(expression.isMatch(line)) {
                    isExecuted = true;
                    String error = expression.execute(line);
                    if(!error.equals(EMPTY_STRING)) {
                        System.out.println(error);
                    }
                    break; // After executing one expression we don't need to check others
                }
            }
            if(!isExecuted) {
                System.out.println("Unexpected expression. Please rewrite and retry");
            }
        }
    }
}
