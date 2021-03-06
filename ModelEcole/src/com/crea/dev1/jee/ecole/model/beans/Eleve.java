package com.crea.dev1.jee.ecole.model.beans;

public class Eleve {
	private String num;
	private int no;
	private String nom;
	private int age;
	private String adresse;

	//Constructeur
	public Eleve(String num, int no, String nom, int age, String adresse) {
		//super();
		this.num = num;
		this.no = no;
		this.nom = nom;
		this.age = age;
		this.adresse = adresse;
	}
	
	/*
	 * Initialisation du constructeur
	 * */
	public Eleve()
	{
		this("",0,"",0,"");
	}

	/**Getters & Setters*/
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void affiche() {
		System.out.println("num "+num+" No "+ no+ " nom "+ nom +" age "+ age +" adresse "+adresse);
	}
}

