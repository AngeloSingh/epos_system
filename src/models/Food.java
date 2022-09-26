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
public class Food {//creating new class called Food
    private int foodID;
    private String foodName;
    private double price;
    private String description;
    private String image;
    private String category;
    
    //Getters
    public int getFoodID(){
        return foodID;
    
    }
    public String getFoodName(){//getters
        return foodName;
    }
    
    public double getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }
    
    
     public String getImage(){//getters
        return image;
    }
     public String getCategory(){//getters
        return category;
    }
    
//Setters
    public void setFoodID(int foodIDIn){
        foodID=foodIDIn;
    }
    public void setFoodName (String foodNameIn)//setters
    {
        foodName = foodNameIn;
    }
    public void setPrice (double priceIn)
    {
        price = priceIn;
    }
    public void setDescription(String descriptionIn){
        description=descriptionIn;
    }
    public void setImage (String imageIn)//setters
    {
        image = imageIn;
    }
    public void setCategory (String categoryIn)//setters
    {
        category = categoryIn;
    }
    

    //Constructors
    public Food (){
        foodID = 0;
        foodName = "";
        price = 0;
        description="";
        image = "";
        category="";
        
    }
    
    public Food (int foodIDIn , String foodNameIn,double priceIn, String descriptionIn,String imageIn,String categoryIn){
        
        foodID= foodIDIn;
        foodName = foodNameIn;
        price= priceIn;
        description=descriptionIn;
        image= imageIn;   
        category=categoryIn;
    }
}
