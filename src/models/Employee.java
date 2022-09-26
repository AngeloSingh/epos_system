/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Angelo Singh
 */
public class Employee {//creating Employee class
    private int employeeNumber;
    private String firstName;
    private String lastName;
    private String password;
    private String role;


    public int getEmployeeNumber(){//getters
        return employeeNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }
    
    //setters//
    public void setEmployeeNumber (int employeeNumberIn)//setters
    {
        employeeNumber = employeeNumberIn;
    }
    public void setFirstName (String firstNameIn)
    {
        firstName = firstNameIn;
    }
    public void setLastName (String lastNameIn)
    {
        lastName = lastNameIn;
    }
    public void setPassword (String passwordIn)
    {
        password = passwordIn;
    }
    public void setRole (String roleIn)
    {
        role = roleIn;
    }

    //Constructors 
    public Employee ()
    {
        employeeNumber = 0;
        firstName = "";
        lastName = "";
        password = "";
        role = "";    
    }
    public Employee (int employeeNumberIn, String firstNameIn, String lastNameIn, String passwordIn, String roleIn)
    {
        employeeNumber = employeeNumberIn;
        firstName = firstNameIn;
        lastName = lastNameIn;
        password = passwordIn;
        role = roleIn;    
    }
}
