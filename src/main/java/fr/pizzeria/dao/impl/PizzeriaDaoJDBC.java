/**
 * 
 */
package fr.pizzeria.dao.impl;

import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author ETY3
 *
 */
public class PizzeriaDaoJDBC implements IPizzaDao {

	/**
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * 
	 */
	Connection conn ;
	public static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	public Connection connection() {
		try {
			
			Properties prop = new Properties();
			InputStream input = null;
			
			input = new FileInputStream("src/main/resources/jdbc.properties");
			
			prop.load(input);
			
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.username"), prop.getProperty("jdbc.password"));

		} catch (ClassNotFoundException | SQLException e) {
			LOG.info(e.getMessage());
		}
		return conn;
	}

	@Override
	public List<Pizza> findAllPizzas() {
		
		try {
			Connection conn = connection();
			PreparedStatement selectPizzaSt = conn.prepareStatement("SELECT * FROM pizza");
			selectPizzaSt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.info(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		Connection conn = connection();
		PreparedStatement insertPizzaST = conn.prepareStatement("INSERT INTO pizza(code, nom, prix, categorie VALUES (?,?,?,?)");
		insertPizzaST.setString(1, pizza.getCode());
		insertPizzaST.setString(2, pizza.getNom());
		insertPizzaST.setDouble(3, pizza.getPrix());
		insertPizzaST.setInt(4, pizza.getCategorie());
		
		if(pizza == null){
			throw new SavePizzaException("Pas de pizza rentrée");
		}
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		int updatePizzaST = statement.executeUpdate();
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		int delPizzaSt = statement.executeUpdate("SELECT * FROM pizza WHERE code = ?");
		return false;
	}

}
