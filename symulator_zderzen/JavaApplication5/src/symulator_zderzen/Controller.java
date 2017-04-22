/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package symulator_zderzen;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.shapes.PolygonShape;
//import org.jbox2d.collision.PolygonShape;
import org.jbox2d.common.Vec2;
//import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.BodyType;
// org.jbox2d.dynamics.FixtureDef;

/**
 *
 * @author Marcin2
 */
public class Controller {
    private View currentView;
private World myWorld;    
    public Controller() {
        
        currentView = new View(this);
       AABB myAABB=new AABB(new Vec2(5,5),new Vec2(-5,-5)); 
   Vec2  gravity = new Vec2(0,-10);
   
    myWorld = new World(gravity,false);
 /*   BodyDef bd = new BodyDef();
bd.position.set(50, 50);  
bd.type = BodyType.DYNAMIC;
     BodyDef bodyDef = new BodyDef();
    bodyDef.type = BodyType.DYNAMIC;
    bodyDef.position.set(0, 4);
    Body body = myWorld.createBody(bodyDef);
    PolygonShape dynamicBox = new PolygonShape();
    dynamicBox.setAsBox(1, 1);
    FixtureDef fixtureDef = new FixtureDef();
    fixtureDef.shape = dynamicBox;
    fixtureDef.density = 1;
    fixtureDef.friction = 0.3f;
    body.createFixture(fixtureDef);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentView.setVisible(true);
            }
        });
    }
    public void executeStep() {
        System.out.println("test");
     
    }
    
}
