import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;


public class Calculator {
    public static Fraction Evaluate(String equation) {
        var tokens = ParseTokens(equation);
        return EvaluateTokens(tokens);
    }

    private static ArrayList<Token> ParseTokens(String equation) {
        var parts = equation.split(" ");
        var tokens = new ArrayList<Token>(parts.length);
        for (var part: parts) {
            switch (part) {
                case "+" -> tokens.add(new Token(Operation.Summation));
                case "-" -> tokens.add(new Token(Operation.Subtraction));
                case "*" -> tokens.add(new Token(Operation.Multiply));
                case "/" -> tokens.add(new Token(Operation.Divide));
                case "(" -> tokens.add(new Token(Operation.OpenBracket));
                case ")" -> tokens.add(new Token(Operation.CloseBracket));
                default -> {
                    var fractionParts = part.split("/");
                    tokens.add(new Token(new Fraction(Integer.parseInt(fractionParts[0]), Integer.parseInt(fractionParts[1]))));
                }
            }
        }
        return tokens;
    }

    private static Fraction EvaluateTokens(ArrayList<Token> tokens) {
        var operators = new Stack<Operation>();
        var reversePolishNotation = new ArrayDeque<Token>();
        for (var token: tokens) {
            if (token.GetTokenType() == TokenType.Number) {
                reversePolishNotation.addLast(token);
                continue;
            }
            switch (token.GetOperation()) {
                case Summation, Subtraction -> {
                    while (!operators.empty() && operators.peek() != Operation.OpenBracket)
                        reversePolishNotation.addLast(new Token(operators.pop()));
                    operators.push(token.GetOperation());
                }
                case OpenBracket -> operators.push(token.GetOperation());
                case CloseBracket -> {
                    while (operators.peek() != Operation.OpenBracket)
                        reversePolishNotation.addLast(new Token(operators.pop()));
                    operators.pop();
                }
                case Divide, Multiply -> {
                    while (!operators.empty() && operators.peek() != Operation.OpenBracket && operators.peek().GetPriority().equals(token.GetOperation().GetPriority()))
                        reversePolishNotation.addLast(new Token(operators.pop()));
                    operators.push(token.GetOperation());
                }
            }
        }
        while (!operators.empty()) reversePolishNotation.addLast(new Token(operators.pop()));
        var solution = new Stack<Token>();
        while (!reversePolishNotation.isEmpty()) {
            var cur = reversePolishNotation.pop();
            if (cur.GetTokenType() == TokenType.Number) {
                solution.push(cur);
                continue;
            }
            var first = solution.pop();
            var second = solution.pop();
            Fraction res = switch (cur.GetOperation()) {
                case Summation -> first.GetNumber().Summation(second.GetNumber());
                case Subtraction -> second.GetNumber().Subtraction(first.GetNumber());
                case Multiply -> first.GetNumber().Multiply(second.GetNumber());
                case Divide -> second.GetNumber().Divide(first.GetNumber());
                default -> null;
            };
            solution.push(new Token(res));
        }
        return solution.pop().GetNumber();
    }
}