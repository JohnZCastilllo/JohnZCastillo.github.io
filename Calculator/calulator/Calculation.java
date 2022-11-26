import java.util.ArrayList;
import java.math.BigDecimal;

public class Calculation {

	public String calculate(ArrayList<BigDecimal> numbers, ArrayList<String> operations) {

		int index = 2;

		String temp;
		status(numbers, operations);

		while (operations.size() > 0) {
			int highest = 4;

			for (int i = 0; i < operations.size(); i++) {
				if (Operations.getOrderOfOperation(operations.get(i)) < highest) {
					highest = Operations.getOrderOfOperation(operations.get(i));
					index = i;
				}
			}

			temp = Operations.autoSolve(numbers.remove(index), numbers.remove(index), operations.remove(index))
					.toString();

			if (temp.contains(".")) {

				while (temp.endsWith("0")) {
					temp = temp.substring(0, temp.length() - 1);
				}
			}

			numbers.add(index, Number.newNumber(temp));
			status(numbers, operations);
		}
		return (numbers.get(0).toString());
	}

	public void status(ArrayList<BigDecimal> numbers, ArrayList<String> operations) {
		System.out.println("\n========== Calculation Status =========");
		System.out.println("Operands : " + numbers);
		System.out.println("Operation: " + operations);
		System.out.println("=======================================");
	}

}