import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.ArrayList;
public class Sierpinski extends JPanel implements KeyListener{
    JFrame frame; 
    ArrayList<Point> points; 
    int var = 1; 
    int orderPairX;
    int orderPairY;
    public Sierpinski() {
        frame = new JFrame("Sierpinski Program");
        frame.addKeyListener(this);
        frame.setSize(800, 800);

        points = new ArrayList<Point>(); 

        drawSierpinski();

        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);
    }

    public void drawSierpinski() {
        int r = 300; 
        Point center = new Point(frame.getWidth()/2, frame.getHeight()/2); 
        int width = (int) (frame.getWidth()/2 - (0.5*r)); 
        int height = (int) (frame.getHeight()/2 - ((Math.sqrt(3)/2)*r)); 
        Point a = new Point(width, height); 

        width = (int) (frame.getWidth()/2 + (0.5*r)); 
        height = (int) (frame.getHeight()/2 - ((Math.sqrt(3)/2)*r)); 
        Point b = new Point(width, height); 

        width = (int) (frame.getWidth()/2 + r); 
        height = (int) (frame.getHeight()/2); 
        Point c = new Point(width, height); 

        width = (int) (frame.getWidth()/2 + (0.5*r)); 
        height = (int) (frame.getHeight()/2 + ((Math.sqrt(3)/2)*r)); 
        Point d = new Point(width, height); 

        width = (int) (frame.getWidth()/2 - (0.5*r));  
        height = (int) (frame.getHeight()/2 + ((Math.sqrt(3)/2)*r)); 
        Point e = new Point(width, height); 

        width = (int) (frame.getWidth()/2 - r);  
        height = (int) (frame.getHeight()/2); 
        Point f = new Point(width, height); 
        //Point c = new Point(900, 900); 
        //Point d = new Point()

        //points.add(center);
        points.add(a);
        points.add(b); 
        points.add(c);
        points.add(d);  
        points.add(e); 
        points.add(f); 
        //points.add(left);
        //points.add(right); 

        int xValues [] = {a.getX(), b.getX(), c.getX(), d.getX(), e.getX(), f.getX()}; 
        int yValues [] = {a.getY(), b.getY(), c.getY(), d.getY(), e.getY(), f.getY()};
        Polygon shape = new Polygon(xValues, yValues, 6);

        boolean fallsInsidePoly = false;

        orderPairX = (int)(Math.random()*frame.getWidth()+0);
        orderPairY = (int)(Math.random()*frame.getHeight()+0);
        
        while(fallsInsidePoly) {
            if(shape.contains(orderPairX, orderPairY)) {
                fallsInsidePoly = true; 
                points.add(new Point(orderPairX, orderPairY)); 
            }
            orderPairX = (int)(Math.random()*frame.getWidth()+0);
            orderPairY = (int)(Math.random()*frame.getHeight()+0);
        }
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.setColor(Color.BLACK) ; 
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        g.setColor(Color.WHITE);
        for(Point p : points) {
            g.fillOval(p.getX(), p.getY(), 2, 2);
        }
    
        
    }

    public void addPoints() {
        
        int rand=(int)(Math.random()*6);
        Point corner=points.get(rand);
        points.add(midPoint(points.get(points.size()-1), corner));
              
    }

    public Point midPoint(Point p1, Point p2) {
        return new Point(p2.x + (int)((p1.x-p2.x)*(1/3.0)), p2.y + (int)((p1.y-p2.y)*(1/3.0))); 
        //return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }

    class Point {
        int x, y;        
        public Point(int x, int y) {
            this.x = x;
            this.y = y; 
        }

        public int getX() {
            return x; 
        }
        public int getY() {
            return y; 
        }
    }
    
    public static void main(String[]args) {
        Sierpinski app = new Sierpinski();  
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        for(int x=0;x<e.getKeyCode();x++)
            addPoints();
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}


