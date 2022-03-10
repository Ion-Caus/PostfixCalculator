public class Operand extends Token {
    public int value;

    public Operand(int value) {
        this.value = value;
    }

    @Override
    public void accept(CalculatorVisitor visitor) {

    }

    public int getValue() {
        return value;
    }
}
