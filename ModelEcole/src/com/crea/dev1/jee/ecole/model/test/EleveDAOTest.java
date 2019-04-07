package com.crea.dev1.jee.ecole.model.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.crea.dev1.jee.ecole.model.beans.Eleve;
import com.crea.dev1.jee.ecole.model.dao.EleveDAO;

class EleveDAOTest {

	@Test
	void testGetEleveByNum() throws SQLException {
		Eleve e_ref= new Eleve("AGUE001", 0, "Ague Max", 40, "18 Rue Labat 75018 Paris");//"AGUE001", 1, "AGUE MAX", 40, "18 Rue Labat 75018 Paris"
		Eleve e_res = new Eleve();
		e_res = EleveDAO.getEleveByNum("AGUE001");	 
		assertEquals(e_ref.getAdresse(),e_res.getAdresse());
		assertEquals(e_ref.getAge(),e_res.getAge());
		assertEquals(e_ref.getNo(),e_res.getNo());
		assertEquals(e_ref.getNom(),e_res.getNom());
		assertEquals(e_ref.getNum(),e_res.getNum());
	}

	@Test
	void testGetEleveByNom() throws SQLException {
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();

		Eleve e1 = new Eleve("AGUE001", 0, "Ague Max", 40, "18 Rue Labat 75018 Paris");
		Eleve e2 = new Eleve("AGUE002", 0, "Ague Max", 42, "54 Rue des Ebisoires 78300 Poissy");

		listEleve.add(e1);
		listEleve.add(e2);

		for( int i =0; i < listEleve.size(); i++ )
		{  
			System.out.println("Taille Liste : "+EleveDAO.getEleveByNom("Ague Max").size());
			assertEquals(listEleve.get(i).getAdresse(),EleveDAO.getEleveByNom("Ague Max").get(i).getAdresse());
			assertEquals(listEleve.get(i).getNo(),EleveDAO.getEleveByNom("Ague Max").get(i).getNo());
			assertEquals(listEleve.get(i).getNom(),EleveDAO.getEleveByNom("Ague Max").get(i).getNom());
			assertEquals(listEleve.get(i).getNum(),EleveDAO.getEleveByNom("Ague Max").get(i).getNum());
			assertEquals(listEleve.get(i).getAge(),EleveDAO.getEleveByNom("Ague Max").get(i).getAge());
		}
	}

	@Test
	void testGetEleveByNo() throws SQLException {
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();
		Eleve e1 = new Eleve("KAMTO005", 4, "Kamto Diogène", 50,"54 Rue des Ebisoires 78300 Poissy");
		Eleve e2 = new Eleve("TABIS003", 4, "Ghislaine Tabis", 30,"12 Rue du louvre 75013 Paris");
		Eleve e3 = new Eleve("TAHAE002", 4, "Taha Ridene", 30,"22 Rue Chatelaine 1219 Aïre");

		listEleve.add(e1);
		listEleve.add(e2);
		listEleve.add(e3);
		
		for( int i =0; i < listEleve.size(); i++ )
		{  
			System.out.println("Taille Liste : "+EleveDAO.getEleveByNo(4).size());
			assertEquals(listEleve.get(i).getAdresse(),EleveDAO.getEleveByNo(4).get(i).getAdresse());
			assertEquals(listEleve.get(i).getNo(),EleveDAO.getEleveByNo(4).get(i).getNo());
			assertEquals(listEleve.get(i).getNom(),EleveDAO.getEleveByNo(4).get(i).getNom());
			assertEquals(listEleve.get(i).getNum(),EleveDAO.getEleveByNo(4).get(i).getNum());
			assertEquals(listEleve.get(i).getAge(),EleveDAO.getEleveByNo(4).get(i).getAge());
		}


	}

	/*
	@Test
	void testDeleteEleveByNum() {
		int delete = 1;
		assertEquals(delete,EleveDAO.deleteEleveByNum("AGUE001"));
		assertEquals(delete,EleveDAO.deleteEleveByNum("AGUE002"));
		assertEquals(delete,EleveDAO.deleteEleveByNum("KAMTO005"));
		assertEquals(delete,EleveDAO.deleteEleveByNum("LAURENCY004"));
		assertEquals(delete,EleveDAO.deleteEleveByNum("TABIS003"));
		assertEquals(delete,EleveDAO.deleteEleveByNum("TAHAE002")); 
		System.out.println("Eleve Supprime ou pas : "+delete);
	}*/

	@Test
	void testUpdAdresseEleveByNum() throws SQLException {
		int update = 1;
		assertEquals(update, EleveDAO.updAdresseEleveByNum("TAHAE002", "22 Rue Chatelaine 1219 Aïre"));
	}

	/*
	@Test
	void testUpdNoChambreEleveByNum() throws SQLException {
		int update = 1;
		assertEquals(update, EleveDAO.updNoChambreEleveByNum("TAHAE002", 3)); 
	}
	*/

	/*
	@Test
	void testAddEleve() {
		int insert = 1;
		assertEquals(insert,EleveDAO.addEleve("AGUE001", "AGUE MAX", 40, "18 Rue Labat 75018 Paris"));
		assertEquals(insert,EleveDAO.addEleve("AGUE002", "AGUE MAX", 42, "19 Rue Le Monde Paris"));
		assertEquals(insert,EleveDAO.addEleve("AGUE003", "AGUE MAX", 44, "19 Rue Le Monde Paris"));
		assertEquals(insert,EleveDAO.addEleve("KAMTO005", "KAMTO Diogene", 50, "54 Rue des Ebisoires 78300 Poissy"));
		assertEquals(insert,EleveDAO.addEleve("LAURENCY004", "LAURENCY Patrick", 52, "79 Rue des Poules 75015 Paris"));
		assertEquals(insert,EleveDAO.addEleve("TABIS003", "Ghislaine TABIS", 30, "12 Rue du louvre 75013 Paris"));
		assertEquals(insert,EleveDAO.addEleve("TAHAE002", "TAHAR RIDENE", 30, "12 Rue des Chantiers 78000 Versailles")); 
	}
	 */

	@Test
	void testGetListEleveByDateN() throws SQLException {
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();

		Eleve e1 = new Eleve("LAURENCY005", 1, "Laurency Patrick", 30, "54 Rue des Ebisoires 78300 Poissy");
		Eleve e2 = new Eleve("TABIS003",4, "Ghislaine Tabis", 30, "12 Rue du louvre 75013 Paris");
		Eleve e3 = new Eleve("TAHAE002", 4, "Taha Ridene", 30, "22 Rue Chatelaine 1219 Aïre");

		listEleve.add(e1);
		listEleve.add(e2);
		listEleve.add(e3);	

		for( int i = 0; i < listEleve.size(); i++ )
		{  
			assertEquals(listEleve.get(i).getNum(),EleveDAO.getListEleveByDateN(1989).get(i).getNum());
			assertEquals(listEleve.get(i).getNo(),EleveDAO.getListEleveByDateN(1989).get(i).getNo());
			assertEquals(listEleve.get(i).getNom(),EleveDAO.getListEleveByDateN(1989).get(i).getNom());
			assertEquals(listEleve.get(i).getAge(),EleveDAO.getListEleveByDateN(1989).get(i).getAge());
			assertEquals(listEleve.get(i).getAdresse(),EleveDAO.getListEleveByDateN(1989).get(i).getAdresse());
		}
	}

	@Test
	void testGetAllEleve() throws SQLException {
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();

		Eleve e1 = new Eleve("AGUE001", 0, "Ague Max", 40, "18 Rue Labat 75018 Paris");
		Eleve e2 = new Eleve("AGUE002", 0, "Ague Max", 42, "54 Rue des Ebisoires 78300 Poissy");
		Eleve e3 = new Eleve("HUGO002", 3, "Hugo De Oliviera", 26,"18 Rue Labat 75018 Paris");
		Eleve e4 = new Eleve("KAMTO005", 4, "Kamto Diogène", 50, "54 Rue des Ebisoires 78300 Poissy");
		Eleve e5 = new Eleve("LAURENCY004", 0, "Laurency Patrick", 52, "22 Rue Chatelaine 1219 Aïre");
		Eleve e6 = new Eleve("LAURENCY005", 1, "Laurency Patrick", 30, "54 Rue des Ebisoires 78300 Poissy");
		Eleve e7 = new Eleve("TABIS003",4, "Ghislaine Tabis", 30, "12 Rue du louvre 75013 Paris");
		Eleve e8 = new Eleve("TAHAE002", 4, "Taha Ridene", 30, "22 Rue Chatelaine 1219 Aïre");

		listEleve.add(e1);
		listEleve.add(e2);
		listEleve.add(e3);
		listEleve.add(e4);
		listEleve.add(e5);		
		listEleve.add(e6);
		listEleve.add(e7);
		listEleve.add(e8);	

		for( int i = 0; i < listEleve.size(); i++ )
		{  
			assertEquals(listEleve.get(i).getNum(),EleveDAO.getAllEleve().get(i).getNum());
			assertEquals(listEleve.get(i).getNo(),EleveDAO.getAllEleve().get(i).getNo());
			assertEquals(listEleve.get(i).getNom(),EleveDAO.getAllEleve().get(i).getNom());
			assertEquals(listEleve.get(i).getAge(),EleveDAO.getAllEleve().get(i).getAge());
			assertEquals(listEleve.get(i).getAdresse(),EleveDAO.getAllEleve().get(i).getAdresse());
		}
	}

}
