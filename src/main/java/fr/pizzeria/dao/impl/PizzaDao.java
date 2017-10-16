/**
 * 
 */
package fr.pizzeria.dao.impl;

import java.util.LinkedList;
import java.util.List;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY3
 *
 */
public class PizzaDao implements IPizzaDao {

	private List<Pizza> l;

	/**
	 * @return the l
	 */
	public List<Pizza> getL() {
		return l;
	}

	/**
	 * @param l the l to set
	 */
	public void setL(List<Pizza> l) {
		this.l = l;
	}

	public PizzaDao() {
		
		l = new LinkedList<Pizza>();
		l.add(new Pizza("PEP", "Pépéroni", 12.5, CategoriePizza.VIANDE));
		l.add(new Pizza("MAR", "Margherita", 14, CategoriePizza.SANS_VIANDE));
		l.add(new Pizza("REIN", "La Reine", 11.5, CategoriePizza.VIANDE));
		l.add(new Pizza("FRO", "La 4 fromages", 12, CategoriePizza.SANS_VIANDE));
		l.add(new Pizza("CAN", "La cannibale", 12.5, CategoriePizza.VIANDE));
		l.add(new Pizza("SAV", "La savoyarde", 13, CategoriePizza.VIANDE));
		l.add(new Pizza("ORI", "L'orientale", 13.5, CategoriePizza.VIANDE));
		l.add(new Pizza("IND", "L'indienne", 14, CategoriePizza.VIANDE));
	}

	/**
	 * @param args
	 */


//	@Override
	public Pizza findAllPizzas() {
		return null;
	}

//	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		if(pizza == null){
			throw new SavePizzaException("Pas de pizza rentrée");
		}
		l.add(pizza);
		return false;
	}

//	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		if(pizza == null){
			throw new UpdatePizzaException("Pas de pizza à modifier");
		}	
		for(int i=0; i<l.size(); i++)
		{
			if (l.get(i)!=null && codePizza.equals(l.get(i).getCode())){
				
				l.get(i).setCode(pizza.getCode());
				l.get(i).setNom(pizza.getNom());
				l.get(i).setPrix(pizza.getPrix());
				l.get(i).setCategorie(pizza.getCategorie());
				return true;
			}
		}
		throw new UpdatePizzaException("Pas de pizza à ce code");
	}

//	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		if(codePizza == null){
			throw new DeletePizzaException("Pas de pizza à supprimer");
		}	
		
		for(int i=0; i<l.size(); i++)
		{
			if (l.get(i)!=null && codePizza.equals(l.get(i).getCode())){
				
				l.remove(i);				
			}
		}
		throw new DeletePizzaException("Pas de pizza à ce code");
	}

}
