package fr.pizzeria.ihm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.impl.PizzaDaoJPA;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY3
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu {

	PizzaDaoJPA listpizza;
	public static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	public ListerPizzasOptionMenu(PizzaDaoJPA listepizza) {
		super();
		this.listpizza = listepizza;
	}

	public void execute() {
		
		LOG.info("Liste des pizzas:");
		
		for (int i=0; i < this.listpizza.getL().size(); i++)
		{
			if (listpizza.getL()!=null){
				LOG.info(listpizza.getL().get(i).toString());
			}
		}
	}
}
