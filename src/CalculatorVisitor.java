import DataStructures.LinkedStack;
import Exceptions.MalformedExpressionException;

public class CalculatorVisitor implements Calculator, Visitor {
    private final LinkedStack<Token> tokenStack;

    public CalculatorVisitor() {
        tokenStack = new LinkedStack<>();
    }

    public void pushOperand(Operand operand) {

    }

    public void performOperation(Operation operation) throws MalformedExpressionException {

    }

    @Override
    public int getResult() throws MalformedExpressionException {
        return 0;
    }

    @Override
    public void visit(Operation operation) {

    }

    @Override
    public void visit(Operator operator) {

    }
}
