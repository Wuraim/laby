/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_laby;

/**
 *
 * @author lorgn
 */
public class Case {
    private boolean haut;
    private boolean droite;
    private boolean bas;
    private boolean gauche;
    private boolean previouslyDestroy;
    private boolean connect;
    
    public Case(boolean isFull){
        haut = isFull;
        droite = isFull;
        bas = isFull;
        gauche = isFull;
        connect = false;
    }
    
    public Case(boolean haut, boolean droite, boolean bas, boolean gauche){
        this.haut = haut; 
        this.droite = droite;
        this.bas = bas; 
        this.gauche = gauche;
        connect = false;
    }
    
    public boolean getHaut(){
        return haut;
    }
    
    public boolean getDroite(){
        return droite;
    }
    
    public boolean getBas(){
        return bas;
    }
    
    public boolean getGauche(){
        return gauche;
    }
    
    public void changeHaut(boolean etat){
        haut = etat;
    }
    
    public void changeDroite(boolean etat){
        droite = etat;
    }
    
    public void changeBas(boolean etat){
        bas = etat;
    }
    
    public void changeGauche(boolean etat){
        gauche = etat;
    }
    
    public boolean isFull(){
        if(this != null){
            return (haut && droite && bas && gauche);
        }
        else{
            return false;
        }
    }
    
    public boolean isPreviouslyDestroy(){
        return previouslyDestroy;
    }
    
    public void setPreviouslyDestroy(boolean set){
        previouslyDestroy = set;
    }
    
    public boolean getConnect(){
        return connect;
    }
    
    public void setConnect(){
        connect = true;
    }
}
