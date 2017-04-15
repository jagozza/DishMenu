/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dishmenu;

import java.io.InputStream;
import java.util.ArrayList;
import static java.util.Arrays.stream;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Jagoda
 */
public class DishViewing extends Stage 
{
    public DishViewing()
    {
        
        InputStream is = DishMenu.class.getClassLoader().getResourceAsStream("resources/config.txt");
        int counter = 0; 
        this.arrDish = new ArrayList<Dish>();
        
        try
        {
            Scanner input = new Scanner (is);
            while (input.hasNext())
            {
                //Scanner(InputStream is)
                String x = input.nextLine();
                System.out.println(x);
                counter = counter + 1; //this counts how many lines there are in the file
            }
            InputStream is2 = DishMenu.class.getClassLoader().getResourceAsStream("resources/config.txt");
            Scanner scannerY = new Scanner (is2);
            int i = 0;
            while(scannerY.hasNext()) //as long as the list has another line of code then perform this 
            {
                String x1 = scannerY.nextLine();
                String x2 = scannerY.nextLine();
                String x3 = scannerY.nextLine();
                String x4 = scannerY.nextLine();
                
                Dish dish1 = new Dish(x1,x2,x3,x4); //creating one dish object
                //that dish object will contain name,description,price,image
                this.arrDish.add(dish1);
                
                System.out.println(dish1.price);
            }    
            
        }catch(Exception exc){
            System.err.println(exc);
        }
        
        
        
        
        sp = new ScrollPane(); //these few lines below create the window screen 
        gp = new GridPane();   //in which the other stuff will be put into
        
        sp.setContent(gp);
        instance = this;
        Scene scene = new Scene(sp, 1220, 485);
        this.setScene(scene);
       
    }

    public void initScreen()
    {
        
    this.lblname = new Label(arrDish.get(idx).name);
    this.lbldescription = new Label(arrDish.get(idx).description);
    this.lblprice = new Label(arrDish.get(idx).price);  
    this.im = new ImageView();
    final String resourcesPath = "resources/" + arrDish.get(idx).image; //grabbing file
        InputStream stream = DishViewing.class.getClassLoader().getResourceAsStream(resourcesPath);
    //ImageView imageView = new ImageView(stream);
    final Image image2 = new Image(stream);
    //stream
    im.setImage(image2);
    //FileInputStream input = new FileInputStream("resources/images/" + curDish);
    //Image image = new Image(input);
    //ImageView imageView = new ImageView(image);
    
    //Hbox = hbox = new HBox(imageView);
    
    //this.lblimage = new Label(is2.get(idx).image); //is2 - scannerY
    //this will contain all the standard window for all the dishes 
    this.gp.add(lblname,0,0);
    this.gp.add(lbldescription,1,1,1,2);
    this.gp.add(lblprice,1,3);
    this.gp.add(im,0,1,1,2); 
      
    Button btnPrev = new Button();
        btnPrev.setText("Prev");
        gp.add(btnPrev,0,4);
        btnPrev.setOnAction(new EventHandler<ActionEvent>() 
        {            
                @Override
                public void handle(ActionEvent event) 
                {
                    if(idx == 0)//this is when we are on the welcome page and there is no previous
                    {
                        refresh();
                    }
                    else //if there is actually a previous dish
                    {
                        idx = idx - 1;//going to the previous dish
                        refresh();
                    }
                }
        });
        
        
        Button btnNext = new Button();
        btnNext.setText("Next");
        gp.add(btnNext,1,4); // last possible space in the window or 1,4
        btnNext.setOnAction(new EventHandler<ActionEvent>() 
        {            
                @Override
                public void handle(ActionEvent event) 
                {
                    if(idx<3)//if less than 3 then we can still go onto next dish
                    {
                        idx = idx + 1;//going onto the next dish
                        refresh();
                    }
                    else //if more than 4 then we have to reset because there is no more dishes after that 
                    {
                        idx = 0; //index is reset to zero
                        refresh();
                    }
                }
        });    
    }
    
    
    public void refresh()//without any parameters 
    {
        //embed media files in .jar files
        //grab file 
        //put that file in the image creation (image object)
        //place image creation in image box
        Dish curDish = this.arrDish.get(this.idx);//this is getting the current dish
        final String resourcesPath = "resources/" + curDish.image; //grabbing file
        System.out.println(resourcesPath);
        InputStream stream = DishViewing.class.getClassLoader().getResourceAsStream(resourcesPath);
        //these are resetting current controls
        this.lblname.setText(curDish.name); 
        this.lbldescription.setText(curDish.description);
        this.lblprice.setText(curDish.price);
        //final String resourcesPath = "resources/images/" + curDish.image; //grabbing file
        //InputStream stream = DishMenu.class.getResourceAsStream(resourcesPath);
        //ImageView imageView = new ImageView(stream);
        final Image image2 = new Image(stream);
        //stream
        im.setImage(image2);
    }
    //DATA MEMBERS:
    protected ArrayList<Dish> arrDish;
    protected ScrollPane sp;
    protected GridPane gp;
    static DishViewing instance = null;
    protected Label lblname;
    protected Label lbldescription;
    protected Label lblprice;
    protected ImageView im; 
    //protected Label lblimage;
    
    protected int idx = 0;
}
