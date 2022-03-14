package calculatorTests;

import calculator.CalculatorVisitor;
import calculator.Operand;

import exceptions.MalformedExpressionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorVisitorTest {
    private CalculatorVisitor visitor;

    @BeforeEach
    void setUp() {
        visitor = new CalculatorVisitor();
    }

    @Test
    void getResultExceptionEmpty() {
        assertThrows(
                MalformedExpressionException.class,
                () -> visitor.getResult()
        );
    }

    @Test
    void getResult() throws MalformedExpressionException {
        Operand operand = new Operand(3);

        operand.accept(visitor);

        assertEquals(3, visitor.getResult());
    }
}
