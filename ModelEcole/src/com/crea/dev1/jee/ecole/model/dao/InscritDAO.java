package com.crea.dev1.jee.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crea.dev1.jee.ecole.model.beans.Inscrit;
import com.crea.dev1.jee.ecole.model.common.DBAction;

public class InscritDAO {
	public static Inscrit getInscritByCode(String code) throws SQLException 
	{
		Inscrit inscTemp = new Inscrit();
		ResultSet res ;
		String req = "SELECT * FROM inscrit WHERE code = '"+code+"' ";
		// Connexion
		DBAction.DBConnexion();//System.out.println(req);
		// ex�cution de la requete et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while( DBAction.getRes().next() )
		{	
			// Creation de l'objet inscTemp � travers le ResultSet BD
			inscTemp.setCode(DBAction.getRes().getString(1));
			inscTemp.setNum(DBAction.getRes().getString(2));
			inscTemp.setNote(DBAction.getRes().getFloat(3));
			inscTemp.afficheInscrit();
		}
		// Fermeture de la connexion & statement & res
		DBAction.DBClose();
		// Retourner l'objet inscTemp
		return inscTemp;
	}
	
	public static ArrayList<Inscrit> getInscritByNum(String listnums) throws SQLException {
		ArrayList<Inscrit> listInscritNum = new ArrayList<Inscrit>();		
		String req = "SELECT * FROM inscrit WHERE num = '"+listnums+"' ";

		// Connexion
		DBAction.DBConnexion();
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while( DBAction.getRes().next() )
		{
			Inscrit inscTemp = new Inscrit();
			//Creation de l'objet inscTemp � travers le ResultSet BD
			inscTemp.setCode(DBAction.getRes().getString(1));
			inscTemp.setNum(DBAction.getRes().getString(2));
			inscTemp.setNote(DBAction.getRes().getFloat(3));			
			listInscritNum.add(inscTemp);
		}
		for(int i =0; i<listInscritNum.size();i++) {
			listInscritNum.get(i).afficheInscrit();
		}
		// Fermeture de la connexion
		DBAction.DBClose();
		// Retourner l'objet inscTemp
		return listInscritNum;
	}
	
	public static ArrayList<Inscrit> getInscritByNote(float note) throws SQLException 
	{ 
		ArrayList<Inscrit> listInscritNote = new ArrayList<Inscrit>();
		
		String req = "SELECT * FROM inscrit where note = "+note+" ";
		// Connexion
		DBAction.DBConnexion();//System.out.println(req);
		
		// execution de la requete et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		// Creation de l'objet inscTemp � travers le ResultSet BD
		while( DBAction.getRes().next() )
		{	
			Inscrit inscTemp = new Inscrit();
			
			inscTemp.setCode(DBAction.getRes().getString(1));
			inscTemp.setNum(DBAction.getRes().getString(2));
			inscTemp.setNote(DBAction.getRes().getFloat(3));
			listInscritNote.add(inscTemp);
		}
		
		// Fermeture de la connexion
		DBAction.DBClose();
		// Retourner l'objet inscTemp
		return listInscritNote;
	}
	
	public static int deleteInscritByCode(String code) {
		int result = -1;
		DBAction.DBConnexion();
		String req = "DELETE FROM inscrit WHERE code = '"+code+"' ";
		try {
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requete executee");	
		} 
		catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());	
		}
		System.out.println("["+req+"] Suppression : Valeur de result == "+result);
		DBAction.DBClose();
		return result;
	}
	
	public static int updNoteInscritByNum(String num, float note)  
			throws SQLException
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "UPDATE inscrit SET note = '"+note+"' WHERE num ='"+num+"' ";
		result = DBAction.getStm().executeUpdate(req);
		System.out.println("Requete executee");	
		
		DBAction.DBClose();
		return result;
	}
	
	public static int updNumInscritByCode(String code, String num)  
			throws SQLException
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "UPDATE inscrit SET num = '"+num+"' WHERE code ='"+code+"' ";
		result = DBAction.getStm().executeUpdate(req);
		System.out.println("Requete executee");	
		
		DBAction.DBClose();
		return result;
	}
	
	public static int addInscrit(String code, String num) 
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "INSERT INTO inscrit (code, num, note)"
				+ " VALUES ('"+code+"','"+num+"',NULL,') ";
		try {
			result = DBAction.getStm().executeUpdate(req);
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
		}
		//System.out.println("["+req+"] Valeur de result == "+result);	
		//System.out.println(req);	
		DBAction.DBClose();
		return result;
	}
	
	public static ArrayList<Inscrit> getAllInscrit() throws SQLException 
	{
		
		ArrayList<Inscrit> listInscrit = new ArrayList<Inscrit>();
		
		String req = "SELECT * adresse FROM inscrit ";
		// Connexion
		DBAction.DBConnexion();
		// ex�cution de la requ�te et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while( DBAction.getRes().next() )
		{	
			//int i = 0;
			//Instanciation de mon objet Inscrit
			Inscrit inscTemp = new Inscrit();
			// Creation de l'objet inscrTemp � travers le ResultSet BD
			inscTemp.setCode(DBAction.getRes().getString(1));
			inscTemp.setNum(DBAction.getRes().getString(2));
			inscTemp.setNote(DBAction.getRes().getFloat(3));
			listInscrit.add(inscTemp);
			//i = i + 1;
		}
		// Fermeture de la connexion
		DBAction.DBClose();
		return listInscrit;
	}
}