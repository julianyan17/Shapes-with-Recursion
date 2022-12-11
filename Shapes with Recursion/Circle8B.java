/**
 * Author: Julian Wai San Yan
 * Date: 1/26/19
 * File: Circle8B.java
 */

/**
 * Included below are methods
 * to create a Circle8B object, to get the center and radius of a Circle8b 
 * object, to set the center and radius of a Circle8B object, to override the
 * abstract draw method and to draw a bullseye. 
 */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

import java.util.*;

/**
 * This class includes methods that allows the creation of Circle8b objects, an
 * override of the abstract draw method and a method that utilizes recursion to
 * draw a bullseye. Important instance variables are the center and the radius
 * of the Circle8B objects.
 */

public class Circle8B extends Shape {

    // center points and radius of a Circle8B object
    private Point center;
    private int radius;

    // object with no name
    private static final String NONAME = "NoName";

    // reduce radius by 10
    private static final int REDUCE_RADIUS = 10;

    /** 
     * Getter that gets the center of a Circle8B object
     *
     * @param none
     * @return     the center point of a Circle8B object
     */

    public Point getCenter() {
        return this.center;
    }

    /** 
     * Getter that gets the radius of a Circle8B object
     *
     * @param none
     * @return     the radius of a Circle8B object
     */

    public int getRadius() {
        return this.radius;
    }

    /**
     * Setter that sets the center of a Circle8B object
     * 
     * @param center center of the Circle8B object
     * @return       void
     */

    private void setCenter(Point center) {
        this.center = center;
    }

    /**
     * Setter that sets the radius of a Circle8B object
     * 
     * @param radius radius of the Circle8B object
     * @return       void
     */

    private void setRadius(int radius) {
        this.radius = radius;
    }

    /** 
     * Constructor that creates a deep copy of the center point and radius
     * passed in 
     * 
     * @param center center of the Circle8B object
     * @param radius radius of the Circle8B object
     * @return       Circle8B object created
     */

    public Circle8B(Point center, int radius) {
        super(NONAME);
        this.setCenter(new Point(center));
        this.setRadius(radius);
    }

    /** 
     * Constructor that creates a deep copy of the center point, radius and
     * name passed in 
     * 
     * @param center center of the Circle8B object
     * @param radius radius of the Circle8B object
     * @param name   name of Circle8B object
     * @return       Circle8B object created
     */    

    public Circle8B(Point center, int radius, String name) {
        super(name);
        this.setCenter(new Point(center));
        this.setRadius(radius);
    }

    /** 
     * Copy constructor that creates a deep copy of the Circle8B object passed
     * in
     * 
     * @param c Circle8B object to be copied
     * @return  Circle8B object created
     */

    public Circle8B(Circle8B c) {
        super(NONAME);
        this.setCenter(new Point(c.getCenter()));
        this.setRadius(c.getRadius());
    }

    /** 
     * Copy constructor that creates a deep copy of the Circle8B object and
     * its name passed in
     * 
     * @param c    Circle8B object to be copied
     * @param name name of Circle8B object
     * @return     Circle8B object created
     */

    public Circle8B(Circle8B c, String name) {
        super(name);
        this.setCenter(new Point(c.getCenter()));
        this.setRadius(c.getRadius());
    }

    /**
     * Default constructor that sets the name to NoName, center Point to (0,0)
     * and radius to 0
     *
     * @param none
     * @return     Circle8B object created
     */

    public Circle8B() {
        super(NONAME);
        this.setCenter(new Point(0,0));
        this.setRadius(0);
    }

    /** 
     * Returns the String representation of a Circle8B object
     *
     * @param none
     * @return     a String representation of a Circle8B object
     */

    @Override
    public String toString() {
        return String.format("Circle8B: %s; Center: %s; Radius: %d",
                getShapeName(), center.toString(), radius);
    }

    /**
     * Draws the Circle8B object into the group
     *
     * @param group group to add Circle8B object in
     * @param c     color of Circle8B object
     * @param fill  whether or not to fill the Circle8B object
     * @return      none
     */

    @Override
    public void draw(Group group, Color c, boolean fill) {
        if(fill == true) {
            // create a filled circle
            Circle circle = new Circle(center.getX(), center.getY(), radius, 
                    c);
            group.getChildren().add(circle);
        }
        else {
            // create a non-filled circle
            Circle circle = new Circle(center.getX(), center.getY(), radius, 
                    null);
            circle.setStroke(c);
            group.getChildren().add(circle);
        }
    }

    /**
     * Draws a bullseye using recursion of the draw method
     * 
     * @param group group to add bullseye in
     * @param fill  whether or not to fill the bullseye
     * @param n     number of circles to create
     * @return      none
     */

    public void drawBullsEye(Group group, boolean fill, int n) {
        // base case: if n = 0, return nothing
        if(n == 0) {
            return;
        }
        // draw the circle
        draw(group, getRandomColor(), fill);

        if(n > 1) {
            // recursion: create a copy of the circle, change the radius by
            //            subtracting 10 and then draw a bullseye again with 1 
            //            less circle
            Circle8B newCircle = new Circle8B(this.center,this.getRadius() 
                               - REDUCE_RADIUS); 
            newCircle.drawBullsEye(group, fill, n - 1);         
        }        
    }
}

