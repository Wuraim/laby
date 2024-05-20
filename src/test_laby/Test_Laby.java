/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_laby;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author lorgn
 */

public class Test_Laby extends Application {      
    
    @Override
    public void start(Stage primaryStage) {
       
       Affichage aff = new Affichage(); 
       aff.afficherFenetre();
       
        Labyrinthe laby = new Labyrinthe(100,100);
       
        int xStart = (int) (Math.random() * (laby.getWidth() - 1)) + 0; 
        int yStart = (int) (Math.random() * (laby.getHeight() - 1)) + 0;
        
        int xEnd = (int) (Math.random() * (laby.getWidth() - 1)) + 0; 
        int yEnd = (int) (Math.random() * (laby.getHeight() - 1)) + 0;
        
        while(xEnd == xStart && yEnd == yStart){// Au cas où la case départ est la même que la case de fin
            xEnd = (int) (Math.random() * (laby.getWidth() - 1)) + 0; 
            yEnd = (int) (Math.random() * (laby.getHeight() - 1)) + 0;
        }
                
        laby.maze(new Coord(xStart,yStart));
        
        aff.afficherLabyrinthe(laby,xStart,yStart, xEnd, yStart);
        
        //aff.afficherRemplissage(laby,xStart,yStart); //Si on souhaite si toute les ca
        
        aff.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args); 
    }
    
}
