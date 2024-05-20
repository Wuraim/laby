/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_laby;

import java.util.ArrayList;

/**
 *
 * @author lorgn
 */
public class Labyrinthe {
    private final int width;
    private final int height;
    private ArrayList<ArrayList<Case>> laby = new ArrayList<ArrayList<Case>>();
    
    public Labyrinthe(int width, int height){
        this.width = width;
        this.height = height;
        for(int i = 0; i < width; i++){
            laby.add(i,new ArrayList<Case>());
            for(int j = 0; j < height; j++){
                laby.get(i).add(j,new Case(true));
            }
        }
    }
    
    public Case get(int x, int y){
        if( (x < width) && (y < height) && (x >= 0) && (y >= 0)){
            return laby.get(x).get(y);
        }
        else {return null;}
    }
    
    public Case get(Coord position){
        if( (position.getX() < width) && (position.getY() < height) && (position.getX() >= 0) && (position.getY() >= 0)){
            return laby.get(position.getX()).get(position.getY());
        }
        else {return null;}
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public void destroyHaut(int x, int y){
        laby.get(x).get(y).changeHaut(false);
        if(y+1 < height){
            laby.get(x).get(y+1).changeBas(false);
        }
    }
    
    public void destroyHaut(Coord position){
        int x = position.getX();
        int y = position.getY();
        laby.get(x).get(y).changeHaut(false);
        if(y+1 < height){
            laby.get(x).get(y+1).changeBas(false);
        }
    }
        
    public void destroyDroite(int x, int y){
        laby.get(x).get(y).changeDroite(false);
        if(x+1 < width){
            laby.get(x+1).get(y).changeGauche(false);
        }
    }
    
     public void destroyDroite(Coord position){
        int x = position.getX();
        int y = position.getY();
        laby.get(x).get(y).changeDroite(false);
        if(x+1 < width){
            laby.get(x+1).get(y).changeGauche(false);
        }
    }
    
    public void destroyBas(int x, int y){
        laby.get(x).get(y).changeBas(false);
        if(y-1 >= 0){
            laby.get(x).get(y-1).changeHaut(false);
        }
    }
    
    public void destroyBas(Coord position){
        int x = position.getX();
        int y = position.getY();
        laby.get(x).get(y).changeBas(false);
        if(y-1 >= 0){
            laby.get(x).get(y-1).changeHaut(false);
        }
    }
    
    public void destroyGauche(int x,int y){
        laby.get(x).get(y).changeGauche(false);
        if(x-1 >= 0){
            laby.get(x-1).get(y).changeDroite(false);
        }
    }
    
    public void destroyGauche(Coord position){
        int x = position.getX();
        int y = position.getY();
        laby.get(x).get(y).changeGauche(false);
        if(x-1 >= 0){
            laby.get(x-1).get(y).changeDroite(false);
        }
    }
    
    public void setAllPreviouslyDestroy(){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                laby.get(i).get(j).setPreviouslyDestroy(true);
            }
        }
    }
    
    public void setConnection(Coord position){
        if(!(this.get(position.getX(),position.getY()).getHaut()) && !(this.get(position.getX(),position.getY()+1).getConnect())){
            this.get(position.getX(),position.getY()+1).setConnect();
            this.setConnection(new Coord(position.getX(),position.getY()+1));
        }
        if(!(this.get(position.getX(),position.getY()).getDroite()) && !(this.get(position.getX()+1,position.getY()).getConnect())){
            this.get(position.getX()+1,position.getY()).setConnect();
            this.setConnection(new Coord(position.getX()+1,position.getY()));
        }
        if(!(this.get(position.getX(),position.getY()).getBas()) && !(this.get(position.getX(),position.getY()-1).getConnect())){
            this.get(position.getX(),position.getY()-1).setConnect();
            this.setConnection(new Coord (position.getX(),position.getY()-1));
        }
        if(!(this.get(position.getX(),position.getY()).getGauche()) && !(this.get(position.getX()-1,position.getY()).getConnect())){
            this.get(position.getX()-1,position.getY()).setConnect();
            this.setConnection(new Coord(position.getX()-1,position.getY()));
        } 
    }
    
    private boolean isFinish(){
        boolean resultat = true;
        for(int i = 0; i < this.getWidth(); i++){
            for(int j = 0; j < this.getHeight(); j++){
                if(this.get(i,j).isFull()){
                    resultat = false;
                }
            }
        }
        return resultat;
    }
    
    private Coord selectBreakable(){
        ArrayList<Coord> tab = new ArrayList<>();
        Coord test;
        for(int j = 0; j < this.getWidth(); j++){
            for(int i = 0; i < this.getHeight(); i++){
                if(this.get(i,j).isFull()){
                    tab.add(new Coord(i,j));  
                }
            }
        }
        int take = (int) (Math.random() * (tab.size())); 
        
        return tab.get(take);
    }
    
    private Coord selectNotPreviouslyDestroy(){
        ArrayList<Coord> tab = new ArrayList<>();
        for(int j = 0; j < this.getWidth(); j++){
            for(int i = 0; i < this.getHeight(); i++){
                if(!(this.get(i,j).isPreviouslyDestroy())){
                    tab.add(new Coord(i,j));
                }
            }
        }
        int take = (int) (Math.random() * (tab.size())); 
        return tab.get(take);
    }
    
    private void shuffle(int xStart, int yStart){
        int essais = 0; 
        
           Hasard hasard = new Hasard();
           hasard.set();
            while(essais < 4){

                if(hasard.get() == 1 && essais < 4){
                    if( yStart+1 < this.getHeight()){
                        if(this.get(xStart,yStart+1).isFull()){
                           this.destroyHaut(xStart,yStart);
                            yStart++;
                            hasard.set();
                            essais = 0;
                        }
                        else{
                            essais++;
                            hasard.set(1);
                        }
                    }
                    else{
                        essais++;
                        hasard.set(1);
                    }
                }
                

                if(hasard.get() == 2 && essais < 4){
                    if(xStart+1 < this.getWidth()){
                        if(this.get(xStart+1,yStart).isFull()){
                            this.destroyDroite(xStart,yStart);
                            xStart++;
                            hasard.set();
                            essais = 0;
                        }
                        else{
                            essais++;
                            hasard.set(new Integer(2));
                        }
                    }
                    else{
                        essais++;
                        hasard.set(new Integer(2));
                    }
                }
               
                
                if(hasard.get() == 3 && essais < 4){
                    if(yStart-1 > 0){
                        if(this.get(xStart,yStart-1).isFull()){
                            this.destroyBas(xStart,yStart);
                            yStart--;
                            hasard.set();
                            essais = 0;
                        }
                        else{
                            essais++;
                            hasard.set(new Integer(3));
                        }
                    }
                    else{
                        essais++;
                        hasard.set(new Integer(3));
                    }
                }
                

                if(hasard.get() == 4 && essais < 4){
                    if( xStart-1 > 0){
                        if(this.get(xStart-1,yStart).isFull()){
                            this.destroyGauche(xStart,yStart);
                            xStart--;
                            hasard.set();
                            essais = 0;
                        }
                        else{
                            essais++;
                        hasard.set(new Integer(4));
                        }
                    }
                    else{
                        essais++;
                        hasard.set(new Integer(4));
                    }
                }
                
            }
    }
    
    private void shuffle2(int xStart, int yStart){
            int essais = 0;
            Hasard hasard = new Hasard();
            hasard.set();
            //Ici j'apelle la fonction, qui créerat un chemin à chaque fois qu'elle aura détruit un mur, d'une case ayant déjà un mur détruit
            while(!(this.isFinish())){
                if(essais < 4){
                    this.setAllPreviouslyDestroy();
                    Coord save = this.selectBreakable();
                    xStart = save.getX();
                    yStart = save.getY();
                    this.get(xStart,yStart).setPreviouslyDestroy(false);
                }
                else{
                    Coord save = this.selectNotPreviouslyDestroy();
                    xStart = save.getX();
                    yStart = save.getY();
                }
                
                
                essais = 0;
                hasard.set();
                
                
                while(essais < 4){
                    if(hasard.get() == 1 && essais < 4){
                        if( yStart+1 < this.getHeight()){
                            if(this.get(xStart,yStart+1).isFull()){
                                this.destroyHaut(xStart,yStart);
                                yStart++;
                                hasard.set();
                                essais = 0;
                                this.get(xStart,yStart).setPreviouslyDestroy(false);
                                //System.out.println("La cause du haut est pleine, je la détruit : " +xStart +","+yStart);
                            }
                            else if(this.get(xStart,yStart+1).isPreviouslyDestroy()){ //Sinon, si la case, a était détruite à un autre tour de boucle !(isFinish) on pête et on arrête 
                                this.destroyHaut(xStart,yStart);
                                yStart++;
                                hasard.set();
                                //System.out.println("La case de droite a était détruite à un autre tour de boucle, je la détruit : "+xStart +","+yStart);
                                break;
                            }
                            else{
                                essais++;
                                hasard.set(new Integer(1));
                            }
                        }
                        else{
                            essais++;
                            hasard.set(new Integer(1));
                        }
                    }


                    if(hasard.get() == 2 && essais < 4){
                        if(xStart+1 < this.getWidth()){
                            if(this.get(xStart+1,yStart).isFull()){
                                this.destroyDroite(xStart,yStart);
                                xStart++;
                                hasard.set();
                                essais = 0;
                                this.get(xStart,yStart).setPreviouslyDestroy(false);
                                //System.out.println("La cause de droite est pleine, je la détruit : "+xStart +","+yStart);
                            }
                            else if(this.get(xStart+1,yStart).isPreviouslyDestroy()){
                                this.destroyDroite(xStart,yStart);
                                xStart++;
                                hasard.set();
                                //System.out.println("La case de droite a était détruite à un autre tour de boucle, je la détruit : "+xStart +","+yStart);
                                break;
                                
                            }
                            else{
                                essais++;
                                hasard.set(new Integer(2));
                                //System.out.println("La case à droite est une case détruite à ce tour de boucle");
                            }
                        }
                        else{
                            essais++;
                            hasard.set(new Integer(2));
                        }
                    }


                    if(hasard.get() == 3 && essais < 4){
                        if(yStart-1 > 0){
                            if(this.get(xStart,yStart-1).isFull()){
                                this.destroyBas(xStart,yStart);
                                yStart--;
                                hasard.set();
                                essais = 0;
                                //System.out.println("La cause du bas est pleine, je la détruit : "+xStart +","+yStart);
                                this.get(xStart,yStart).setPreviouslyDestroy(false);
                            }
                            else if(this.get(xStart,yStart-1).isPreviouslyDestroy()){
                                this.destroyBas(xStart,yStart);
                                this.get(xStart,yStart).setPreviouslyDestroy(false);
                                yStart--;
                                hasard.set();
                                //System.out.println("La case du bas a était détruite à un autre tour de boucle, je la détruit : "+xStart +","+yStart);
                                break;
                                
                            }
                            else{
                                essais++;
                                hasard.set(new Integer(3));
                                //System.out.println("La case du bas est une case détruite à ce tour de boucle");
                            }
                        }
                        else{
                            essais++;
                            hasard.set(new Integer(3));
                        }
                    }


                    if(hasard.get() == 4 && essais < 4){
                        if( xStart-1 > 0){
                            if(this.get(xStart-1,yStart).isFull()){
                                this.destroyGauche(xStart,yStart);
                                xStart--;
                                hasard.set();
                                essais = 0;
                                //System.out.println("La cause de gauche est pleine, je la détruit : "+xStart +","+yStart);
                                this.get(xStart,yStart).setPreviouslyDestroy(false);
                            }
                            else if(this.get(xStart-1,yStart).isPreviouslyDestroy()){
                                this.destroyGauche(xStart,yStart);
                                xStart--;
                                hasard.set();
                                //System.out.println("La case de gauche a était détruite à un autre tour de boucle, je la détruit : "+xStart +","+yStart);
                                break;
                                
                            }
                            else{
                                essais++;
                                hasard.set(new Integer(4));
                                //System.out.println("La case de gauche est une case détruite à ce tour de boucle");
                            }
                        }
                        else{
                            essais++;
                            hasard.set(new Integer(4));
                        }
                    }

                }
            }  
    }
    
    public void maze(Coord position){
        this.shuffle(position.getX(),position.getY());
        this.shuffle2(position.getX(),position.getY());
    }
}
