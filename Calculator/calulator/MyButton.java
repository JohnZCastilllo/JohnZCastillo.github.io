import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

public class MyButton {

	JButton button;
	Display display;
	String value;

	public MyButton(String text, Action action, int height, int width) {
		value = text;
		button = new JButton(value);
		button.setPreferredSize(new Dimension(height, width));
		button.setFont(new Font("Arial", Font.PLAIN, 40));
		setEvent(action);
		display = Display.getInstance();
	}

	public MyButton(String text, String action) {
		value = text;
		button = new JButton(value);
		button.setPreferredSize(new Dimension(82, 80));
		button.setFont(new Font("Arial", Font.PLAIN, 40));
		setEvent(action);
		display = Display.getInstance();
	}

	public JButton getButton() {
		return button;
	}

	public void setEvent(Action action) {
		button.addActionListener(() -> action.process());
	}

	public void actionType(String action) {
		switch (action) {
			case "normal":
				display.update(value);
				break;
			case "clear":
				display.clear();
				break;
			case "backspace":
				display.bascspace();
				break;
			case "result":
				display.result();
				break;
			case "history":
				display.back();
				break;
		}
	}
}