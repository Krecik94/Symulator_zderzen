/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulator_zderzen;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Marcin2
 */
public class drawingPanel extends javax.swing.JPanel{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g); // Do the original draw
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new java.awt.Color(0,50,200) );
        g2.fillOval(x1-25, y1-25, 100, 100);
        g2.setColor(new java.awt.Color(255,0,0) );
        g2.fillOval(x2-25,y2-25,100,100);
    }
    
    public drawingPanel(){
        x1=100;
        y1=150;
        x2=300;
        y2=150;
    }
    
    public void setPosition1(int argX, int argY){
        x1=argX;
        y1=argY;
        revalidate();
        repaint();
    }
    
    public void setPosition2(int argX, int argY){
        System.err.println(""+argX+" "+argY);
        x2=argX;
        y2=argY;
        revalidate();
        repaint();
    }
    
    
    public Vec2 getPanelSize(){
        Vec2 returnVector = new Vec2();
        returnVector.x= this.getSize().width;
        returnVector.y= this.getSize().height;
        return returnVector;
    }
    
}
