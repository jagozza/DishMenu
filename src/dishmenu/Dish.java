/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dishmenu;

/**
 *
 * @author Jagoda
 */
public class Dish 
{
    public Dish(String name, String description, String price, String image)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;   
    }
    protected String name;
    protected String description;
    protected String price;
    protected String image;   
}
