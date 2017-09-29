/**
 * 
 */
package fr.pizzeria.dao;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

/**
 * @author ETY3
 *
 */
public interface IPizzaDao {
	
		Pizza findAllPizzas();
		boolean saveNewPizza(Pizza pizza) throws SavePizzaException;
		boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
		boolean deletePizza(String codePizza) throws DeletePizzaException;
		
}
