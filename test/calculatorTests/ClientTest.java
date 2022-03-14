package calculatorTests;

import calculator.*;
import exceptions.MalformedExpressionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClientTest {
    private ArrayList<Token> tokenList;
    private Client client;

    @BeforeEach
    void setUp() {
        this.client = new Client();
        this.tokenList = new ArrayList<>();
    }

    @Test
    void evaluateExpressionOneOperator() throws MalformedExpressionException {
        tokenList.add(new Operand(10));
        tokenList.add(new Operand(5));
        tokenList.add(new Operator(Operation.ADD));

        assertEquals(15, client.evaluateExpression(tokenList));
    }

    @Test
    void evaluateExpressionManyOperators() throws MalformedExpressionException {
        tokenList.add(new Operand(10));
        tokenList.add(new Operand(5));
        tokenList.add(new Operator(Operation.ADD));

        tokenList.add(new Operand(2));
        tokenList.add(new Operator(Operation.MULTIPLY));

        assertEquals(30, client.evaluateExpression(tokenList));
    }

    @Test
    void evaluateExpressionExceptionLeftOvers() {
        //leftover
        tokenList.add(new Operand(20));

        tokenList.add(new Operand(10));
        tokenList.add(new Operand(5));
        tokenList.add(new Operator(Operation.ADD));

        assertThrows(
                MalformedExpressionException.class,
                () -> client.evaluateExpression(tokenList)
        );
    }

    @Test
    void evaluateExpressionExceptionBadExpression() {
        tokenList.add(new Operand(20));
        tokenList.add(new Operand(10));

        assertThrows(
                MalformedExpressionException.class,
                () -> client.evaluateExpression(tokenList)
        );
    }

}
