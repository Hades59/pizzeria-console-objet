package fr.pizzeria.ihm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.impl.PizzaDaoJPA;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	PizzaDaoJPA delpizza;
	public static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	public SupprimerPizzaOptionMenu(PizzaDaoJPA delpizza) {
		super();
		this.delpizza = delpizza;
	}

	public void execute() throws DeletePizzaException {

		String code = null;

		try {
			LOG.info("Veuillez saisir le code de la pizza à supprimer: ");
			code = PizzeriaAdminConsoleApp.saisi.nextLine();
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}

		try {
			delpizza.deletePizza(code);
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}
	}
}
