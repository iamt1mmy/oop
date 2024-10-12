package homeworks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class tema1 {
	
	public static void main(String[] args) throws SQLException {
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password","" );
		
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/oop2024",
				connectionProps);
		
		String fPlayerName = "Bruno Fernandes";
		String fTeam = "Manchester United";
		
		String sqlInsert = "INSERT INTO football (player_name, team) VALUES (? , ?)";
		PreparedStatement ps = conn.prepareStatement(sqlInsert);
		ps.setString(1, fPlayerName);
		ps.setString(2, fTeam);
		ps.executeUpdate();
		
		String update = "UPDATE football SET team = ? WHERE id = ?";
		PreparedStatement psu = conn.prepareStatement(update);
		psu.setString(1, fTeam);
		psu.setInt(2, 1);
		psu.executeUpdate();
		
		String delete = "DELETE FROM football WHERE id >= ?";
		PreparedStatement psd = conn.prepareStatement(delete);
		psd.setInt(1, 3);
		int result = psd.executeUpdate();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from football");
		while(rs.next()) {
			int id = rs.getInt("id");
			String footballPlayerName = rs.getString("player_name");
			String footballTeam = rs.getString("team");
			
			System.out.println(id + " | " + footballPlayerName + " | " + footballTeam);
		}
		conn.close();
	}
}
