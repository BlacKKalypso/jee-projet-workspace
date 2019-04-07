package com.crea.dev1.jee.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crea.dev1.jee.ecole.model.beans.Chambre;
import com.crea.dev1.jee.ecole.model.common.DBAction;

public class ChambreDAO {
	public static Chambre getChambreByNo(int no) throws SQLException{
		Chambre chambTemp = new Chambre();
		ResultSet res;
		String req = "SELECT no, num, prix FROM chambre WHERE no = '" +no+"' ";
		//Connexion
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while( DBAction.getRes().next() )
		{	
			// Creation de l'objet chambTemp a travers le ResultSet BD
			chambTemp.setNo(DBAction.getRes().getInt(1));
			chambTemp.setNum(DBAction.getRes().getString(2));
			chambTemp.setPrix(DBAction.getRes().getFloat(3));
			chambTemp.afficheChambre();
		}
		// Fermeture de la connexion & statement & res
		DBAction.DBClose();
		// Retourner l'objet chambTemp
		return chambTemp;
	}
	
	public static ArrayList<Chambre> getChambreByNum(String listsnums) throws SQLException {
		ArrayList<Chambre> listChambreNum = new ArrayList<Chambre>();		
		String req = "SELECT no, num, prix FROM chambre WHERE num = '"+listsnums+"' ";
		
		// Connexion
		DBAction.DBConnexion();
		
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		// Creation de l'objet chambTemp a travers le ResultSet BD
		while( DBAction.getRes().next() )
		{
			Chambre chambTemp = new Chambre();
			
			//Creation de l'objet chambTemp a travers le ResultSet BD
			chambTemp.setNo(DBAction.getRes().getInt(1));
			chambTemp.setNum(DBAction.getRes().getString(2));
			chambTemp.setPrix(DBAction.getRes().getFloat(3));
			listChambreNum.add(chambTemp);
		}
		for(int i =0; i<listChambreNum.size();i++) {
			listChambreNum.get(i).afficheChambre();
		}
		// Fermeture de la connexion
		DBAction.DBClose();
		// Retourner l'objet chambTemp
		return listChambreNum;
	}
	
	public static ArrayList<Chambre> getChambreByPrix(String listsprix) throws SQLException {
		ArrayList<Chambre> listChambrePrix = new ArrayList<Chambre>();		
		String req = "SELECT * FROM chambre WHERE prix = '"+listsprix+"' ";
		
		// Connexion
		DBAction.DBConnexion();
		// execution de la requete et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		// Creation de l'objet chambTemp � travers le ResultSet BD
		while( DBAction.getRes().next() )
		{
			Chambre chambTemp = new Chambre();
			//Creation de l'objet chambTemp � travers le ResultSet BD
			chambTemp.setNo(DBAction.getRes().getInt(1));
			chambTemp.setNum(DBAction.getRes().getString(2));
			chambTemp.setPrix(DBAction.getRes().getFloat(3));
			listChambrePrix.add(chambTemp);
		}
		for(int i =0; i<listChambrePrix.size();i++) {
			listChambrePrix.get(i).afficheChambre();
		}
		// Fermeture de la connexion
		DBAction.DBClose();
		// Retourner l'objet Temp
		return listChambrePrix;
	}
	public static int deleteChambreByNo(String no) {
		int result = -1;
		DBAction.DBConnexion();
		String req = "DELETE FROM chambre WHERE no = '"+no+"' ";
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
	
	public static int updNumChambreByNo(int no, String num)  
			throws SQLException
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "UPDATE chambre SET num = '"+num+"' WHERE no ='"+no+"' ";
		result = DBAction.getStm().executeUpdate(req);
		System.out.println("Requete executee");	
		
		DBAction.DBClose();
		return result;
	}
	
	public static int updPrixChambreByNo(int no, float prix) 
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "UPDATE chambre SET prix = "+prix+" WHERE no ='"+no+"' ";
		try {
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requete executee");	
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
		}
		DBAction.DBClose();
		return result;
	}
	public static int addChambre(int no, float prix) 
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "INSERT INTO chambre (no, num, prix)"
				+ " VALUES ('"+no+"',NULL,'"+prix+"') ";
		try {
			result = DBAction.getStm().executeUpdate(req);
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
		}
			
		DBAction.DBClose();
		return result;
	}
	
	public static ArrayList<Chambre> getAllChambre() throws SQLException 
	{
		
		ArrayList<Chambre> listChambre = new ArrayList<Chambre>();
		
		String req = "SELECT * FROM chambre";
		// Connexion
		DBAction.DBConnexion();
		// execution de la requete et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while( DBAction.getRes().next() )
		{	
			//int i = 0;
			//Instanciation de mon objet Chambre
			Chambre chambTemp = new Chambre();
			// Creation de l'objet chambTemp � travers le ResultSet BD
			chambTemp.setNo(DBAction.getRes().getInt(1));
			chambTemp.setNum(DBAction.getRes().getString(2));
			chambTemp.setPrix(DBAction.getRes().getFloat(3));
			listChambre.add(chambTemp);
			//i = i + 1;
		}
		// Fermeture de la connexion
		DBAction.DBClose();
		return listChambre;
	}
}
