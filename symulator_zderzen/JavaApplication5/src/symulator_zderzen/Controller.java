/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package symulator_zderzen;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;


/**
 *
 * @author Marcin2
 */
public class Controller {
    private View currentView;
    private World world;
    private float timeStep = 2;
    private int velocityIterations = 6;
    private int positionIterations = 2;
    private Body body;
    
    
    
    public Controller() {
        currentView = new View(this);
        Vec2  gravity = new Vec2(0,10);
        world = new World(gravity);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.DYNAMIC;
        bodyDef.position.set(5, 4);
        body = world.createBody(bodyDef);
        PolygonShape dynamicBox = new PolygonShape();
        dynamicBox.setAsBox(1, 1);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = dynamicBox;
        fixtureDef.density = 1;
        fixtureDef.friction = 0.3f;
        body.createFixture(fixtureDef);
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentView.setVisible(true);
            }
        });
    }
    public void executeStep() {
        System.out.println("test");
        world.step(timeStep, velocityIterations, positionIterations);
        Vec2 position = body.getPosition();
        currentView.setBallPosition((int) position.x, (int)position.y);
    }
 
    public void startSimulation(){
        System.err.println("Simulation started");
    }
    
}
