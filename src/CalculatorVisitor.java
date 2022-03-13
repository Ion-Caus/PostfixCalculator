import dataStructures.LinkedStack;
import exceptions.MalformedExpressionException;

import java.util.EmptyStackException;

public class CalculatorVisitor implements Calculator, Visitor {
    private final LinkedStack<Token> tokenStack;

    public CalculatorVisitor() {
        tokenStack = new LinkedStack<>();
    }

    private void pushOperand(Operand operand) {
        tokenStack.push(operand);
    }

    private void performOperation(Operation operation) throws MalformedExpressionException {
        try {
            Operand right = (Operand) tokenStack.pop();
            Operand left = (Operand) tokenStack.pop();
            Operand result = performCalculation(left, right, operation);

            pushOperand(result);
        } catch (EmptyStackException e) {
            throw new MalformedExpressionException(e.getMessage());
        }
    }

    private Operand performCalculation(Operand left, Operand right, Operation operation) throws MalformedExpressionException {
        int leftValue = left.getValue();
        int rightValue = right.getValue();

        int result;
        switch (operation) {
            case ADD:
                result = leftValue + rightValue;
                break;
            case SUBTRACT:
                result = leftValue - rightValue;
                break;
            case MULTIPLY:
                result = leftValue * rightValue;
                break;
            default:
                throw new MalformedExpressionException("Unknown operation.");
        }
        return new Operand(result);
    }

    @Override
    public int getResult() throws MalformedExpressionException {
        try {
            Operand result = (Operand) tokenStack.pop();

            if (!tokenStack.isEmpty()) {
                throw new MalformedExpressionException("Leftover operands.");
            }
            return result.getValue();
        }
        catch (EmptyStackException e) {
            throw new MalformedExpressionException(e.getMessage());
        }
    }

    @Override
    public void visit(Operand operand) {
        pushOperand(operand);
    }

    @Override
    public void visit(Operator operator) {
        try {
            performOperation(operator.getOperation());
        }
        catch (MalformedExpressionException ignored) {}
    }
}
