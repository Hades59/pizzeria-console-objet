package fr.pizzeria.model;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Pizza {
	
	private Integer id;
	private String code;
	private String nom;
	private double prix;
	NumberFormat formatter = new DecimalFormat("#0.00");
	int categorie;

	/**
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categorie
	 */
	public Pizza(String code, String nom, double prix, int categorie) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	/**
	 * @param tab
	 * @return
	 */
	public String toString(){
		return this.getCode()+" -> "+this.getNom()+" "+"("+formatter.format(this.getPrix())+"\u20ac) "+this.getCategorie();		
	}
	
	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	/** Getter for categorie
	 * @return the categorie
	 */
	public CategoriePizza getCategorie() {
		return categorie;
	}

	/** Setter for categorie
	 * @param categorie the categorie to set
	 */
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

}
