/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package symulator_zderzen;


/**
 *
 * @author Marcin2
 */
public class Controller {
    private View currentView;
    
    public Controller() {
        
        currentView = new View(this);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentView.setVisible(true);
            }
        });
    }
    public void executeStep() {
        System.out.println("test");
     
    }
 
    public void startSimulation(){
        System.err.println("Simulation started");
    }
    
}
