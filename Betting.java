import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Betting {
	static Scanner	input	= new Scanner(System.in);
	static int		getBack, forEvery;
	static double	moneyBet, moneyReturn;

	public static void main(String args[]) {
		System.out.println("Please enter odds.\nAmount back: ");
		getBack = input.nextInt();

		System.out.println("For every: ");
		forEvery = input.nextInt();

		System.out.println("How much is the bet?");
		moneyBet = input.nextDouble();

		moneyReturn = bet(getBack, forEvery, moneyBet);

		System.out.println("\nOdds " + getBack + "/" + forEvery + " with a bet of £" + round(moneyBet, 2) + " will win you £" + round(moneyReturn, 2));
		System.out.println("With your initial bet back, total winnings is £" + round(total(moneyReturn, moneyBet), 2));

		input.close();
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public static double bet(int a, int b, double c) {
		moneyReturn = ((c / b) * a) + c;

		return moneyReturn;
	}

	public static double total(double a, double b) {
		moneyReturn = a + b;

		return moneyReturn;
	}
}
