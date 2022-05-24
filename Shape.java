/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint1;

/**
 *
 * @author ADMIN
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape implements Cloneable{
    private Color color;
  
   
    

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape(Color color) {
        this.color = color;
    }
    public Shape()
    {
        
    }
    
    
    public abstract void draw(Graphics g);
    public abstract boolean contains(int x,int y);

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
