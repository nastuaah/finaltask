public class Main {
    public static void main(String[] args) {
        var Fraction1 = new Fraction(1, 20);
        var Fraction2 = new Fraction (1,20);
        var resultSummation = Fraction1.Summation(Fraction2);
        var resultSubtraction = Fraction1.Subtraction(Fraction2);
        var resultMultiply = Fraction1.Multiply(Fraction2);
        var resultDivide = Fraction1.Divide(Fraction2);
        System.out.print("Сумма дробей ");
        System.out.println(resultSummation);
        System.out.print("Разность дробей ");
        System.out.println(resultSubtraction);
        System.out.print("Умножение дробей ");
        System.out.println(resultMultiply);
        System.out.print("Деление дробей ");
        System.out.println(resultDivide);

    }
}