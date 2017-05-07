/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulator_zderzen;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Marcin2
 */
public class drawingPanel extends javax.swing.JPanel{
    private int x;
    private int y;
    private int z;
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g); // Do the original draw
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new java.awt.Color(0,0,255) );
        g2.fillOval(x, y, 100, 100);
        g2.fillOval(500,y,100,100);
    }
    
    public drawingPanel(){
        x=100;
        y=150;
        ;
    }
    
    public void setPosition(int argX, int argY){
        x=argX;
        y=argY;
        revalidate();
        repaint();
    }
    
    
    
}
