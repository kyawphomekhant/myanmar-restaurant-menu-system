package aiwa.controller;

import java.util.ArrayList;
import java.util.Scanner;

import aiwa.entity.Drink;
import aiwa.model.DrinkModel;
import aiwa.view.DrinkView;

public class DrinkController {

	public void showMenu() {

		Scanner scanInt = new Scanner(System.in);

		DrinkModel dm = new DrinkModel();
		DrinkView dv = new DrinkView();

		System.out.println("🍹🍹🍹🍹🍹🍹🍹🍹");
		System.out.println("**** 飲み物 ****");
		System.out.println("🍹🍹🍹🍹🍹🍹🍹🍹");

		while (true) {

			System.out.println("1:ソフトドリンク 2:アルコール・お酒 0:終了");

			int menu = scanInt.nextInt();

			if (menu == 1) {

				ArrayList<Drink> drinks = dm.findByType(1);
				dv.showList(drinks);

			} else if (menu == 2) {

				ArrayList<Drink> drinks = dm.findByType(2);
				dv.showList(drinks);

			} else if (menu == 0) {

				System.out.println("🍋‍🟩");
				break;
			}

		}
	}
}
