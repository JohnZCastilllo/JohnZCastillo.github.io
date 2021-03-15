import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.HashMap;
import java.math.RoundingMode;
import java.math.MathContext;

public class Calculation {
   
    HashMap<String,Integer> mdas;
   
   
   public Calculation(){
   		mdas = new HashMap<>();
   		mdas.put("*",0);
   		mdas.put("/",0);
   		mdas.put("+",1);
   		mdas.put("-",1);
   		mdas.put("%",-1);	
   }
    
    
    public int getValue(String data){
    	return mdas.get(data);
    }
     
   public String calculate(ArrayList<BigDecimal> numbers, ArrayList<String> operations){
   		
   		System.out.println ("received: "+numbers);
   		System.out.println ("received: "+operations);
   		System.out.println (operations);
   		int index = 2;
		
   		BigDecimal temp;
   			
   		ArrayList<BigDecimal> tempNumbers = new ArrayList<>(); 
   		ArrayList<String> tempOperations  = new ArrayList<>();
   			
   		
   		while(operations.size() > 0){
   		
   		
   		int highest = 4;
   		
   		for ( int i = 0; i<operations.size(); i++) {	
			if(getValue(operations.get(i)) <  highest){
				highest = getValue(operations.get(i));
				System.out.println (operations);
				index = i;

			}		
		}
		
			temp = solve(numbers.remove(index),numbers.remove(index),operations.remove(index));
			numbers.add(index,temp);
			
   		}
			System.out.println (numbers);
   			return (numbers.get(0).toString());
   }
   		
   		 
    public BigDecimal solve(BigDecimal x, BigDecimal y,String operation){
    		switch(operation){
    			case "+":
    				return x.add(y);
    			case "-":
    				return  x.subtract(y);
    			case "*":
    				return x.multiply(y);
    			case "/":
    				return x.divide(y,2, RoundingMode.HALF_UP);
    			case "%":
    				BigDecimal temp = x.divide(new BigDecimal(100));
    				System.out.println ("Result: "+temp);
    				return  y.multiply(temp);	
    			default:
    				System.out.println("error");			
    		}
    		
    		return (new BigDecimal("0"));
    }
    
   		
   		
   
   public static void main (String[] args) {
		
		Calculation pemdas = new Calculation();
		
		ArrayList<BigDecimal> num = new ArrayList<>();
		ArrayList<String> operation = new ArrayList<>();
	
	
		num.add(new BigDecimal("0.10"));
		num.add(new BigDecimal("1000"));
	//	num.add(new BigDecimal("2"));		
	//	num.add(new BigDecimal("5"));
	//	num.add(new BigDecimal("8"));
	//	num.add(new BigDecimal("7"));
		
	//	operation.add("+");	
	//	operation.add("*");
	//	operation.add("-");
		operation.add("*");
	//	operation.add("+");
		
		
		//1+4*2-5/8  -> 1 + 8 - 5 / 8
		//1+8-5/8  ->    
		//1+8-1+7
		//9-8
		//
		//9-1
		//8
		
		//1+4*2-5/8
		
		
		//1+4*2-5/8+7
		//1+8-5/8+7
		//1+8-0.625+7
		//9-7.625
		//1.375 -> answer
		
		 
		
		
		// 1 4 2 5
			
		//1+4*2/5
		//4*2/5+1
		
		pemdas.calculate(num,operation);
		
	}
    
}