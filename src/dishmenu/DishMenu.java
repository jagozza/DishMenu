/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dishmenu;

import com.sun.javaws.Main;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Jagoda
 */
public class DishMenu extends Application 
{
     public static void main(String[] args) 
    {
        launch(args);
    }
     
    protected Scanner s; //looking through 
    
    @Override
    public void start(Stage primaryStage) 
    {
        
        
        //This will create a window with 
        //Tab that says "SmartRestaurant Table 2"
        //Inside the window a button: "WELCOME TO SMARTRESTAURANT! Click here to enter the MENU
        primaryStage.setTitle("SmartRestaurant Table 2");
        Button btn = new Button();
        btn.setText("WELCOME TO SMARTRESTAURANT! Click here to enter the MENU");
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                DishViewing mys = new DishViewing();//pass a list of dishes here 
                mys.initScreen();//we want an empty screen with the standard things on it
                //mys.refresh();
                mys.showAndWait();
                System.out.println("SmartRestaurant Table 2");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 500, 250));
        primaryStage.show();
        
        
    }  
}