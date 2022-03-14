package calculator;

import exceptions.MalformedExpressionException;

public interface Calculator {
    int getResult() throws MalformedExpressionException;
}
