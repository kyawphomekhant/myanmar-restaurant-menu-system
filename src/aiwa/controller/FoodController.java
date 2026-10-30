package aiwa.controller;

import java.util.ArrayList;
import java.util.Scanner;

import aiwa.entity.Food;
import aiwa.model.FoodModel;
import aiwa.view.FoodView;

public class FoodController {

	public void showMenu() {

		Scanner scanInt = new Scanner(System.in);
		Scanner scanStr = new Scanner(System.in);

		FoodModel fm = new FoodModel();
		FoodView fv = new FoodView();

		System.out.println("ミャンマー料理メニュー🍽️🍽️🍽️");

		while (true) {

			System.out.println("---- menu ----");
			System.out.println("1:全部表示 2:キーワード検索 0:終了");

			int menu = scanInt.nextInt();

			if (menu == 1) {

				ArrayList<Food> foods = fm.findAll();

				fv.showList(foods);

			} else if (menu == 2) {

				System.out.println("キーワードを入力してください");

				String word = scanStr.nextLine();

				ArrayList<Food> foods = fm.findByKeyword(word);

				fv.showList(foods);

			} else if (menu == 0) {

				System.out.println("👋");
			}
		}

	}

}
