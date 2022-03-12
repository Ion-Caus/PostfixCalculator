public abstract class Token {
    private CalculatorVisitor calculatorVisitor;

    public abstract void accept(CalculatorVisitor visitor);
}
