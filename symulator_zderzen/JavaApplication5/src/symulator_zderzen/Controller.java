/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulator_zderzen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jbox2d.collision.shapes.CircleShape;
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
    private float timeStep = 1.0f / 60.0f;
    private int velocityIterations = 6;
    private int positionIterations = 2;
    private Body ball1;
    private Timer testTimer;
    private float RATIO = 100.0f;
    private Body ball2;

    public Controller() {

//creating world in jbox2d
        currentView = new View(this);
        Vec2 gravity = new Vec2(0, 0);
        world = new World(gravity);

        //creating a body in jbox2d
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.DYNAMIC;
        bodyDef.position.set(1, 1.5f);
        ball1 = world.createBody(bodyDef);
        CircleShape cs = new CircleShape();
        cs.m_radius = 0.5f;
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = cs;
        fixtureDef.density = 1;
        fixtureDef.friction = 0.3f;
        ball1.createFixture(fixtureDef);
        // add force to the 1. body
        /*   Body body = (Body)ball1.getUserData();
    Vec2 force  = new Vec2(0, 150.0f);
    Vec2 point = body.getWorldPoint(body.getWorldCenter());
    body.applyForce(force ,point);*/

        //creating the 2nd object 
        bodyDef = new BodyDef();
        bodyDef.type = BodyType.DYNAMIC;

        bodyDef.position.set((currentView.getDrawingPanelSize().x * 2) / (3 * RATIO), 1.5f);
        ball2 = world.createBody(bodyDef);
        CircleShape ballShape = new CircleShape();
        ballShape.m_radius = 0.5f;
        FixtureDef fd = new FixtureDef();
        fd.shape = ballShape;
        fd.density = 2.f;
        fd.friction = 0.3f;
        ball2.createFixture(fd);
        //add impulse to the 2. object 
        /* Body ballImpulse = (Body)ball2.getUserData();
        Vec2 impulse  = new Vec2(0, 50.0f);
        Vec2 center = body.getWorldPoint(body.getWorldCenter());
        body. applyLinearImpulse (force ,point);    */
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                executeStep();
            }
        };

        testTimer = new Timer(16, listener);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                currentView.setVisible(true);
            }
        });
        
        ball1.setActive(true);
        ball2.setActive(true);
        //ball1.applyForceToCenter(new Vec2(100,0));
        ball1.setLinearVelocity(new Vec2(2,0));
        ball2.setLinearVelocity(new Vec2(-2,0));
    }

    public void executeStep() {
        System.out.println("test");
        world.step(timeStep, velocityIterations, positionIterations);
        Vec2 position1 = ball1.getPosition();
        Vec2 position2 = ball2.getPosition();
        currentView.setBall1Position((int) (position1.x * RATIO), (int) (position1.y * RATIO));
        currentView.setBall2Position((int) (position2.x * RATIO), (int) (position2.y * RATIO));
    }

    public void startSimulation() {
        System.err.println("Simulation started");
        testTimer.start();
    }

    public void stopSimulation() {
        System.err.println("Simulation stopped");
        testTimer.stop();
    }

    public void setBall1PositionX(float xArg) {
        if (ball1 != null) {
            ball1.setTransform(new Vec2(xArg/RATIO, ball1.getPosition().y), ball1.getAngle());
            Vec2 position1 = ball1.getPosition();
            currentView.setBall1Position((int) (position1.x * RATIO), (int) (position1.y * RATIO));
        }
    }
    public void setBall1PositionY(float yArg) {
        if (ball1 != null) {
            ball1.setTransform(new Vec2(ball1.getPosition().x, yArg/RATIO), ball1.getAngle());
            Vec2 position1 = ball1.getPosition();
            currentView.setBall1Position((int) (position1.x * RATIO), (int) (position1.y * RATIO));
        }
    }

}
