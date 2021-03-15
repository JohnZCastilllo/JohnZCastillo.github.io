import java.util.ArrayList;
import java.math.BigDecimal;

public class Process {
	
	ArrayList<BigDecimal> numbers;
	ArrayList<String> operations;
	int negativePointer;
	
	
    public Process() {
    	numbers = new ArrayList<>();
    	operations = new ArrayList<>();
    }
    
    public void process(String text){
    	String number = "";
    	int start = 0;
    	
    	for (int i = 1; i<=text.length(); i++) {
			String temp = text.substring(start,i);
			System.out.println ("temp "+temp);
			if(isOperation(temp)){
				
				if(temp.equals("-") && number.length() == 0){
					System.out.println ("negative detected");
					number += temp;	
				}else{
		
					System.out.println ("no negative detected: "+number.length());
						numbers.add(Number.newNumber(number));
						operations.add(temp);
						System.out.println ("number added: "+number);
						System.out.println ("number verify: "+numbers);
						temp = "";
						number = "";
				}
			
			}else{
				number += temp;		
			}
			start = i;
		}
		
		numbers.add(Number.newNumber(number));
		number = "";
    }
    
    public boolean isOperation(String text){
    		
    		switch(text){
    			case "+":
    				return true;
    			case "-":
    				return true;
    			case "*":
    				return true;			
				case "/":
    				return true;
    			case "%":
    				return true;	
    		}
    		
    		return false;
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