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
public class Sale {//creating new class called Sale
    private Employee EmployeeUsed=new Employee();
    private Food FoodBought=new Food();
    private int AmountBought;
    
//Getters
    public Employee getEmployeeUsed(){
    
        return EmployeeUsed;
    
    }
    public Food getFoodBought(){
    
        return FoodBought;
    
    }
    public int getAmountBought(){
    
        return AmountBought;
    
    }
    
    //Setters
    public void setEmployeeUsed(Employee EmployeeUsedIn){
       
        EmployeeUsed=EmployeeUsedIn;
   
    }
    public void setFoodBought(Food FoodBoughtIn){
        
        FoodBought=FoodBoughtIn;
   
    }
    public void setAmountBought(int AmountBoughtIn){
        
        AmountBought=AmountBoughtIn;
    
    }
    //Constructors
    public Sale(){
    
    EmployeeUsed=new Employee();
    FoodBought=new Food();
    AmountBought=0;
    
    }
   
    public Sale(Employee EmployeeUsedIn,Food FoodBoughtIn,int AmountBoughtIn){
       
        EmployeeUsed=EmployeeUsedIn;
        FoodBought=FoodBoughtIn;
        AmountBought=AmountBoughtIn;
    
    }
    
    
    
    
    
    
}
