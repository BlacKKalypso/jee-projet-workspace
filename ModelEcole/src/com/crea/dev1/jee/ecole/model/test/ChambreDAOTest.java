package com.crea.dev1.jee.ecole.model.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.crea.dev1.jee.ecole.model.beans.Chambre;
import com.crea.dev1.jee.ecole.model.dao.ChambreDAO;

class ChambreDAOTest {
	Chambre ref1 = new Chambre(1, "LAURENCY005", 350.25f);
	Chambre ref2 = new Chambre(2, "", 400.55f);
	Chambre ref3 = new Chambre(3, "HUGO002", 350.25f);
	
	@Test
	void testGetChambreByNo() throws SQLException {
		Chambre res = new Chambre();
		 res = ChambreDAO.getChambreByNo(1);	 
		 assertEquals(ref1.getNum(),res.getNum());
		 assertEquals(ref1.getNo(),res.getNo());
		 assertEquals(ref1.getPrix(),res.getPrix());
	}

	@Test
	void testGetChambreByNum() {
		fail("Not yet implemented");
	}

	@Test
	void testGetChambreByPrix() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteChambreByNo() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdNumChambreByNo() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdPrixChambreByNo() {
		fail("Not yet implemented");
	}

	@Test
	void testAddChambre() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllChambre() {
		fail("Not yet implemented");
	}

}
