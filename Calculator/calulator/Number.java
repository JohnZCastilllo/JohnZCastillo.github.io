import java.math.BigDecimal;
import java.math.MathContext;

public class Number {
    public static  BigDecimal newNumber(String number){
    	return new BigDecimal(number,new MathContext(5));
    }        
}