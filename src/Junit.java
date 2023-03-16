import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Junit {
    @Test
    public void summationIsCorrectWhenSimpleExampleIsGiven (){
        assertEquals("5/6", Calculator.Evaluate("1/2 + 1/3").toString(), "Summation is done incorrectly"); }

    @Test
    public void subtractionIsCorrectWhenSimpleExampleIsGiven (){
        assertEquals("-13/24", Calculator.Evaluate("1/8 - 2/3").toString(), "Substation is done incorrectly"); }

    @Test
    public void multiplyIsCorrectWhenSimpleExampleIsGiven (){
        assertEquals("2/27", Calculator.Evaluate("4/9 * 3/18").toString(), "Multiply is done incorrectly"); }

    @Test
    public void divideIsCorrectWhenSimpleExampleIsGiven (){
        assertEquals("15/28", Calculator.Evaluate("5/8 / 7/6").toString(), "Divide is done incorrectly"); }

    @Test
    public void operationWithSamePrioritiesAreCorrectWhenSimpleExampleIsGiven (){
        assertEquals("29/72", Calculator.Evaluate("5/8 - 2/3 + 4/9").toString(), "Calculator works incorrectly"); }

    @Test
    public void operationWithDifferentPrioritiesAreCorrectWhenSimpleExampleIsGiven1 (){
        assertEquals("25/36", Calculator.Evaluate("4/9 + 7/8 * 2/7").toString(), "Calculator works incorrectly");}

    @Test
        public void operationWithDifferentPrioritiesAreCorrectWhenSimpleExampleIsGiven2 (){
        assertEquals("-7/72", Calculator.Evaluate("4/6 / 12/5 - 3/8").toString(), "Calculator works incorrectly" );}

    @Test
    public void operationWithDifferentPrioritiesAreCorrectWhenSimpleExampleIsGiven3 (){
        assertEquals("-144/145", Calculator.Evaluate("2/5 / ( 3/8 - 7/9 )").toString(), "Calculator works incorrectly" );}

    @Test
    public void operationIsIncorrectWhenInvalidSymbolsAreEntered () {
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
            throw new ArithmeticException("1/2 = 1/3");});
        assertNotEquals("1/2 + 1/3", exception.getMessage());}

    @Test
    public void operationIsIncorrectWhenInvalidNotNumbersAreEntered () {
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
            throw new ArithmeticException("a/b + 1/3");});
        assertNotEquals("1/2 + 1/3", exception.getMessage());}

    @Test
    @DisplayName("Division by Zero")
    public void whenDivisionByZeroShouldThrowArithmeticException (){
        assertThrows(ArithmeticException.class, ()-> {
            Calculator.Evaluate("2/0 - 3/7");
        });}
}



