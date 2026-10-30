package aiwa.controller;

import java.util.Scanner;

public class RestaurantController {

	public static void main(String[] args) {

		Scanner scanInt = new Scanner(System.in);

		System.out.println("🍾🍪🍾🍪🍾🍪🍪");
		System.out.println("**** いらっしゃいませ ****");
		System.out.println("🍾🍪🍾🍪🍾🍪🍪");

		while (true) {

			System.out.println("どちらのメニューを見ますか？");
			System.out.println("1:料理 2:飲み物 0:お会計");

			int menu = scanInt.nextInt();

			if (menu == 1) {

				FoodController fc = new FoodController();
				fc.showMenu();

			} else if (menu == 2) {

				DrinkController dc = new DrinkController();
				dc.showMenu();

			} else if (menu == 0) {

				System.out.println("またお越しくださいませ🙋‍♂️");
				break;
			}

		}
	}
}
