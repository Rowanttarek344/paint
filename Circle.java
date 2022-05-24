/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint1;

import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import javax.sound.sampled.Clip;


public class Circle extends Shape implements Cloneable{
    private int x1,y1;
    private int x2,y2,flag ;
    
    
    public Circle()
    {
        super();
    }
    
    public Circle(Color color,int x1,int x2,int y1,int y2,int flag) {
        super(color);
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.flag=flag;
    }

    
    
  
   @Override
    public void draw(Graphics g) {
      g.setColor(getColor());
       if(flag==0){
        
                  g.drawOval(x1,y1,Math.abs(x2-x1),Math.abs(y2-y1));
        }
        else
        {
               g.setColor(g.getColor());
                  g.fillOval(x1,y1,Math.abs(x2-x1),Math.abs(y2-y1));
            
    }
    }
   
    
    /**
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }
    @Override
    public boolean contains(int x, int y) {
        
          java.awt.geom.Ellipse2D r = new java.awt.geom.Ellipse2D.Double(this.x1, this.y1, Math.abs(this.x1 - this.x2),Math.abs(this.y2 -this.y1));
        if (r.contains(x, y)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the flag
     */
    public int getFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(int flag) {
        this.flag = flag;
    }
    

    

    
}
