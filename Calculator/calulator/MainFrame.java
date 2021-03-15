import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.event.*; 
import java.awt.FlowLayout;
import javax.swing.JButton;

public class MainFrame {
	
	JFrame frame;
	DisplayField textField;
	
    public MainFrame() {
    	
    	
    	textField = DisplayField.getInstance();
    	
    	frame = new JFrame("Calculator");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setPreferredSize(new Dimension(380, 600));
	    frame.setLayout(new FlowLayout());
	    
	    frame.getContentPane().add(textField.getTextField());
	    
	
 	
    //	frame.getContentPane().add(new MyButton("AC","clear",170,82).getButton());
    	
    	frame.getContentPane().add(new MyButton("AC","clear").getButton());
		frame.getContentPane().add(new MyButton("H","history").getButton());
		frame.getContentPane().add(new MyButton("C","backspace").getButton());
		frame.getContentPane().add(new MyButton("%","normal").getButton());
	    frame.getContentPane().add(new MyButton("1","normal").getButton());
    	frame.getContentPane().add(new MyButton("2","normal").getButton());
    	frame.getContentPane().add(new MyButton("3","normal").getButton());
     	frame.getContentPane().add(new MyButton("+","normal").getButton());	
    	frame.getContentPane().add(new MyButton("4","normal").getButton());
     	frame.getContentPane().add(new MyButton("5","normal").getButton());	
     	frame.getContentPane().add(new MyButton("6","normal").getButton());
    	frame.getContentPane().add(new MyButton("-","normal").getButton());
    	frame.getContentPane().add(new MyButton("7","normal").getButton());
     	frame.getContentPane().add(new MyButton("8","normal").getButton());	
    	frame.getContentPane().add(new MyButton("9","normal").getButton());
     	frame.getContentPane().add(new MyButton("*","normal").getButton());	
     	frame.getContentPane().add(new MyButton("0","normal").getButton());
    	frame.getContentPane().add(new MyButton(".","normal").getButton());
    	frame.getContentPane().add(new MyButton("=","result").getButton());
     	frame.getContentPane().add(new MyButton("/","normal").getButton());	
    	
     				
    	frame.setResizable(false);
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
    }
    
    public static void main (String[] args) {
	
		new MainFrame();
	
	
	}
    
}