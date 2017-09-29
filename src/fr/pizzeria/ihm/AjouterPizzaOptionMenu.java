package fr.pizzeria.ihm;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.SavePizzaException;

/**
 * @author ETY3
 *
 */
public class AjouterPizzaOptionMenu extends OptionMenu {
	
	/**
	 * 
	 */
	
	PizzaDao addpizza;
	
	public AjouterPizzaOptionMenu(PizzaDao addpizza) {
		super();
		this.addpizza = addpizza;
	}

	public void execute() {
		
		String code = null, nom = null;
		double prix = 0;
		
		try{
			System.out.println("Veuillez saisir le code de la pizza à ajouter: ");
			code = PizzeriaAdminConsoleApp.saisi.nextLine();
			System.out.println("Veuillez saisir le nom: ");
			nom = PizzeriaAdminConsoleApp.saisi.nextLine();
			System.out.println("Veuillez saisir le prix: ");
			prix = Double.parseDouble(PizzeriaAdminConsoleApp.saisi.nextLine());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
				
		/*for (int i=0; i<PizzeriaAdminConsoleApp.getListpizza().length; i++)
		{
			if (PizzeriaAdminConsoleApp.getListpizza()[i]==null){
				PizzeriaAdminConsoleApp.getListpizza()[i] = new Pizza(code, nom, prix);
			}
		}*/
		
		Pizza p = new Pizza(code, nom, prix);
		try{
			addpizza.saveNewPizza(p);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
