/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author ADMIN
 */
public class Triangle extends Shape{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3,flag;

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

    /**
     * @return the x3
     */
    public int getX3() {
        return x3;
    }

    /**
     * @param x3 the x3 to set
     */
    public void setX3(int x3) {
        this.x3 = x3;
    }

    /**
     * @return the y3
     */
    public int getY3() {
        return y3;
    }

    /**
     * @param y3 the y3 to set
     */
    public void setY3(int y3) {
        this.y3 = y3;
    }
    
   public Triangle(Color color,int x1,int y1,int x2,int y2,int x3,int y3,int flag)
   {
       super(color);
       this.x1=x1;
       this.x2=x2;
       this.x3=x3;
       this.y1=y1;
       this.y2=y2;
       this.y3=y3;
       this.flag=flag;
   }

    @Override
    public void draw(Graphics g) {
         int[] x={x1,x2,x3};
        g.setColor(getColor());
        int[] y={y1,y2,y3};
        if(flag==0){
       
      g.drawPolygon(x,y,3);
        }
        else
        {
            g.fillPolygon(x, y, 3);
        }
    }

    @Override
    public boolean contains(int x, int y) {
        int [] a={this.x1,this.x2,this.x3};
                int [] b={this.y1,this.y2,this.y3};
                java.awt.Polygon t=new java.awt.Polygon(a,b,3);
                if(t.contains(x,y))
                    return true;
                else
                    return false;
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
