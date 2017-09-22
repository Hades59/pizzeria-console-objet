package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.console.*;

public class PizzeriaAdminConsoleApp {
	
	private static Pizza [] listpizza;
	
	public static int[] Tab = new int[0];
	
	public static Scanner saisi = new Scanner(System.in);
	public static void main(String[] args) {

		listPizza();
		int choix, ajout;
		Scanner saisi = new Scanner(System.in);
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
				case 1: System.out.println("Liste des pizzas:");
						for(int i=0; i < listpizza.length; i++)
						{
							System.out.println(listpizza[i].toString());
						}
					break;
				
				case 2: System.out.println("Ajout d'une nouvelle pizza:");
						addPizza();
					break;
					
				case 3: System.out.println("Mise à jour d'une pizza:");
						for(int i=0; i < listpizza.length; i++)
						{
							System.out.println(listpizza[i].toString());
						}
						ModPizza();
					break;
			
				/*case 4: System.out.println("Suppression d'une pizza:");
						ajout = questionUser.nextInt();
						addTab(ajout);
					break;*/
					
				case 99: System.out.println("Au revoir \u2639");
					break;
			}
		}while (choix != 99);
		saisi.close();
	}
	
	//Méthode liste initial Menu
	private static void listPizza() {
		
		PizzeriaAdminConsoleApp.listpizza = new Pizza[8];
		
		PizzeriaAdminConsoleApp.listpizza[0] = new Pizza("PEP","Pépéroni",12.5);
		PizzeriaAdminConsoleApp.listpizza[1] = new Pizza("MAR","Margherita",14);
		PizzeriaAdminConsoleApp.listpizza[2] = new Pizza("REIN","La Reine",11.5);
		PizzeriaAdminConsoleApp.listpizza[3] = new Pizza("FRO","La 4 fromages",12);
		PizzeriaAdminConsoleApp.listpizza[4] = new Pizza("CAN","La cannibale",12.5);
		PizzeriaAdminConsoleApp.listpizza[5] = new Pizza("SAV","La savoyarde",13);
		PizzeriaAdminConsoleApp.listpizza[6] = new Pizza("ORI","L'orientale",13.5);
		PizzeriaAdminConsoleApp.listpizza[7] = new Pizza("IND","L'indienne",14);	
	}
	
	//Méthode ajout Pizza
	private static void addPizza() {
		Pizza[] tab = new Pizza[listpizza.length + 1];
		String code, nom;
		double prix;
		
		System.out.println("Veuillez saisir le code de la pizza à ajouter: ");
		code = saisi.nextLine();
		System.out.println("Veuillez saisir le nom: ");
		nom = saisi.nextLine();
		System.out.println("Veuillez saisir le prix: ");
		prix = Double.parseDouble(saisi.nextLine());
		
		for(int i=0; i<listpizza.length; i++)
		{
			tab[i]=listpizza[i];
		}
		tab[tab.length-1] = new Pizza(code, nom, prix);
		listpizza=tab;
	}
	
	//Méthode Modif Pizza
	private static void ModPizza() {
		Pizza[] tab = new Pizza[listpizza.length + 1];
		String code=null, nom=null;
		double prix = -1.0;
		
		System.out.println("Veuillez saisir le code de la pizza à modifier: ");
		code = saisi.nextLine();

		if(code == null){
			System.out.println("Veuillez saisir le code: ");
			code = saisi.nextLine();	
		}
		if(nom == null){
			System.out.println("Veuillez saisir le nom: ");
			nom = saisi.nextLine();
		}
		if(prix < 0){
			System.out.println("Veuillez saisir le prix: ");
			prix = Double.parseDouble(saisi.nextLine());
		}else{
			for(int i=0; i<listpizza.length; i++)
			{
				tab[i]=listpizza[i];
			}
			tab[tab.length-1] = new Pizza(code, nom, prix);
			listpizza=tab;
		}
	}

}
