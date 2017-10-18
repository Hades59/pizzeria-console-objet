/**
 * 
 */
package fr.pizzeria.dao.impl;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Categorie;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY3
 *
 */
public class PizzaDaoJPA implements IPizzaDao {

	EntityManagerFactory emf;

	public PizzaDaoJPA() {
		super();
		emf = Persistence.createEntityManagerFactory("pizzeria");
	}

	/**
	 * @param args
	 */


//	@Override
	public List<Pizza> findAllPizzas() {
		return null;
	}

//	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		EntityManager em = emf.createEntityManager();
		return false;
	}

//	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		return false;		
	}

//	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		return false;		
	}
	
	public Categorie findCategorie(int id){
		
		EntityManager em = emf.createEntityManager();
		Categorie categorie = em.find(Categorie.class, id);
		
		em.close();
		
		return categorie;
	}
}
