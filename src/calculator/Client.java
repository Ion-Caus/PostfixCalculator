package calculator;

import exceptions.MalformedExpressionException;

import java.util.ArrayList;

public class Client {
    private final CalculatorVisitor calculator;

    public Client() {
        calculator = new CalculatorVisitor();
    }

    public int evaluateExpression(ArrayList<Token> tokenList) throws MalformedExpressionException {
        for (Token token : tokenList) {
            token.accept(calculator);
        }
        return calculator.getResult();
    }
}
