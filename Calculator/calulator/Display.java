
public class Display {
	
	private static String activeText; 
    private static DisplayField displayField;
    private static Display displayInstance;
    private static History history;
    
    private Display(){
    	activeText = "";
    	displayField = DisplayField.getInstance();
    	history = new History();
    }
    
    public static Display getInstance(){
    	if(displayInstance == null){
    		displayInstance = new Display();
    		return displayInstance;
    	}else{
    		return displayInstance;
    	}
    }
    
    public  static void result(){
    	if(activeText.length() > 0){
    			try{
    				history.addToHistory(activeText);
    				Process pr = new Process();
		    		Calculation calcu = new Calculation();
		    		
		    		pr.process(activeText);
		    		activeText = calcu.calculate(pr.getNumbers(),pr.getOperations()); 
		    		display();
		    		pr.clear();
    			}catch(Exception e){
    				activeText = "error";
    				display();
    				System.out.println (e.getMessage());
    			}
    	}else{
    		System.out.println ("result clicked without any inputs");
    	}
    }
    
    public void back(){
    	activeText = history.backHistory();
    	display();
    	
    }
    public static void display(){
    	displayField.display(activeText);
    }
    
    public static void update(String text){
    	activeText += text;
    	display();
    }
    
    public  static void clear(){
    	activeText = "";
    	display();
    }
    
    public  static void bascspace(){
    	if(activeText.length() > 0){
    		activeText = activeText.substring(0,(activeText.length() - 1));
    		display();
    	}else{
    		display();
    		clear();
    	}
    }
}