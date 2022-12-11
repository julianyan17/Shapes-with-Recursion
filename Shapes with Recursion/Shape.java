/**
 * Author: Julian Wai San Yan
 * Date: 1/26/19
 * File: Shape.java
 */

/**
 * Included below are methods to create
 * a Shape object, to get the name of a Shape object, to set the name of a 
 * Shape object, to get a random Color and an abstract method to draw a shape.
 */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

import java.util.*;

/** 
 * This class includes methods that allows a creation of a Shape object and 
 * also an abstract method to draw the Shape. An important instance variable
 * is the name of the Shape object which is always the same unless it is
 * changed by the setShapeName() method.
 */

public abstract class Shape { 

    // name of a Shape object
    private String shapeName;
    
    // object with no name
    private static String NONAME = "NoName";

    /**
     * Constructor that creates a Shape object and sets the name based on the
     * given input
     *
     * @param name name of Shape 
     * @return     Shape object created
     */

    public Shape(String name) {
        this.shapeName = name;
    }

    /**
     * Constructor that creates a Shape object and sets the name to NoName
     *
     * @param name name of Shape 
     * @return     Shape object created
     */    

    public Shape() {
        this(NONAME);
    }

    /** 
     * Getter that gets the name of the Shape object
     *
     * @param  none
     * @return name of the Shape object
     */

    public String getShapeName() { 
        return this.shapeName;
    }

    /** 
     * Setter that sets the name of the Shape object
     *
     * @param name name of Shape object
     * @return     none
     */

    public void setShapeName(String name) {
        return;
    }

    /**
     * Abstract method that draws a Shape
     *
     * @param group group to add Shape to 
     * @param c     color of Shape
     * @param fill  to fill or not fill the Shape
     * @return      none
     */

    public abstract void draw(Group group, Color c, boolean fill);

    /**
     * Returns a String representation of the Shape object
     *
     * @param none
     * @return     String representation of the Shape object
     */
    
    @Override
    public String toString() {
        return getShapeName();
    }

    /**
     * Gets a random color
     *
     * @param none 
     * @return     random Color
     */

    public static Color getRandomColor() {
        Random random = new Random();
        double r = random.nextDouble(),
               g = random.nextDouble(),
               b = random.nextDouble();
        return new Color(r, g, b, 1); // Color constructor
    }
}

