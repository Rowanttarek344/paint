/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint1;

import gui.Board;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import gui.mydrawingboard;

/**
 *
 * @author ADMIN
 */
public class ShapeFactory {
    private static ShapeFactory f =null;
    private ShapeFactory()
    {
        
    }
    public static ShapeFactory getInstance()
    {
        if(f==null)
            f=new ShapeFactory();
        return f;
    }
    

    public static Color currentcolor;
   
    public Shape CreateShape(int mode,int x1,int y1,int x2,int y2) {
       
        
    
        System.out.println(currentcolor);
       
        
                
        if(mode==0)
        {
            return new LineSegment(currentcolor,x1,y1,x2,y2,mydrawingboard.flag);
        }
        else if (mode==1) 
        {
            return new Circle(currentcolor,x1,y1,x2,y2,mydrawingboard.flag);
            
        } 
        else if (mode==3) 
        {
            return new Rectangle(currentcolor,x1,y1,x2,y2,mydrawingboard.flag);
        } 
         else if (mode==4) 
        {
           return new Square(currentcolor,x1,y1,x2,y2,mydrawingboard.flag);
        } 
        else 
         return null;

    
}
     public static Shape CreateShape(int mode,int x1,int x2,int y1,int y2,int x3,int y3)
     {
         return new Triangle(currentcolor,x1,y1,x2,y2,x3,y3,mydrawingboard.flag);
     }
     
}
