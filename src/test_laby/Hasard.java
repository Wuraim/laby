/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_laby;
import java.util.ArrayList;

/**
 *
 * @author Grégoire
 */
public class Hasard {
    private int nombre;
    private ArrayList<Integer> exception;
    
    public Hasard(){
        exception = new ArrayList<>();
    }
    
    public int get(){
        return nombre;
    }
    
    
     public void set(){
        exception = new ArrayList<>();
        nombre = (int) (Math.random() * (4)) + 1;
    }
    
    public void set(Integer except){
        exception.add(except);
        ArrayList<Integer> choixPossible = new ArrayList<>();
        choixPossible.add(1); choixPossible.add(2); choixPossible.add(3); choixPossible.add(4);
        for(int i = 0; i < exception.size(); i++){
            choixPossible.remove(exception.get((i)));
        }
        if(choixPossible.size() == 0){
            nombre = 0;
        }
        else{
            int take = (int) (Math.random() * (choixPossible.size())); 
            nombre = choixPossible.get(take); 
        }
    }
}
