package ro.emanuel.rubickscube.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ro.emanuel.rubickscube.dao.RubicksCubeDAO;
import ro.emanuel.rubickscube.pojo.RubicksCube;

public class Main {

	public static void main(String[] args) throws SQLException {
	    
	    RubicksCube newRC = new RubicksCube("Dayan", 60, 7);
	    RubicksCube newRC2 = new RubicksCube("Gan", 35, 4);
	    RubicksCube newRC3 = new RubicksCube("ShengShou", 30, 2);
	    RubicksCubeDAO.createRubicksCube(newRC);
	    RubicksCubeDAO.createRubicksCube(newRC2);
	    int rIns = RubicksCubeDAO.createRubicksCube(newRC3);
	    System.out.println("Cubul a fost creat. Randuri inserate: " + rIns);
	    System.out.println("=====================");
	    
		List<RubicksCube> rbC = RubicksCubeDAO.getRubicksCube();
		for(RubicksCube rb: rbC) {
			System.out.println(rb);
		}
	    System.out.println("=====================");
	    
	    RubicksCube rbCb = RubicksCubeDAO.getById(46);
	    System.out.println("Cubul gasit dupa ID: " + rbCb);
	    System.out.println("=====================");
	    
	    RubicksCube cubeToUpdate = new RubicksCube(45, "Megaminx", 143, 12); 	
        int rowsUpdated = RubicksCubeDAO.updateRubicksCube(cubeToUpdate);
        System.out.println("Cubul a fost actualizat. Randuri updatate: " + rowsUpdated);
       
        rbCb = RubicksCubeDAO.getById(45);
        System.out.println("Cubul actualizat: " + rbCb);
	    System.out.println("=====================");
	    
        int rowsDeleted = RubicksCubeDAO.deleteRubicksCube(50);
        System.out.println("Cubul a fost sters. Randuri sterse: " + rowsDeleted);
//        rbCb = RubicksCubeDao.getById(2);
//        System.out.println(rbCb);
	}

}