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
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g); // Do the original draw
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new java.awt.Color(0,0,255) );
        g2.fillOval(10, 10, 100, 100);
    }
    
    public drawingPanel(){
        
    }
    
    
}
