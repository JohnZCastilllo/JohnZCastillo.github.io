import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;

public class DisplayField {

	private static JTextField textField;
	private static DisplayField displayField;

	private DisplayField() {
		textField = new JTextField(10);
		textField.setMargin(new Insets(25, 0, 25, 0));
		textField.setEditable(false);
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Arial", Font.PLAIN, 40));
	}

	public static DisplayField getInstance() {

		if (displayField == null) {
			displayField = new DisplayField();
		}

		return displayField;
	}

	public void display(String text) {
		textField.setText(text);
	}

	public JTextField getTextField() {
		return textField;
	}
}