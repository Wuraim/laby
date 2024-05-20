/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_laby;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.Stage;

/**
 *
 * @author Grégoire
 */


public class Affichage extends Stage {
    
    private Pane root;
    private Scene scene;
    private double largeurCase;
    private double longeurCase;
    
    public Affichage(){
        super();
    } 
    
    public void afficherFenetre(){
        root = new Pane();
        
        scene = new Scene(root, 700, 700);
        
        this.setTitle("Labyrinthe");
        this.setScene(scene);
    }
    
    public void afficherLabyrinthe(Labyrinthe laby, int xStart, int yStart, int xEnd, int yEnd){
        largeurCase = scene.getWidth()/laby.getWidth();
        longeurCase = scene.getHeight()/laby.getHeight();
   
        Rectangle depart = new Rectangle(5+xStart*largeurCase,5+scene.getHeight()-(yStart+1)*longeurCase,largeurCase,longeurCase);
        depart.setFill(Color.RED);
        root.getChildren().add(depart);
        
        Rectangle arrivee = new Rectangle(5+xEnd*largeurCase,5+scene.getHeight()-(yEnd+1)*longeurCase,largeurCase,longeurCase);
        arrivee.setFill(Color.BLUE);
        root.getChildren().add(arrivee);
        
        for(int j = 0; j < laby.getWidth(); j++){
            for(int i = 0; i < laby.getHeight(); i++){
                if(laby.get(i,j).getBas()){
                    Line testLine = new Line();
                    testLine.setStartX(5+i*largeurCase);
                    testLine.setStartY(5+scene.getHeight()-longeurCase*j);
                    testLine.setEndX(5+(i+1)*largeurCase);
                    testLine.setEndY(5+scene.getHeight()-longeurCase*j);
                    root.getChildren().add(testLine);
                }
                
                if(laby.get(i,j).getHaut()){
                    Line testLine = new Line();
                    testLine.setStartX(5+i*largeurCase);
                    testLine.setStartY(5+scene.getHeight()-longeurCase*(j+1));
                    testLine.setEndX(5+(i+1)*largeurCase);
                    testLine.setEndY(5+scene.getHeight()-longeurCase*(j+1));
                    root.getChildren().add(testLine);
                }
                
                if(laby.get(i,j).getGauche()){
                    Line testLine2 = new Line();
                    testLine2.setStartX(5+i*largeurCase);
                    testLine2.setStartY(5+scene.getHeight()-longeurCase*j);
                    testLine2.setEndX(5+(i)*largeurCase);
                    testLine2.setEndY(5+scene.getHeight()-longeurCase*(j+1));
                    root.getChildren().add(testLine2);
                }
                
                if(laby.get(i,j).getDroite()){
                    Line testLine2 = new Line();
                    testLine2.setStartX(5+(i+1)*largeurCase);
                    testLine2.setStartY(5+scene.getHeight()-longeurCase*j);
                    testLine2.setEndX(5+(i+1)*largeurCase);
                    testLine2.setEndY(5+scene.getHeight()-longeurCase*(j+1));
                    root.getChildren().add(testLine2);
                }
                
            }
        }
    }
    
    public void afficherRemplissage(Labyrinthe laby, int x, int y){
        
        laby.setConnection(new Coord(x,y));
        
        for(int j = 0; j < laby.getWidth(); j++){
            for(int i = 0; i < laby.getHeight(); i++){
                if(laby.get(i,j).getConnect()){
                    Rectangle co = new Rectangle(5+i*largeurCase,5+scene.getHeight()-(j+1)*longeurCase,largeurCase,longeurCase);
                    co.setFill(Color.BLUE);
                    root.getChildren().add(co);
                }
            }
        }
    }
}
