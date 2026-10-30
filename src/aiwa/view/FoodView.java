
package aiwa.view;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import aiwa.entity.Food;

public class FoodView {

	public void showList(ArrayList<Food> foods) {

		try {

			FileWriter fw = new FileWriter("menu.html");

			fw.write("<link rel='stylesheet' href='style.css'>");

			fw.write("<h1>ミャンマー料理メニュー</h1>");

			fw.write("<table border='1'>");

			fw.write("<tr>");
			fw.write("<th>画像</th>");
			fw.write("<th>料理名</th>");
			fw.write("<th>価格</th>");
			fw.write("</tr>");

			for (Food f : foods) {

				fw.write("<tr>");

				fw.write("<td>");

				fw.write("<a href='details/" + f.getFoodId() + ".html'>");

				fw.write("<img height='100px' src='" + f.getImage() + "'>");

				fw.write("</a>");

				fw.write("</td>");

				fw.write("<td>" + f.getFoodName() + "</td>");
				fw.write("<td>" + f.getPrice() + "円</td>");

				fw.write("</tr>");

				showDetail(f);
			}

			fw.write("</table>");

			fw.close();

			System.out.println("menu.html を作成しました。");

			File file = new File("menu.html");

			Desktop.getDesktop().browse(file.toURI());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void showDetail(Food food) {

		try {

			FileWriter fw = new FileWriter("details/" + food.getFoodId() + ".html");

			// CSSファイルを読み込む
			fw.write("<link rel='stylesheet' href='../style.css'>");

			fw.write("<h1>料理詳細</h1>");

			fw.write("<table border='1'>");

			fw.write("<tr>");
			fw.write("<th>料理ID</th>");
			fw.write("<td>" + food.getFoodId() + "</td>");
			fw.write("</tr>");

			fw.write("<tr>");
			fw.write("<th>料理名</th>");
			fw.write("<td>" + food.getFoodName() + "</td>");
			fw.write("</tr>");

			fw.write("<tr>");
			fw.write("<th>価格</th>");
			fw.write("<td>" + food.getPrice() + "円</td>");
			fw.write("</tr>");

			fw.write("<tr>");
			fw.write("<th>説明</th>");
			fw.write("<td>" + food.getDetail() + "</td>");
			fw.write("</tr>");

			fw.write("<tr>");
			fw.write("<th>画像</th>");
			fw.write("<td><img height='300px' src='" + food.getImage() + "'></td>");
			fw.write("</tr>");

			fw.write("</table>");

			fw.write("<a href='#' onclick='history.back()'>戻る</a>");

			fw.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
