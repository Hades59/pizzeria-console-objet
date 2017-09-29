package fr.pizzeria.console;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;

public class PizzeriaAdminConsoleApp {
	
	//public static Pizza  listpizza;
	
	//public static int[] Tab = new int[0];
	
	public static Scanner saisi = new Scanner(System.in);
	
	//public static List<Pizza> l;

	public static void main(String[] args) {
		
		//listPizza();
		int choix;
		Scanner saisi = new Scanner(System.in);
		PizzaDao dao = new PizzaDao();
						
		ListerPizzasOptionMenu listerPizza = new ListerPizzasOptionMenu(dao);
		AjouterPizzaOptionMenu ajouterPizza = new AjouterPizzaOptionMenu(dao);
		ModifierPizzaOptionMenu modifierPizza = new ModifierPizzaOptionMenu(dao);
		SupprimerPizzaOptionMenu supprimerPizza = new SupprimerPizzaOptionMenu(dao);
		
		do
		{
			System.out.println("\n*****Pizzeria Asministration*****\n");
			System.out.println("1 - Lister les pizzas");
			System.out.println("2 - Ajouter une nouvelle pizza");
			System.out.println("3 - Mettre à jour une pizza");
			System.out.println("4 - Supprimer une pizza");
			System.out.println("99 - Quitter");
			choix = saisi.nextInt();
			
			switch(choix)
			{
				case 1: //System.out.println("Liste des pizzas:");
						/*for(int i=0; i < getListpizza().length; i++)
						{
							System.out.println(getListpizza()[i].toString());
						}*/
						listerPizza.execute();
						
						/*for(int i=0; i<l.size(); i++){
							//System.out.println(i+" :"+l.get(i));
							System.out.println(l.get(i).toString());
						}*/
					break;
				
				case 2: System.out.println("Ajout d'une nouvelle pizza:");
						//addPizza();
						ajouterPizza.execute();
					break;
					
				case 3: System.out.println("Mise à jour d'une pizza:");
						/*for(int i=0; i < getListpizza().length; i++)
						{
							System.out.println(getListpizza()[i].toString());
						}*/
						//modPizza();
						modifierPizza.execute();
					break;
			
				case 4: System.out.println("Suppression d'une pizza:");
						/*for(int i=0; i < getListpizza().length; i++)
						{
							System.out.println(getListpizza()[i].toString());
						}*/
						//delPizza();
				try {
					supprimerPizza.execute();
				} catch (DeletePizzaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
					
				case 99: System.out.println("Au revoir \u2639");
					break;
			}
		}while (choix != 99);
		saisi.close();
	}
	
	//Méthode liste initial Menu
	/*private static void listPizza() {
		//PizzeriaAdminConsoleApp.setListpizza(new Pizza[50]);
		l = new LinkedList<Pizza>();
		l.add(new Pizza("PEP","Pépéroni",12.5));
		l.add(new Pizza("MAR","Margherita",14));
		l.add(new Pizza("REIN","La Reine",11.5));
		l.add(new Pizza("FRO","La 4 fromages",12));
		l.add(new Pizza("CAN","La cannibale",12.5));
		l.add(new Pizza("SAV","La savoyarde",13));
		l.add(new Pizza("ORI","L'orientale",13.5));
		l.add(new Pizza("IND","L'indienne",14));
		
		
		
	}*/
	
	//Méthode ajout Pizza
	/*private static void addPizza() {
		//Pizza[] tab = new Pizza[getListpizza().length + 1];
		String code, nom;
		double prix;
		
		System.out.println("Veuillez saisir le code de la pizza à ajouter: ");
		code = saisi.nextLine();
		System.out.println("Veuillez saisir le nom: ");
		nom = saisi.nextLine();
		System.out.println("Veuillez saisir le prix: ");
		prix = Double.parseDouble(saisi.nextLine());
		
		Pizza p = new Pizza(code, nom, prix);
		
		l.add(p);
		
		/*for(int i=0; i<getListpizza().length; i++)
		{
			tab[i]=getListpizza()[i];
		}
		tab[tab.length-1] = new Pizza(code, nom, prix);
		setListpizza(tab);
	}*/
	
	//Méthode Modif Pizza
	/*private static void modPizza() {
		//Pizza[] tab = new Pizza[getListpizza().length + 1];
		String code=null, nom=null;
		double prix = -1.0;
		
		System.out.println("Veuillez saisir le code de la pizza à modifier: ");
		code = saisi.nextLine();
		
		//for(int i=0; i<getListpizza().length; i++)
		for(int i=0; i<l.size(); i++)
		{
			//if(code.equals(listpizza[i].getCode()))
			if(code.equals(l.get(i).getCode()))
			{	
				if(nom == null){
					System.out.println("Veuillez saisir le nom: ");
					nom = saisi.nextLine();
				}
				if(prix < 0){
					System.out.println("Veuillez saisir le prix: ");
					prix = Double.parseDouble(saisi.nextLine());
				}
				/*listpizza[i].setCode(code);
				listpizza[i].setNom(nom);
				listpizza[i].setPrix(prix);
				l.get(i).setCode(code);
				l.get(i).setNom(nom);
				l.get(i).setPrix(prix);
								
			}
//			else{
//				for(i=0; i<getListpizza().length; i++)
//				{
//					listpizza[i]=getListpizza()[i];
//				}
//				listpizza[listpizza.length-1] = new Pizza(code, nom, prix);
//				setListpizza(listpizza);
//			}
		}
	}*/
	
	//Supprimer une pizza
	/*private static void delPizza() {
		String code=null, nom=null;
		double prix = -1.0;
		
		System.out.println("Veuillez saisir le code de la pizza à supprimer: ");
		code = saisi.nextLine();
		
		//for(int i=0; i<getListpizza().length; i++)
		for(int i=0; i<l.size(); i++)
		{
			//if(code.equals(listpizza[i].getCode()))
			if(code.equals(l.get(i).getCode()))
			{				
				l.remove(i);				
			}
		}
	}*/

//	/**
//	 * @return the listpizza
//	 */
//	public static Pizza getListpizza() {
//		return listpizza;
//	}
//
//	/**
//	 * @param listpizza the listpizza to set
//	 */
//	public static void setListpizza(Pizza listpizza) {
//		PizzeriaAdminConsoleApp.listpizza = listpizza;
//	}

}
