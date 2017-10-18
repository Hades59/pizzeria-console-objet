package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "NOM_CATE", length = 20, nullable = false, unique = true)
	private String nomCate;
	
	@OneToMany(mappedBy = "categorie")
	private Set<Pizza> pizza;
	
	public Categorie(){
		
	}

	/** Getter for id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Setter for id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter for nomCate
	 * @return the nomCate
	 */
	public String getNomCate() {
		return nomCate;
	}

	/** Setter for nomCate
	 * @param nomCate the nomCate to set
	 */
	public void setNomCate(String nomCate) {
		this.nomCate = nomCate;
	}
}
