/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import paint1.Circle;
import paint1.LineSegment;
import paint1.Rectangle;
import paint1.Shape;
import paint1.ShapeFactory;
import paint1.Square;
import paint1.Triangle;

/**
 *
 * @author ADMIN
 */
public class Board extends JPanel implements MouseListener, MouseMotionListener {

    static int mode = -1;
    public int x1, y1;
    boolean first = false;
    public int x2, y2;
    public int x3, y3;
    Shape selectedshape;

    private ShapeFactory f;

    public static ArrayList<Shape> x = new ArrayList<Shape>();

    public Board() {
        addMouseListener(this);
        addMouseMotionListener(this);
        f = ShapeFactory.getInstance();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Iterator<Shape> it = x.iterator();
        while (it.hasNext()) {
            it.next().draw(g);
        }
//        for (int i = 0; i < x.size(); i++) {
//            x.get(i).draw(g);
//        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        x1 = me.getX();
        y1 = me.getY();
        if (mode == 0) {
            LineSegment l = (LineSegment) f.CreateShape(0, x1, y1, x1, y1);
            x.add(l);
            repaint();
        } else if (mode == 1) {
            Circle c = (Circle) f.CreateShape(1, x1, y1, x1, y1);
            x.add(c);
            repaint();
        } else if (mode == 2) {
            Triangle t = (Triangle) f.CreateShape(2, x1, y1, x1, y1, x1, y1);
            x.add(t);
            repaint();
        } else if (mode == 3) {
            Rectangle r = (Rectangle) f.CreateShape(3, x1, y1, x1, y1);
            x.add(r);
            repaint();

        } else if (mode == 4) {
            Square s = (Square) f.CreateShape(4, x1, y1, x1, y1);
            x.add(s);
            repaint();
        }
        if (mode == 6) {
            for (int i = x.size() - 1; i >= 0; i--) {
                if (x.get(i).contains(x1, y1)) {
                    selectedshape = x.get(i);
                    System.out.println("selected");
                    break;

                }
            }
        }
        if (mode == 7) {
            if (selectedshape != null) {
                mydrawingboard.stack.add(selectedshape);
                x.remove(selectedshape);
                repaint();

            }
        }
        if (mode == 8) { //move

        }
        if (mode == 9) { //copy
            x1 = me.getX();
            y1 = me.getY();

            if (selectedshape != null) {
                try {
                    Shape s = (Shape) selectedshape.clone();

                    if (s instanceof Circle) {
                        Circle c = (Circle) s;
                        c.setX1(c.getX1() + 40);
                        c.setY1(c.getY1() + 40);
                        c.setX2(c.getX2() + 40);
                        c.setY2(c.getY2() + 40);
                        x.add(c);
                        repaint();

                    } else if (s instanceof Rectangle) {
                        Rectangle r = (Rectangle) s;
                        r.setX1(r.getX1() + 40);
                        r.setY1(r.getY1() + 40);
                        r.setX2(r.getX2() + 40);
                        r.setY2(r.getY2() + 40);
                        x.add(r);
                        repaint();

                    } else if (s instanceof Square) {
                        Square sq = (Square) s;
                        sq.setX1(sq.getX1() + 40);
                        sq.setY1(sq.getY1() + 40);
                        sq.setX2(sq.getX2() + 40);
                        sq.setY2(sq.getY2() + 40);
                        x.add(sq);
                        repaint();

                    } else if (s instanceof LineSegment) {
                        LineSegment l = (LineSegment) s;
                        l.setX1(l.getX1() + 40);
                        l.setY1(l.getY1() + 40);
                        l.setX2(l.getX2() + 40);
                        l.setY2(l.getY2() + 40);
                        x.add(l);
                        repaint();
                    } else if (s instanceof Triangle) {
                        Triangle t = (Triangle) s;
                        t.setX1(t.getX1() + 40);
                        t.setY1(t.getY1() + 40);
                        t.setX2(t.getX2() + 40);
                        t.setY2(t.getY2() + 40);
                        t.setX3(t.getX3() + 40);
                        t.setY3(t.getY3() + 40);
                        x.add(t);
                        repaint();

                    }
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        if (mode == 11) {
            
            if (selectedshape != null) {
                 mydrawingboard.stack.add(selectedshape);
                if(selectedshape instanceof Rectangle){
                Rectangle r = (Rectangle) selectedshape;
                if (r.getFlag() == 0) {
                    r.setFlag(1);
                }else {
                    r.setFlag(0);
                }
                repaint();

            }
        
            else if(selectedshape instanceof Circle)
                    {
                        Circle c=(Circle) selectedshape;
                        if (c.getFlag() == 0) {
                    c.setFlag(1);
                }else {
                    c.setFlag(0);
                }
                repaint();

            
                        
                    }
            else if(selectedshape instanceof Square)
                {
                    Square s=(Square) selectedshape;
                   
                        if (s.getFlag() == 0) {
                    s.setFlag(1);
                }else {
                    s.setFlag(0);
                }
                repaint();
                }
            else if  (selectedshape instanceof Triangle)
            {
            Triangle t=(Triangle) selectedshape;
                 if (t.getFlag() == 0) {
                    
                    t.setFlag(1);
                }else {
                    t.setFlag(0);
                }
                repaint();
                }
            }
            
        
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (mode == 0) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof LineSegment) {
                LineSegment l = (LineSegment) s;
                l.setX2(x2);
                l.setY2(y2);
            }
            repaint();
            first = false;
        } else if (mode == 1) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Circle) {
                Circle c = (Circle) s;
                c.setX2(x2);
                c.setY2(y2);

            }
            repaint();
            first = false;
        } else if (mode == 2) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Triangle) {
                Triangle t = (Triangle) s;
                t.setX1(x1 + (x2 - x1) / 2);
                t.setY1(y1);
                t.setX2(x2);
                t.setY2(y2);
                t.setX3(x1);
                t.setY3(y2);
            }
            repaint();
            first = false;

        } else if (mode == 3) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Rectangle) {
                Rectangle r = (Rectangle) s;
                r.setX2(x2);
                r.setY2(y2);

            }
            repaint();
            first = false;
        } else if (mode == 4) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = x.get(x.size() - 1);
            if (s instanceof Square) {
                Square sq = (Square) s;
                sq.setX2(x2);
                sq.setY2(y2);

            }
            repaint();
            first = false;
        }
        if (mode == 8)//move
        {
            x2 = me.getX();
            y2 = me.getY();
            if (selectedshape != null) {
                
                if (selectedshape instanceof Rectangle) {
                    Rectangle r1 = (Rectangle) selectedshape;
                    r1.setX1(r1.getX1() + x2 - x1);
                    r1.setY1(r1.getY1() + y2 - y1);
                    r1.setX2(r1.getX2() + x2 - x1);
                    r1.setY2(r1.getY2() + y2 - y1);
                    x1 = x2;
                    y1 = y2;
                    repaint();

                } else if (selectedshape instanceof Circle) {

                    Circle c1 = (Circle) selectedshape;
                    c1.setX1(c1.getX1() + x2 - x1);
                    c1.setY1(c1.getY1() + y2 - y1);
                    c1.setX2(c1.getX2() + x2 - x1);
                    c1.setY2(c1.getY2() + y2 - y1);
                    x1 = x2;
                    y1 = y2;
                    repaint();

                } else if (selectedshape instanceof Triangle) {
                    Triangle t = (Triangle) selectedshape;
                    t.setX1(t.getX1() + x2 - x1);
                    t.setY1(t.getY1() + y2 - y1);
                    t.setX2(t.getX2() + x2 - x1);
                    t.setY2(t.getY2() + y2 - y1);
                    t.setX3(t.getX3() + x2 - x1);
                    t.setY3(t.getY3() + y2 - y1);
                    x1 = x2;
                    y1 = y2;
                    repaint();

                } else if (selectedshape instanceof Square) {
                    Square s1 = (Square) selectedshape;
                    s1.setX1(s1.getX1() + x2 - x1);
                    s1.setY1(s1.getY1() + y2 - y1);
                    s1.setX2(s1.getX2() + x2 - x1);
                    s1.setY2(s1.getY2() + y2 - y1);
                    x1 = x2;
                    y1 = y2;
                    repaint();

                } else if (selectedshape instanceof LineSegment) {
                    LineSegment l = (LineSegment) selectedshape;
                    l.setX1(l.getX1() + x2 - x1);
                    l.setY1(l.getY1() + y2 - y1);
                    l.setX2(l.getX2() + x2 - x1);
                    l.setY2(l.getY2() + y2 - y1);
                    x1 = x2;
                    y1 = y2;
                    repaint();

                }
            }
        }
        if (mode == 10) {//resize
            x2 = me.getX();
            y2 = me.getY();
           
            if (selectedshape != null) {
                 
                if (selectedshape instanceof Rectangle) {
                    Rectangle r1 = (Rectangle) selectedshape;
                    r1.setX1(r1.getX1() + x2 - x1);
                    r1.setY1(r1.getY1() + y2 - y1);
                    x1 = x2;
                    y1 = y2;
                    repaint();

                } else if (selectedshape instanceof Circle) {

                    Circle c1 = (Circle) selectedshape;
                    c1.setX1(c1.getX1() + x2 - x1);
                    c1.setY1(c1.getY1() + y2 - y1);
                    x1 = x2;
                    y1 = y2;
                    repaint();

                } else if (selectedshape instanceof Triangle) {
                    Triangle t = (Triangle) selectedshape;
                    t.setX1(t.getX1() + x2 - x1);
                    t.setY1(t.getY1() + y2 - y1);
                    x1 = x2;
                    y1 = y2;
                    repaint();

                } else if (selectedshape instanceof Square) {
                    Square s1 = (Square) selectedshape;
                    s1.setX1(s1.getX1() + x2 - x1);
                    s1.setY1(s1.getY1() + y2 - y1);
                    x1 = x2;
                    y1 = y2;
                    repaint();

                } else if (selectedshape instanceof LineSegment) {
                    LineSegment l = (LineSegment) selectedshape;
                    l.setX1(l.getX1() + x2 - x1);
                    l.setY1(l.getY1() + y2 - y1);
                    x1 = x2;
                    y1 = y2;
                    repaint();

                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

}
