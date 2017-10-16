package fr.pizzeria.ihm;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.impl.PizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY3
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu {

	PizzaDao listpizza;
	
	public ListerPizzasOptionMenu(PizzaDao listepizza) {
		super();
		this.listpizza = listepizza;
	}

	public void execute() {
		
	//	PizzeriaAdminConsoleApp.setListpizza(new Pizza[8]);
		
		System.out.println("Liste des pizzas:");
		/*for (int i=0; i < PizzeriaAdminConsoleApp.getListpizza().length; i++)
		{
			if (PizzeriaAdminConsoleApp.getListpizza()!=null){
				System.out.println(PizzeriaAdminConsoleApp.getListpizza().toString());
			}
		}*/
		for (int i=0; i < this.listpizza.getL().size(); i++)
		{
			if (listpizza.getL()!=null){
				System.out.println(listpizza.getL().get(i).toString());
			}
		}
	}
}
