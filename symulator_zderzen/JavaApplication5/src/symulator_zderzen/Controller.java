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
        
        currentView = new View();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentView.setVisible(true);
            }
        });
    }
    
    
}
