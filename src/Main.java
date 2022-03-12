import exceptions.MalformedExpressionException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Client calculator = new Client();

        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(4));
        tokens.add(new Operand(7));
        tokens.add(new Operator(Operation.MULTIPLY));
        tokens.add(new Operand(20));
        tokens.add(new Operator(Operation.SUBTRACT));

        try {
            int result = calculator.evaluateExpression(tokens);
            System.out.println("The result " + result);
        } catch (MalformedExpressionException e) {
            e.printStackTrace();
        }
    }
}
