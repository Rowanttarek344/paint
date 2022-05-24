/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint1;

import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import gui.Board;
import gui.mydrawingboard;
import java.awt.geom.Line2D;


public class LineSegment extends Shape{
    private int x1,y1;
    private int x2,y2,flag ;    
    public LineSegment(Color color,int x1,int x2,int y1,int y2,int flag ) {
        
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
        g.drawLine(x1,y1 ,x2,y2);
        
      
        
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
        Line2D.Float l=new Line2D.Float(this.x1,this.y1,this.x2,this.y2);
        double t=l.ptLineDist(x,y);
        if(t<3)
        {
            return true;
        }
        else
        {
            return false;
        }
                
        
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
