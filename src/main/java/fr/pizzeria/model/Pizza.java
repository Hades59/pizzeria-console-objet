package fr.pizzeria.model;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "code", length = 10, nullable = false, unique = true)
	private String code;
	@Column(name = "nom", length = 30, nullable = false, unique = true)
	private String nom;
	@Column(name = "prix", nullable = false, unique = true)
	private double prix;
	NumberFormat formatter = new DecimalFormat("#0.00");
	
	@ManyToOne
	@JoinColumn(name = "categorie")
	private Categorie categorie;

	/**
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categorie
	 */
	public Pizza(){
		
	}
	
	public Pizza(String code, String nom, double prix, Categorie categorie) {
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
	public Categorie getCategorie() {
		return categorie;
	}

	/** Setter for categorie
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
