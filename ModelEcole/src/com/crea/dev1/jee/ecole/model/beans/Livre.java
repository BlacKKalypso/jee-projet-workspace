package com.crea.dev1.jee.ecole.model.beans;

import java.util.Date;

public class Livre {
	private String cote;
	private String num;
	private String titre;
	private Date datepret;
	
	public Livre(String cote, String num, String titre, Date datepret) {
		this.cote = cote;
		this.num = num;
		this.titre = titre;
		this.datepret = datepret;
	}
	public Livre() {
		this("","","",null);
	}
	public String getCote() {
		return cote;
	}
	public void setCote(String cote) {
		this.cote = cote;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDatepret() {
		return datepret;
	}
	public void setDatepret(Date datepret) {
		this.datepret = datepret;
	}
	
	public void afficheLivre()
	{
		System.out.println("Cote du livre : ["+this.cote+"] Numero de l'eleve: ["+this.num+"]  Titre du livre : ["+this.titre+"] Titre du livre : ["+this.datepret+"]");
	}
}

