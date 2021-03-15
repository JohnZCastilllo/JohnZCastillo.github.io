import java.util.ArrayList;

public class History {
	
	ArrayList<String> history;
	
    public History() {
    	history = new ArrayList<>();
    }
    
    public void addToHistory(String text){
    	history.add(text);
    }
    
    public String backHistory(){
    	if(history.size() > 0){
    		return history.remove(history.size()-1);
    	}else{
    		System.out.println ("No More History");
    		return "";
    	}
    }
    
}