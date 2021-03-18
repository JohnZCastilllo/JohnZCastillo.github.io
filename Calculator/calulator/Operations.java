import java.util.HashMap;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;

public class Operations {
	
	private static  HashMap<String,Integer> operations;
	 
    private  static void intialize() {
    	operations = new HashMap<>();
   		operations.put("x",0);
   		operations.put("/",0);
   		operations.put("+",1);
   		operations.put("-",1);
   		operations.put("%",-1);	
    }
    
    
    public static int getOrderOfOperation(String operation){
    	intialize();
    	return operations.get(operation);
    }
    
    public static BigDecimal add(BigDecimal x, BigDecimal y){
    	return x.add(y);
    }
    
     public static BigDecimal subtract(BigDecimal x, BigDecimal y){
    	return  x.subtract(y);
    }
     public static BigDecimal multiply(BigDecimal x, BigDecimal y){
    	return x.multiply(y);
    }
    public static BigDecimal divide(BigDecimal x, BigDecimal y){
   		 return x.divide(y,100, RoundingMode.HALF_UP);
    }
    public static BigDecimal percent(BigDecimal x, BigDecimal y){
    	BigDecimal temp = x.divide(new BigDecimal(100));
    	return  y.multiply(temp);
    }
    public static BigDecimal autoSolve(BigDecimal x,BigDecimal y,String operation){
    	if(isOperation(operation)){
    		switch(operation){
    			case "+":
    				return add(x,y);
    			case "-":
    				return  subtract(x,y);
    			case "x":
    				return multiply(x,y);
    			case "/":
					return divide(x,y);
    			case "%":
    				return percent(x,y);	
    		}		
    	}
    	return new BigDecimal("0");
    }
    
    public static boolean isOperation(String operation){
    	intialize();
    	return operations.containsKey(operation);
    }
    
    
    
}