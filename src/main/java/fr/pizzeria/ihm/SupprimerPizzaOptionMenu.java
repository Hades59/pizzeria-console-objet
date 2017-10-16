package fr.pizzeria.ihm;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.impl.PizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	PizzaDao delpizza;
	
	public SupprimerPizzaOptionMenu(PizzaDao delpizza) {
		super();
		this.delpizza = delpizza;
	}
	public void execute() throws DeletePizzaException{
		
		String code=null;
		
		try{
			System.out.println("Veuillez saisir le code de la pizza à supprimer: ");
			code = PizzeriaAdminConsoleApp.saisi.nextLine();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		/*for(int i=0; i<PizzeriaAdminConsoleApp.getListpizza().length; i++)
		{
			if (PizzeriaAdminConsoleApp.listpizza[i]!=null && code.equals(PizzeriaAdminConsoleApp.listpizza[i].getCode())){
				
				PizzeriaAdminConsoleApp.listpizza[i] = null;				
			}
		}*/
//		for(int i=0; i<delpizza.getL().size(); i++)
//		{
//			if (delpizza.getL()!=null && code.equals(delpizza.getL().get(i).getCode())){
//				
//				delpizza.getL().remove(i);				
//			}
//		}
		try{
			delpizza.deletePizza(code);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
