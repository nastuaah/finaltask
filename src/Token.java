public class Token { private final TokenType Type;
    private final Fraction Number;
    private final Operation Operation;

    public Token(Operation operation) {
        Type = TokenType.Operator;
        Operation = operation;
        Number = null;
    }
    public Token(Fraction number) {
        Type = TokenType.Number;
        Number = number;
        Operation = null;
    }
    public TokenType GetTokenType() {
        return Type;
    }
    public Fraction GetNumber() {
        if (Number == null) {
            throw new RuntimeException("This token is an operator");
        }
        return Number;
    }
    public Operation GetOperation() {
        if (Operation == null) {
            throw new RuntimeException("This token is a number");
        }
        return Operation;
    }
}

enum TokenType {
    Number,
    Operator
}
