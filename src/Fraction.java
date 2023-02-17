public class Fraction {
    private int Numerator;
    private int Denominator;

    public Fraction(int Numerator, int Denominator) {
        if (Denominator == 0) throw new ArithmeticException("Знаменатель не может быть равен 0");
        this.Numerator = Numerator;
        this.Denominator = Denominator;
    }

    public Fraction() {
        Numerator = 1;
        Denominator = 1;}

    public int GetNumerator() {return Numerator;}
    public int GetDenominator() {return Denominator;}

    public Fraction Summation (Fraction other){
        return Fraction.Summation (this, other);}

    public static Fraction Summation(Fraction first, Fraction second) {
        var newDenominator = first.Denominator * second.Denominator;
        var firstNumerator = first.Numerator * second.Denominator;
        var secondNumerator = second.Numerator * first.Denominator;
        var finalNumerator = firstNumerator + secondNumerator;
        if (first.Numerator==0 && second.Numerator ==0) {return new Fraction(0,newDenominator) ;}
        var finalDenominator = newDenominator;
        return new Fraction(finalNumerator/GreatestCommonDivisor(finalNumerator, finalDenominator), finalDenominator/GreatestCommonDivisor(finalNumerator, finalDenominator));}

    public Fraction Subtraction (Fraction other){
        return Fraction.Subtraction(this, other);}

    public static Fraction Subtraction(Fraction first, Fraction second) {
        var newDenominator = first.Denominator * second.Denominator;
        var firstNumerator = first.Numerator * second.Denominator;
        var secondNumerator = second.Numerator * first.Denominator;
        var finalNumerator = firstNumerator - secondNumerator;
        if ((first.Numerator == 0 && second.Numerator == 0) | finalNumerator == 0) {return new Fraction(0,newDenominator) ;}
        var finalDenominator = newDenominator;
        return new Fraction(finalNumerator/GreatestCommonDivisor(finalNumerator, finalDenominator), finalDenominator/GreatestCommonDivisor(finalNumerator, finalDenominator));

    }
    public Fraction Multiply (Fraction other)
    {return Fraction.Multiply (this, other);}

    public static Fraction Multiply (Fraction first, Fraction second){
        var finalNumerator = first.Numerator*second.Numerator;
        var finalDenominator = first.Denominator*second.Denominator;
        if (first.Numerator ==0 | second.Numerator == 0) {return new Fraction(0,finalDenominator) ;}
        return new Fraction(finalNumerator/GreatestCommonDivisor(finalNumerator, finalDenominator), finalDenominator/GreatestCommonDivisor(finalNumerator, finalDenominator));}

    public Fraction Divide (Fraction other){
        return Fraction.Divide (this, other);}

    public static Fraction Divide (Fraction first, Fraction second){
        if (second.Numerator == 0) throw new ArithmeticException("Знаменатель не может быть равен 0");
        var finalNumerator = first.Numerator*second.Denominator;
        var finalDenominator = first.Denominator*second.Numerator;
        if (first.Numerator == 0) {return new Fraction(0,finalDenominator) ;}
        return new Fraction(finalNumerator/GreatestCommonDivisor(finalNumerator, finalDenominator), finalDenominator/GreatestCommonDivisor(finalNumerator, finalDenominator));}

    private static int GreatestCommonDivisor(int a, int b) {
        do {if (Math.abs(a) > Math.abs(b)) a %= b;
            else b %= a;} while (a != 0 && b != 0);
                return a + b;}


        @Override
    public String toString() {
        return Numerator + "/" + Denominator;
    }
}