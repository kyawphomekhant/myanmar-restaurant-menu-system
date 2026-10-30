package aiwa.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import aiwa.entity.Drink;

public class DrinkModel {

	public ArrayList<Drink> findByType(int type) {

		ArrayList<Drink> drinks = new ArrayList<Drink>();

		try {

			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager.getConnection(
					"jdbc:sqlite:database04.db");

			String sql = "select * from drinks where type = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, type);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Drink d = new Drink();

				d.setDrinkId(rs.getInt("drinkid"));
				d.setDrinkName(rs.getString("drinkname"));
				d.setPrice(rs.getInt("price"));
				d.setImage(rs.getString("image"));
				d.setType(rs.getInt("type"));

				drinks.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return drinks;
	}

}
