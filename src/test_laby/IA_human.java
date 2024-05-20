/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_laby;

/**
 *
 * @author Grégoire
 */
public class IA_human {
    private Coord actuel;
    private Coord direction;
    
    public IA_human(Coord départ){
        actuel = départ;
    }
    
    public IA_human(Coord départ, Coord direction){
        actuel = départ;
        this.direction = direction;
    }
    
    public void execute(){
        
    }
    
    private Coord walk(Coord actuel, Coord direction){
        return null;
    }
}
