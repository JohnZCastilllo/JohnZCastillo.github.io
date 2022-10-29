import java.util.ArrayList;
import java.math.BigDecimal;


/*--------------------------------------------------+
 * This class serve as the processor for 			+	
 * the inputed expressions.							+
 * Its main function is to separate operands and 	+
 * operations.										+
 *--------------------------------------------------+
 */
 
public class Process {
	
	ArrayList<BigDecimal> numbers;
	ArrayList<String> operations;

    public Process() {
    	numbers = new ArrayList<>();
    	operations = new ArrayList<>();
    }
    
    /*
     *text  is the raw input text example: 1+2+3.
     *The process method evaluate the text letter by letter 
     *then convert it as a big decimal if it is a number.
     *text is evaluated using substring with two pointers
     *the i in for loop and the variable name start.
     *
     */
     
     
    public void process(String text){
    	String number = "";
    	int start = 0;
    	
    	for (int i = 1; i<=text.length(); i++) {
			String temp = text.substring(start,i);
			if(Operations.isOperation(temp)){
				
				if(temp.equals("-") && number.length() == 0){
					System.out.println ("negative detected!");
					number += temp;
				}else{
						numbers.add(Number.newNumber(number));
						operations.add(temp);
						status();
						temp = "";
						number = "";
				}
			
			}else{
				number += temp;		
			}
			
			start = i;
		}
		
		numbers.add(Number.newNumber(number));
		status();
		number = "";
    }
    
    public void status(){
    	System.out.println ("\n=========== Process Status ============");
    	System.out.println ("Operands : "+numbers);
		System.out.println ("Operation: "+operations);
		System.out.println ("=======================================");
    }
    
    public  ArrayList<BigDecimal> getNumbers(){
    	return numbers;
    }
    
     public  ArrayList<String> getOperations(){
    	return operations;
    }
   	
   	public void clear(){
   		numbers.clear();
   		operations.clear();
   	}
}