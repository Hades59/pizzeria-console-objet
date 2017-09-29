package fr.pizzeria.ihm;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.PizzaDao;

public class ModifierPizzaOptionMenu extends OptionMenu {

	/**
	 * 
	 */
	PizzaDao modpizza;
	
	public ModifierPizzaOptionMenu(	PizzaDao modpizza) {
		super();
		this.modpizza = modpizza;
	}

	public void execute() {
		
		String code=null, newCode = null, nom=null;
		double prix = -1.0;
		
		try
		{
			System.out.println("Veuillez saisir le code de la pizza à modifier: ");
			code = PizzeriaAdminConsoleApp.saisi.nextLine();
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
		
		/*for(int i=0; i<PizzeriaAdminConsoleApp.getListpizza().length; i++)
		{
			if (PizzeriaAdminConsoleApp.listpizza[i]!=null && code.equals(PizzeriaAdminConsoleApp.listpizza[i].getCode())){
				
				if(nom == null){
					System.out.println("Veuillez saisir le nom: ");
					nom = PizzeriaAdminConsoleApp.saisi.nextLine();
				}
				if(prix < 0){
					System.out.println("Veuillez saisir le prix: ");
					prix = Double.parseDouble(PizzeriaAdminConsoleApp.saisi.nextLine());
				}
				PizzeriaAdminConsoleApp.listpizza[i].setCode(code);
				PizzeriaAdminConsoleApp.listpizza[i].setNom(nom);
				PizzeriaAdminConsoleApp.listpizza[i].setPrix(prix);
				
			}
		}*/
//		for(int i=0; i<modpizza.getL().size(); i++)
//		{
//			if (modpizza.getL()!=null && code.equals(modpizza.getL().get(i).getCode())){
//				
//				if(nom == null){
//					System.out.println("Veuillez saisir le nom: ");
//					nom = PizzeriaAdminConsoleApp.saisi.nextLine();
//				}
//				if(prix < 0){
//					System.out.println("Veuillez saisir le prix: ");
//					prix = Double.parseDouble(PizzeriaAdminConsoleApp.saisi.nextLine());
//				}
		if(newCode == null){
			System.out.println("Veuillez saisir le code: ");
			newCode = PizzeriaAdminConsoleApp.saisi.nextLine();
		}
		if(nom == null){
			System.out.println("Veuillez saisir le nom: ");
			nom = PizzeriaAdminConsoleApp.saisi.nextLine();
		}
		if(prix < 0){
			System.out.println("Veuillez saisir le prix: ");
			prix = Double.parseDouble(PizzeriaAdminConsoleApp.saisi.nextLine());
		}
				Pizza p = new Pizza(newCode, nom, prix);
				try{
				modpizza.updatePizza(code, p);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
////				modpizza.getL().get(i).setCode(code);
////				modpizza.getL().get(i).setNom(nom);
////				modpizza.getL().get(i).setPrix(prix);
//				
//			}
//		}
	}
}
