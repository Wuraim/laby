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
public class Tree {
    private Coord main;
    private ArrayList<Tree> son;
    private boolean check;
    private Coord direction;
    
    public Tree(Coord main){
        this.main = main;
        check = false;
        son = new ArrayList<>();
    }
    
    public boolean isCheck(){
        return check;
    }
    
    public Tree getSonUncheck(){
        Tree resultat = null;
        for(int i = 0; i < son.size() && resultat == null; i++){
            if(!(son.get(i).isCheck())){
                resultat=son.get(i);
            }
        }
        return resultat;
    }
}
