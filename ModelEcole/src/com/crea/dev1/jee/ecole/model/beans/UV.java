package com.crea.dev1.jee.ecole.model.beans;

public class UV {
	private String code;
	private int nbh;
	private String coord;
	
	public UV(String code, int nbh, String coord) {
		this.code = code;
		this.nbh = nbh;
		this.coord = coord;
	}
	public UV() {
		this("",0,"");
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getNbh() {
		return nbh;
	}
	public void setNbh(int nbh) {
		this.nbh = nbh;
	}
	public String getCoord() {
		return coord;
	}
	public void setCoord(String coord) {
		this.coord = coord;
	}
	public void afficheUv()
	{
		System.out.println("Code de l'uv : ["+this.code+"] Nombre d'heure de cours: ["+this.nbh+"]  Enseignant : ["+this.coord+"]");
	}
}
