package fr.pizzeria.ihm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.impl.PizzaDaoJPA;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY3
 *
 */
public class AjouterPizzaOptionMenu extends OptionMenu {
	
	/**
	 * 
	 */
	
	PizzaDaoJPA addpizza;
	
	public static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	
	public AjouterPizzaOptionMenu(PizzaDaoJPA addpizza) {
		super();
		this.addpizza = addpizza;
	}

	public void execute() {
		
		String code = null, nom = null;
		double prix = 0;
		int categorie=0;
		
		try{
			//on remplace les syso par 
			LOG.info("Veuillez saisir le code de la pizza à ajouter: ");
			code = PizzeriaAdminConsoleApp.saisi.nextLine();
			LOG.info("Veuillez saisir le nom: ");
			nom = PizzeriaAdminConsoleApp.saisi.nextLine();
			LOG.info("Veuillez saisir le prix: ");
			prix = Double.parseDouble(PizzeriaAdminConsoleApp.saisi.nextLine());
			LOG.info("Veuillez saisir la catégorie: \n 1- Viande\n 2- Sans viande\n 3- Poisson");
			categorie= Integer.parseInt( PizzeriaAdminConsoleApp.saisi.nextLine());
			Pizza p;
			switch(categorie)
			{
				case 1: 
				case 2:
				case 3: p = new Pizza(code, nom, prix, addpizza.findCategorie(categorie));
					break;
					
				default: LOG.info("Catégorie non valide!!!");
					return;
			}
			addpizza.saveNewPizza(p);
		}catch(Exception e){
			LOG.info(e.getMessage());
		}
	
	}

}
