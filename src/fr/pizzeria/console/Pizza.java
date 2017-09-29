package fr.pizzeria.console;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Pizza {
	
	private Integer id;
	private String code;
	private String nom;
	private double prix;
	NumberFormat formatter = new DecimalFormat("#0.00");
	
	/**
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(String code, String nom, double prix) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}
	
	/**
	 * @param tab
	 * @return
	 */
	public String toString(){
		return this.getCode()+" -> "+this.getNom()+" "+"("+formatter.format(this.getPrix())+"\u20ac)";		
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

}
