package fr.pizzeria.ihm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.impl.PizzaDaoJPA;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {

	/**
	 * 
	 */
	PizzaDaoJPA modpizza;

	public static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	public ModifierPizzaOptionMenu(	PizzaDaoJPA modpizza) {
		super();
		this.modpizza = modpizza;
	}

	public void execute() {

		String code = null, newCode = null, nom = null;
		double prix = -1.0;
		int categorie =0;

		try
		{
			LOG.info("Veuillez saisir le code de la pizza à modifier: ");
			code = PizzeriaAdminConsoleApp.saisi.nextLine();
		}catch(Exception e){
			LOG.info(e.getMessage());
		}

		if(newCode == null){
			LOG.info("Veuillez saisir le code: ");
			newCode = PizzeriaAdminConsoleApp.saisi.nextLine();
		}
		if(nom == null){
			LOG.info("Veuillez saisir le nom: ");
			nom = PizzeriaAdminConsoleApp.saisi.nextLine();
		}
		if(prix < 0){
			LOG.info("Veuillez saisir le prix: ");
			prix = Double.parseDouble(PizzeriaAdminConsoleApp.saisi.nextLine());
		}
				
		categorie= Integer.parseInt( PizzeriaAdminConsoleApp.saisi.nextLine());
		Pizza p;
		switch(categorie)
		{
			case 1: 
			case 2: 				
			case 3: p = new Pizza(code, nom, prix, modpizza.findCategorie(categorie));
				break;
				
			default: LOG.info("Catégorie non valide!!!");
				return;
		}
		
		try{
			modpizza.updatePizza(code, p);
		}catch(Exception e){
			LOG.info(e.getMessage());
		}
	}
}
