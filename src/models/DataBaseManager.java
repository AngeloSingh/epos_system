/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//
public class DataBaseManager {

	private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver"; // Global variable accessible throughout the
																			// whole class
	private final String connectionString = "jdbc:ucanaccess://D:\\EPOS Project\\EmployeeDB.accdb";// Global variable
																									// accessible
																									// throughout the
																									// whole class
																									// specifying the
																									// path of the
																									// database

	public Food loadFood(int foodID) {// foodID is passed into this function

		Food foodToLoad = null;// creating a null object called foodToLoad

		try {// defines the following block of code to be tested for errors while it is being
				// executed.

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM Food WHERE FoodID=" + foodID);// Running SQL select
																							// statement

			while (rs.next()) {

				// Stores the value in brackets from the database into the declared variable
				int DBfoodID = rs.getInt("FoodID");
				String foodName = rs.getString("FoodName");
				double price = rs.getInt("Price");
				String description = rs.getString("Description");
				String image = rs.getString("Image");
				String category = rs.getString("Category");

				foodToLoad = new Food(DBfoodID, foodName, price, description, image, category);// creating foodToLoad
																								// object containing the
																								// variables extrated
																								// previously from the
																								// database

				// Sale sale= new Sale (EmployeeUsedIn,Food FoodBoughtIn,int AmountBoughtIn);
			}
			conn.close();
		} catch (Exception ex) {// If any error is detected in the try section it will be "catched" here and
								// stored as "ex"
			System.out.println("Login error: " + ex.getMessage());// Displaying an error message followed by exact error
																	// details
		} finally {
			return foodToLoad;
		}

	}

	public List<Sale> loadSale(int employeeNumber) {
		List<Sale> sales = new ArrayList();

		try {// defines the following block of code to be tested for errors while it is being
				// executed.

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM Sales WHERE Employee=" + employeeNumber);// Running SQL
																										// select
																										// statement

			while (rs.next()) {
				// Stores the value in brackets from the database into the declared variable
				int saleID = rs.getInt("SalesID");
				int employeeID = rs.getInt("Employee");
				int foodId = rs.getInt("Food");
				int quantity = rs.getInt("Quantity");

				Employee LoadEmployee = LoadEmployee(employeeID);
				Food LoadFood = loadFood(foodId);

				Sale loadedSales = new Sale(LoadEmployee, LoadFood, quantity);// creating loadedSales object containing
																				// the variables extrated previously
																				// from the database

				sales.add(loadedSales);
			}

			conn.close();// close connection between program and database

		} catch (Exception ex) {// If any error is detected in the try section it will be "catched" here and
								// stored as "ex"

			System.out.println("Loading error: " + ex.getMessage());// Displaying an error message followed by exact
																	// error details

		} finally {

			return sales;
		}
	}

	public void selectQuantities(Sale sale) {

		try {// defines the following block of code to be tested for errors while it is being
				// executed.

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("INSERT INTO Sales(Employee,Food,Quantity) VALUES " // Running SQL insert statement
					+ "( " + sale.getEmployeeUsed().getEmployeeNumber() + "," + sale.getFoodBought().getFoodID() + ","
					+ sale.getAmountBought() + ")");
			conn.close();// close connection between program and database

		} catch (Exception ex) {// If any error is detected in the try section it will be "catched" here and
								// stored as "ex"
			System.out.println("Error_writing new Quantity to DB" + ex.getMessage());// Displaying an error message
																						// followed by exact error
																						// details

		}

	}

	public List<Food> LoadAllFood() {// returns list of food
		List<Food> food = new ArrayList();// loads all food as list(collection/dynamic array)
		try {// defines the following block of code to be tested for errors while it is being
				// executed.
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM Food ");// SQL select statement
			while (rs.next()) {// for each selected value in the database

				int foodID = rs.getInt("FoodID"); // Stores the value in brackets from the database into the declared
													// variable
				String foodName = rs.getString("FoodName"); // Stores the value in brackets from the database into the
															// declared variable
				double price = rs.getInt("Price"); // Stores the value in brackets from the database into the declared
													// variable
				String description = rs.getString("Description"); // Stores the value in brackets from the database into
																	// the declared variable
				String image = rs.getString("Image"); // Stores the value in brackets from the database into the
														// declared variable
				String category = rs.getString("Category"); // Stores the value in brackets from the database into the
															// declared variable

				Food foodInDB = new Food(foodID, foodName, price, description, image, category);// creating a new object
																								// called foodInDB
																								// storing all the
																								// variables taken from
																								// the database

				food.add(foodInDB);// list .add(value)

			}
			conn.close();// closing connection between this program and the database
		} catch (Exception ex)// If any error is detected in the try section it will be "catched" here and
								// stored as "ex"
		{
			System.out.println("Error-loading food from DB" + ex.getMessage()); // Displaying an error message followed
																				// by exact error details
		} finally {
			return food;// returns food object

		}
	}

	public void updateEmployee(Employee employee) {

		try {// defines the following block of code to be tested for errors while it is being
				// executed.

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("UPDATE Employee SET FirstName='" + employee.getFirstName() // Running SQL update
																							// statement
					+ "', LastName ='" + employee.getLastName() + "', Password='" + employee.getPassword()
					+ "', Role= '" + employee.getRole() + "'" + "WHERE EmployeeNo= " + employee.getEmployeeNumber());

		} catch (Exception ex) {// If any error is detected in the try section it will be "catched" here and
								// stored as "ex"
			System.out.println("Error_writing new Person to DB" + ex.getMessage());// Displaying an error message
																					// followed by exact error details

		}
	}

	public Employee LoadEmployee(int EmployeeNumber) {
		Employee employeeInDB = null;
		try {// defines the following block of code to be tested for errors while it is being
				// executed.
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM Employee WHERE EmployeeNo= " + EmployeeNumber);// Running
																											// SQL
																											// select
																											// statement
			while (rs.next()) {// for each selected value in the database
				// Stores the value in brackets from the database into the declared variable
				int employeeNumber = rs.getInt("EmployeeNo");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String password = rs.getString("Password");
				String role = rs.getString("Role");

				employeeInDB = new Employee(employeeNumber, firstName, lastName, password, role);// creating
																									// emlpoyeeInDB
																									// object containing
																									// the variables
																									// extrated
																									// previously from
																									// the database

			}
			conn.close();// close connection between program and database

		} catch (Exception ex) {// If any error is detected in the try section it will be "catched" here and
								// stored as "ex"

			System.out.println("Error-attemting to load person from DB: " + ex.getMessage());// Displaying an error
																								// message followed by
																								// exact error details
		} finally {
			return employeeInDB;// returns employeeInDB object
		}

	}

	public void deleteEmployee(int EmployeeNumber) {
		try {// defines the following block of code to be tested for errors while it is being
				// executed.
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("DELETE FROM Employee WHERE EmployeeNo= " + EmployeeNumber);
			conn.close();// close connection between program and database
		} catch (Exception ex) {// If any error is detected in the try section it will be "catched" here and
								// stored as "ex"
			System.out.println("Error Deleting" + ex.getMessage());
			;// Displaying an error message followed by exact error details
		}
	}

	public void addEmployee(Employee employee) {
		try {// defines the following block of code to be tested for errors while it is being
				// executed.
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("INSERT INTO Employee(EmployeeNo,FirstName,LastName,Password,Role) " + " VALUES ( "
					+ employee.getEmployeeNumber() + ", '" + employee.getFirstName() + "', '" + employee.getLastName()
					+ "', '" + employee.getPassword() + "', '" + employee.getRole() + "')");
			conn.close();// close connection between program and database

		} catch (Exception ex) {// If any error is detected in the try section it will be "catched" here and
								// stored as "ex"

			System.out.println("Error into writing in the database" + ex.getMessage());
			;// Displaying an error message followed by exact error details

		}

	}

	public Employee employeeLogin(int employeeNo, String Password) {
		Employee loggedInEmployee = null; // create an empty object called loggedInEmployee

		try {// defines the following block of code to be tested for errors while it is being
				// executed.
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM Employee WHERE EmployeeNo=" + employeeNo + " AND Password= '" + Password + "'");// Running
																													// SQL
																													// Sselect
																													// statement
																													// into
																													// the
																													// database

			while (rs.next()) {// for each selected value in the database
				int employeeNom = rs.getInt("EmployeeNo");
				String FName = rs.getString("FirstName");
				String LName = rs.getString("LastName");
				String PWord = rs.getString("Password");
				String TheRole = rs.getString("Role");

				loggedInEmployee = new Employee(employeeNom, FName, LName, PWord, TheRole);// creating loggedInEmployee
																							// object containing the
																							// variables extrated
																							// previously from the
																							// database

			}
			conn.close();// close connection between program and database
		} catch (Exception ex) {// If any error is detected in the try section it will be "catched" here and
								// stored as "ex"
			System.out.println("Login error: " + ex.getMessage());
			;// Displaying an error message followed by exact error details
		} finally {
			return loggedInEmployee;// returns loggedInEmployee object
		}
	}

}