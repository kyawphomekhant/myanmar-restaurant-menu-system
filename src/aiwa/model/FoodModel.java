package aiwa.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import aiwa.entity.Food;

public class FoodModel {

	public ArrayList<Food> findByKeyword(String word) {

		ArrayList<Food> foods = new ArrayList<Food>();

		try {

			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager.getConnection("jdbc:sqlite:database04.db");

			String sql = "select * from foods where foodname like ? or detail like ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, "%" + word + "%");
			stmt.setString(2, "%" + word + "%");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Food f = new Food();
				f.setFoodId(rs.getInt("foodid"));
				f.setFoodName(rs.getString("foodname"));
				f.setPrice(rs.getInt("price"));
				f.setImage(rs.getString("image"));
				f.setDetail(rs.getString("detail"));
				foods.add(f);
			}

			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return foods;
	}

	public ArrayList<Food> findAll() {

		ArrayList<Food> foods = new ArrayList<Food>();

		try {

			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager.getConnection("jdbc:sqlite:database04.db");

			String sql = "select * from foods";

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Food f = new Food();
				f.setFoodId(rs.getInt("foodid"));
				f.setFoodName(rs.getString("foodname"));
				f.setPrice(rs.getInt("price"));
				f.setImage(rs.getString("image"));
				f.setDetail(rs.getString("detail"));
				foods.add(f);
			}

			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return foods;

	}

}
