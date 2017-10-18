/**
 * 
 */
package fr.pizzeria.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY3
 *
 */
public interface IPizzaDao {
	
		List<Pizza> findAllPizzas() throws FileNotFoundException, IOException;
		boolean saveNewPizza(Pizza pizza) throws SavePizzaException, IOException, SQLException;
		boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException, SQLException;
		boolean deletePizza(String codePizza) throws DeletePizzaException, SQLException;
		
}
