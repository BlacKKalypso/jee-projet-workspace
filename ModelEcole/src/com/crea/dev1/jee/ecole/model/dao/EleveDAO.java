package com.crea.dev1.jee.ecole.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.IIOException;

import com.crea.dev1.jee.ecole.model.beans.Eleve;
import com.crea.dev1.jee.ecole.model.common.DBAction;

public class EleveDAO  
{
	/**
	 * Liste un eleve en particulier d'apres son identifiant pass� en parametre de la fonction.
	 * @param num
	 * @return : retourne l'objet ElevTemp 
	 * @throws SQLException
	 */
	public static Eleve getEleveByNum(String num) throws SQLException 
	{
		Eleve elevTemp = new Eleve();
		ResultSet res;
		String req = "SELECT num, no, nom, age, adresse FROM eleve WHERE num = '"+num+"' ";//SELECT * FROM Eleve where num = \""+num+"\""
		// Connexion
		DBAction.DBConnexion();//System.out.println(req);
		// ex�cution de la requ�te et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while( DBAction.getRes().next() )
		{	
			// Creation de l'objet eleveTemp � travers le ResultSet BD
			elevTemp.setNum(DBAction.getRes().getString(1));
			elevTemp.setNo(DBAction.getRes().getInt(2));
			elevTemp.setNom(DBAction.getRes().getString(3));
			elevTemp.setAge(DBAction.getRes().getInt(4));
			elevTemp.setAdresse(DBAction.getRes().getString(5));
			elevTemp.affiche();
		}
		// Fermeture de la connexion & statement & res
		DBAction.DBClose();
		// Retourner l'objet ElevTemp
		return elevTemp;
	}
	/**
	 * Selection d'Eleve(s) par le nom
	 * @param listsnoms
	 * @return :un liste d'eleve  
	 */
	public static ArrayList<Eleve> getEleveByNom(String listsnoms) throws SQLException 
//	public static ArrayList<Eleve> getEleveByNom(ArrayList<String> lstnoms) throws SQLException 
	{
		//Cr�ation de ma liste d'�l�ve ayant le meme nom
		ArrayList<Eleve> listEleveNom = new ArrayList<Eleve>();		
		String req = "SELECT num, no, nom, age, adresse FROM eleve WHERE nom = '"+listsnoms+"' ";//SELECT * FROM Eleve where num = \""+num+"\""

/*		String req2 = "SELECT * FROM Eleve where nom IN (" ;
		for(int i= 0; i< lstnoms.size();i++) {
			req2+= lstnoms.get(i).toString()+ ",";
		}
		req2+=")";
	*/	

		// Connexion
		DBAction.DBConnexion();//System.out.println(req);
		// ex�cution de la requ�te et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		// Creation de l'objet eleveTemp � travers le ResultSet BD
		while( DBAction.getRes().next() )
		{
	/**		Eleve elevTemp = new Eleve(DBAction.getRes().getString(1),
					DBAction.getRes().getInt(2), DBAction.getRes().getString(3), 
					DBAction.getRes().getInt(4), DBAction.getRes().getString(5));*/
			Eleve elevTemp = new Eleve();
			//Creation de l'objet eleveTemp � travers le ResultSet BD
			elevTemp.setNum(DBAction.getRes().getString(1));
			elevTemp.setNo(DBAction.getRes().getInt(2));
			elevTemp.setNom(DBAction.getRes().getString(3));
			elevTemp.setAge(DBAction.getRes().getInt(4));
			elevTemp.setAdresse(DBAction.getRes().getString(5));
			listEleveNom.add(elevTemp);
		}
		for(int i =0; i<listEleveNom.size();i++) {
			listEleveNom.get(i).affiche();
		}
		// Fermeture de la connexion
		DBAction.DBClose();
		// Retourner l'objet ElevTemp
		return listEleveNom;
	}
	/**
	 * Selection d'1 ou +sieurs Eleve par son num�ro de chambre
	 * @param no
	 * @return :un objet eleve  
	 */
	public static ArrayList<Eleve> getEleveByNo(int no) throws SQLException 
	{ 
		//Cr�ation de ma liste d'�l�ve partageant la m�me chambre
		ArrayList<Eleve> listEleveNo = new ArrayList<Eleve>();
		
		String req = "SELECT num, no, nom, age, adresse FROM eleve where no = "+no+" ";
		// Connexion
		DBAction.DBConnexion();//System.out.println(req);
		
		// ex�cution de la requ�te et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		// Creation de l'objet eleveTemp � travers le ResultSet BD
		while( DBAction.getRes().next() )
		{	
			Eleve elevTemp = new Eleve();
			// Creation de l'objet eleveTemp � travers le ResultSet BD
			elevTemp.setNum(DBAction.getRes().getString(1));
			elevTemp.setNo(DBAction.getRes().getInt(2));
			elevTemp.setNom(DBAction.getRes().getString(3));
			elevTemp.setAge(DBAction.getRes().getInt(4));
			elevTemp.setAdresse(DBAction.getRes().getString(5));
			listEleveNo.add(elevTemp);
		}
		
		// Fermeture de la connexion
		DBAction.DBClose();
		// Retourner l'objet ElevTemp
		return listEleveNo;
	}
	
	/**
	 * Delete Eleve par un numero
	 * @param num
	 * @return : 1 ou 0  (le nbr d'etudiants supprimes) sinon le (-) code d'erreur  
	 */
	public static int deleteEleveByNum(String num) {
		int result = -1;
		DBAction.DBConnexion();
		String req = "DELETE FROM eleve WHERE num = '"+num+"' ";
		try {
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requete execut�e");	
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
	
	/**
	 * Met � jour de l'adresse d'un �l�ve par son num�ro
	 * @param num
	 * @return : 1 ou 0  (le nbr d'�tudiants mis � jour) sinon le (-) code d'erreur  
	 */
	public static int updAdresseEleveByNum(String num,String adresse)  
			throws SQLException
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "UPDATE eleve SET adresse = '"+adresse+"' WHERE num ='"+num+"' ";
		result = DBAction.getStm().executeUpdate(req);
		System.out.println("Requete executee");	
		
		DBAction.DBClose();
		return result;
	}
	/**
	 * Met � jour(Attribuer une chambre � 1 �l�ve) le n� de chambre � un �l�ve
	 * @param num
	 * @return : 1 ou 0  (le nbr d'�tudiants mis � jour) sinon le (-) code d'erreur  
	 */
	public static int updNoChambreEleveByNum(String num,int no) 
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "UPDATE eleve SET no = "+no+" WHERE num ='"+num+"' ";
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

	
	/**
	 * Ajouter un eleve
	 * @param String num, String nom, int age, String adresse
	 * @return : 1 ou 0  (le nbr d'�tudiants ajout�) sinon le (-) code d'erreur   
	 */
	public static int addEleve(String num,String nom, int age, String adresse) 
	{
		int result = -1;
		DBAction.DBConnexion();

		String req = "INSERT INTO eleve (num, no, nom, age, adresse)"
				+ " VALUES ('"+num+"',NULL,'"+nom+"',"+age+",'"+adresse+"') ";
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
	
	/**
	 * Renvoie une liste d'eleves en fonction de l'age.
	 * @param anneeNaissance : Date de naissance de(s) l'�l�ve(s)(l'ann�e)
	 * @return : 1 liste d'�l�ve ayant le m�me age. 
	 */
	public static ArrayList<Eleve> getListEleveByDateN(int anneeNaissance) throws SQLException
	{
		ArrayList<Eleve> listEleveAnneeNaissance = new ArrayList<Eleve>();
		
		//on recupere l'annee en cours
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		 
		 //Variable a passer en parametre dans la requete pour avoir les eleves d'une tranche d'age:
		//Je fais la difference entre l'ann�e en cours et l'annee passee en param�tre de la fonction.
		int anneeNaissanceEleves = year - anneeNaissance;
		String req = "SELECT num, no, nom, age, adresse FROM eleve WHERE age ="+anneeNaissanceEleves+" ";
		// Connexion
		DBAction.DBConnexion();
		// execution de la requete et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while( DBAction.getRes().next() )
		{	
			//int i = 0;
			//Instanciation de mon objet Eleve
			Eleve elevTemp = new Eleve();
			
			// Creation de l'objet eleveTemp � travers le ResultSet BD
			elevTemp.setNum(DBAction.getRes().getString(1));
			elevTemp.setNo(DBAction.getRes().getInt(2));
			elevTemp.setNom(DBAction.getRes().getString(3));
			elevTemp.setAge(DBAction.getRes().getInt(4));
			elevTemp.setAdresse(DBAction.getRes().getString(5));
			listEleveAnneeNaissance.add(elevTemp);
			//i = i + 1;
		}
		// Fermeture de la connexion
		DBAction.DBClose();
		return listEleveAnneeNaissance;
		
	}
	/**
	 * @param aucun
	 * @return : la liste de tous les eleves .
	 */
	public static ArrayList<Eleve> getAllEleve() throws SQLException 
	{
		
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();
		
		String req = "SELECT num, no, nom, age, adresse FROM eleve ";
		// Connexion
		DBAction.DBConnexion();
		// ex�cution de la requ�te et init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while( DBAction.getRes().next() )
		{	
			//int i = 0;
			//Instanciation de mon objet Eleve
			Eleve elevTemp = new Eleve();
			// Creation de l'objet eleveTemp � travers le ResultSet BD
			elevTemp.setNum(DBAction.getRes().getString(1));
			elevTemp.setNo(DBAction.getRes().getInt(2));
			elevTemp.setNom(DBAction.getRes().getString(3));
			elevTemp.setAge(DBAction.getRes().getInt(4));
			elevTemp.setAdresse(DBAction.getRes().getString(5));
			listEleve.add(elevTemp);
			//i = i + 1;
		}
		// Fermeture de la connexion
		DBAction.DBClose();
		return listEleve;
	}
}