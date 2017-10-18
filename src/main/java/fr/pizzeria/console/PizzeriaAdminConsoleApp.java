package fr.pizzeria.console;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import fr.pizzeria.dao.impl.PizzaDaoJPA;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
		
	public static Scanner saisi = new Scanner(System.in);
	public static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	public static void main(String[] args) {
		
		int choix;
		Scanner saisi = new Scanner(System.in);
		PizzaDaoJPA dao = new PizzaDaoJPA();
						
		ListerPizzasOptionMenu listerPizza = new ListerPizzasOptionMenu(dao);
		AjouterPizzaOptionMenu ajouterPizza = new AjouterPizzaOptionMenu(dao);
		ModifierPizzaOptionMenu modifierPizza = new ModifierPizzaOptionMenu(dao);
		SupprimerPizzaOptionMenu supprimerPizza = new SupprimerPizzaOptionMenu(dao);
		
		do
		{
			LOG.info("\n*****Pizzeria Asministration*****\n");
			LOG.info("1 - Lister les pizzas");
			LOG.info("2 - Ajouter une nouvelle pizza");
			LOG.info("3 - Mettre à jour une pizza");
			LOG.info("4 - Supprimer une pizza");
			LOG.info("99 - Quitter");
			choix = saisi.nextInt();
			
			switch(choix)
			{
				case 1: listerPizza.execute();
						
					break;
				
				case 2: LOG.info("Ajout d'une nouvelle pizza:");
						ajouterPizza.execute();
					break;
					
				case 3: LOG.info("Mise à jour d'une pizza:");
						modifierPizza.execute();
					break;
			
				case 4: LOG.info("Suppression d'une pizza:");
						
				try {
					supprimerPizza.execute();
				} catch (DeletePizzaException e) {
					LOG.info(e.getMessage());
				}
					break;
					
				case 99: LOG.info("Au revoir \u2639");
					break;
			}
		}while (choix != 99);
		saisi.close();
	}
}
