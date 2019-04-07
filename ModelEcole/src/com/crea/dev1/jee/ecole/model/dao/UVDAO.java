package com.crea.dev1.jee.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crea.dev1.jee.ecole.model.beans.UV;
import com.crea.dev1.jee.ecole.model.common.DBAction;

public class UVDAO {
	public static UV getUVBycode(String code) throws SQLException{
		UV uvTemp = new UV();
		ResultSet res;
		String req = "SELECT * FROM livre WHERE code = '"+code+"' ";
		// Connexion
		DBAction.DBConnexion();//System.out.println(req);
		// execution de la requete et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while( DBAction.getRes().next() )
		{	
			// Creation de l'objet uvTemp a travers le ResultSet BD
			uvTemp.setCode(DBAction.getRes().getString(1));
			uvTemp.setNbh(DBAction.getRes().getInt(2));
			uvTemp.setCoord(DBAction.getRes().getString(3));
			uvTemp.afficheUv();
		}
		// Fermeture de la connexion & statement & res
		DBAction.DBClose();
		// Retourner l'objet uvTemp
		return uvTemp;
	}
	
	public static ArrayList<UV> getUvByNbh(String listsnbhs) throws SQLException{
		ArrayList<UV> listUvNbh = new ArrayList<UV>();		
		String req = "SELECT * FROM uv WHERE nbh = '"+listsnbhs+"' ";	

		// Connexion
		DBAction.DBConnexion();
		// execution de la requete et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		// Creation de l'objet uvTemp a travers le ResultSet BD
		while( DBAction.getRes().next() )
		{
			UV uvTemp = new UV();
			//Creation de l'objet uvTemp � travers le ResultSet BD
			uvTemp.setCode(DBAction.getRes().getString(1));
			uvTemp.setNbh(DBAction.getRes().getInt(2));
			uvTemp.setCoord(DBAction.getRes().getString(3));
			listUvNbh.add(uvTemp);
		}
		for(int i =0; i<listUvNbh.size();i++) {
			listUvNbh.get(i).afficheUv();
		}
		// Fermeture de la connexion
		DBAction.DBClose();
		// Retourner l'objet uvTemp
		return listUvNbh;
	}
	
	public static ArrayList<UV> getUvByCoord(String coord) throws SQLException 
	{ 
		ArrayList<UV> listUvCoord = new ArrayList<UV>();
		
		String req = "SELECT * FROM uv where coord = "+coord+" ";
		// Connexion
		DBAction.DBConnexion();//System.out.println(req);
		
		// execution de la requete et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		// Creation de l'objet uvTemp � travers le ResultSet BD
		while( DBAction.getRes().next() )
		{	
			UV uvTemp = new UV();
			// Creation de l'objet uvTemp � travers le ResultSet BD
			uvTemp.setCode(DBAction.getRes().getString(1));
			uvTemp.setNbh(DBAction.getRes().getInt(2));
			uvTemp.setCoord(DBAction.getRes().getString(3));
			listUvCoord.add(uvTemp);
		}
		
		// Fermeture de la connexion
		DBAction.DBClose();
		// Retourner l'objet uvTemp
		return listUvCoord;
	}
	
	public static int deleteUvByCode(String code) {
		int result = -1;
		DBAction.DBConnexion();
		String req = "DELETE FROM uv WHERE code = '"+code+"' ";
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
	
	public static int updCoordUvByCode(String code, String coord)  
			throws SQLException
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "UPDATE uv SET coord = '"+coord+"' WHERE code ='"+code+"' ";
		result = DBAction.getStm().executeUpdate(req);
		System.out.println("Requete executee");	
		
		DBAction.DBClose();
		return result;
	}
	
	public static int updNbhUvByCode(String code, int nbh)  
			throws SQLException
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "UPDATE uv SET nbh = '"+nbh+"' WHERE code ='"+code+"' ";
		result = DBAction.getStm().executeUpdate(req);
		System.out.println("Requete executee");	
		
		DBAction.DBClose();
		return result;
	}
	public static int addUv(String code, int nbh, String coord) 
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "INSERT INTO uv (code, nbh, coord)"
				+ " VALUES ('"+code+"',"+nbh+",'"+coord+"') ";
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
	
	public static ArrayList<UV> getAllUv() throws SQLException {
		
		ArrayList<UV> listUv = new ArrayList<UV>();
		
		String req = "SELECT * FROM uv ";
		// Connexion
		DBAction.DBConnexion();
		// execution de la requete et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while( DBAction.getRes().next() )
		{	
			UV uvTemp = new UV();
			// Creation de l'objet uvTemp � travers le ResultSet BD
			uvTemp.setCode(DBAction.getRes().getString(1));
			uvTemp.setNbh(DBAction.getRes().getInt(2));
			uvTemp.setCoord(DBAction.getRes().getString(3));
			listUv.add(uvTemp);
			//i = i + 1;
		}
		// Fermeture de la connexion
		DBAction.DBClose();
		return listUv;
	}
}
