package calculator;

public abstract class Token {
    public abstract void accept(CalculatorVisitor visitor);
}
