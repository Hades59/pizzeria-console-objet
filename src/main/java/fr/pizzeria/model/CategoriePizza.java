/**
 * 
 */
package fr.pizzeria.model;

/**
 * @author ETY3
 *
 */
public enum CategoriePizza {
	VIANDE(1, "Viande"), SANS_VIANDE(2, "Sans Viande"), POISSON(3, "Poisson");
	int categorie;
	String libel;
	
	CategoriePizza(int cat, String lib){
		categorie = cat;
		libel = lib;
	}

	/** Getter for categorie
	 * @return the categorie
	 */
	public int getCategorie() {
		return categorie;
	}

	/** Getter for libel
	 * @return the libel
	 */
	public String getLibel() {
		return libel;
	}
	
}
