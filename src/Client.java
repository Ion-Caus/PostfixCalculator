import java.util.ArrayList;

public class Client {
    private final CalculatorVisitor calculator;

    public Client() {
        calculator = new CalculatorVisitor();
    }

    public int evaluateExpression(ArrayList<Token> tokenList) {
        return 0;
    }
}
