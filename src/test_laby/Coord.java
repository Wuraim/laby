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
public class Coord {
    private int x;
    private int y;
    
    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getY(){
        return y;
    }
    
    public int getX(){
        return x;
    }
    
    public void toRight(){
        x++;
    }
    
    public void toLeft(){
        x--;
    }
    
    public void toTop(){
        y++;
    }
    
    public void toBot(){
        y--;
    }
    
    @Override
    public String toString(){
        return "("+x+","+y+")";
    }
}
