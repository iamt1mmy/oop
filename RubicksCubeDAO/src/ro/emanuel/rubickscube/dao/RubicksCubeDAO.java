package ro.emanuel.rubickscube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.rubickscube.helper.DBHelper;
import ro.emanuel.rubickscube.pojo.RubicksCube;
	
public class RubicksCubeDAO {
		
		public static List<RubicksCube> getRubicksCube() throws SQLException{
			List<RubicksCube> listRubicksCube = new ArrayList<>();
			
			Connection conn=DBHelper.getConnection();
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from RubicksCube");
			while(rs.next()) {
				int id = rs.getInt("id");
				String brand=rs.getString("brand");
				double weight=rs.getDouble("weight");
				int sides=rs.getInt("sides");
				RubicksCube rubickscube=new RubicksCube(id, brand, weight, sides);
				listRubicksCube.add(rubickscube);
			}
			
			DBHelper.closeConnection();
			
			return listRubicksCube;
			
		}
		
		public static int deleteRubicksCube(int id) throws SQLException {
			
	        Connection conn = DBHelper.getConnection();
	        Statement stmt = conn.createStatement();
	        
	        int deletedRows = stmt.executeUpdate("delete from RubicksCube where id > " + id);
	        
	        DBHelper.closeConnection();
	        
	        return deletedRows; 
		}
		
		public static int createRubicksCube(RubicksCube rubicksCubeToCreate) throws SQLException {
			
			Connection conn = DBHelper.getConnection();
			String query = "insert into RubicksCube (brand, weight, sides) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, rubicksCubeToCreate.getBrand());
			ps.setDouble(2, rubicksCubeToCreate.getWeight());
			ps.setInt(3, rubicksCubeToCreate.getSides());
		
	        int affectedRows = ps.executeUpdate();
	        
	        DBHelper.closeConnection();
	        
	        return affectedRows;
		}

		public static int updateRubicksCube(RubicksCube rbc) throws SQLException{
			Connection conn = DBHelper.getConnection();
			String query = "update RubicksCube set brand = ?, weight = ?, sides = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, rbc.getBrand());
			ps.setDouble(2, rbc.getWeight());
			ps.setInt(3, rbc.getSides());
			ps.setInt(4, rbc.getId());
			
			int rUpd = ps.executeUpdate();
			
			DBHelper.closeConnection(); 	
			
			return rUpd; 
		}

		public static RubicksCube getById(int id) throws SQLException{
			Connection connection = DBHelper.getConnection();
			
			List<RubicksCube> listRubicksCube = getRubicksCube();
			for(RubicksCube rc : listRubicksCube) {
				if(rc.getId() == id) {
					return rc; 
				}
			}
			DBHelper.closeConnection();
			
			return null;
		}
	}