package homeworks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class tema2 {
	
	public static void main(String[] args) throws SQLException {
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password","" );
		
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/oop2024",
				connectionProps);
		
		String cSize = "XL";
		String cPrice = "420.1";
		
		String sqlInsert = "INSERT INTO clothes (size, price) VALUES (? , ?)";
		PreparedStatement ps = conn.prepareStatement(sqlInsert);
		ps.setString(1, cSize);
		ps.setString(2, cPrice);
		ps.executeUpdate();
		
		String update = "UPDATE clothes SET price = ? WHERE id = ?";
		PreparedStatement psu = conn.prepareStatement(update);
		psu.setString(1, cPrice);
		psu.setInt(2, 1);
		psu.executeUpdate();
		
		String delete = "DELETE FROM clothes WHERE id = ?";
		PreparedStatement psd = conn.prepareStatement(delete);
		psd.setInt(1, 3);
		int result = psd.executeUpdate();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from clothes");
		while(rs.next()) {
			int id = rs.getInt("id");
			String clothesSize = rs.getString("size");
			String clothesPrice = rs.getString("price");
			
			System.out.println(id + " | " + clothesSize + " | " + clothesPrice);
		}
		conn.close();
	}
}
