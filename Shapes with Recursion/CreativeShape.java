/**
 * Author: Julian Wai San Yan
 * Date: 1/26/19
 * File: CreativeShape.java
 */

/**
 * Included below are methods
 * to create a CreativeShape object, to get the side and upperLeft point of a 
 * CreativeShape object, to set the side and upperLeft point of a CreativeShape
 * object, to override the abstract draw method and to draw a honeycomb. 
 */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

import java.util.*;

/** 
 * This class includes methods that allows the creation of CreativeShape 
 * objects and override the abstract draw method and a method that utilizes 
 * recursion to draw honeycombs. Important instance methods are the side and
 * upperLeft point of the CreativeShape objects.
 */

public class CreativeShape extends Shape {
    
    // side and upperLeft point of a CreativeShape object
    private int side;
    private Point upperLeft;

        // object with no name
    private static final String NONAME = "NoName";

    // index of double array
    private static final int IND_TWO = 2;
    private static final int IND_THREE = 3;
    private static final int IND_FOUR = 4; 
    private static final int IND_FIVE = 5;
    private static final int IND_SIX = 6;
    private static final int IND_SEVEN = 7;
    private static final int IND_EIGHT = 8;
    private static final int IND_NINE = 9;
    private static final int IND_TEN = 10;
    private static final int IND_ELEVEN = 11;

    // size of double array
    private static final int TWELVE = 12;

    // divide by half
    private static final int HALF = 2;

    /** 
     * Getter that gets the side of a CreativeShape object
     *
     * @param none
     * @return     the side point of a CreativeShape object
     */
    
    public int getSide() {
        return this.side;
    }
    
    /** 
     * Getter that gets the upperLeft point of a CreativeShape object
     *
     * @param none
     * @return     the upperLeft point of a CreativeShape object
     */
    
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Setter that sets the side of a CreativeShape object
     * 
     * @param side side of the CreativeShape object
     * @return     void
     */
    
    private void setSide(int side) {
        this.side = side;
    }
    
    /**
     * Setter that sets the side of a CreativeShape object
     * 
     * @param side side of the CreativeShape object
     * @return     void
     */

    private void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    /** 
     * Constructor that creates a deep copy of the upperLeft point and side
     * passed in 
     * 
     * @param upperLeft center of the CreativeShape object
     * @param side      side of the CreativeShape object
     * @return          CreativeShape object created
     */
    
    public CreativeShape(Point upperLeft, int side) {
        super(NONAME);
        this.setUpperLeft(new Point(upperLeft));
        this.setSide(side);
    }

    /** 
     * Constructor that creates a deep copy of the upperLeft point, side and
     * name passed in 
     * 
     * @param upperLeft center of the CreativeShape object
     * @param side      side of the CreativeShape object
     * @param name      name of the CreativeShape object
     * @return          CreativeShape object created
     */
    
    public CreativeShape(Point upperLeft, int side, String name) {
        super(name);
        this.setUpperLeft(new Point(upperLeft));
        this.setSide(side);
    }
    
    /** 
     * Copy constructor that creates a deep copy of the CreativeShape object 
     * passed in
     * 
     * @param c CreativeShape object to be copied
     * @return  CreativeShape object created
     */

    public CreativeShape(CreativeShape hexagon) {
        super(NONAME);
        this.setUpperLeft(new Point(hexagon.getUpperLeft()));
        this.setSide(hexagon.getSide());
    }
    
    /**
     * Default constructor that sets the name to NoName, upperLeft Point to 
     * (0,0) and side to 0
     *
     * @param none
     * @return     CreativeShape object created
     */  

    public CreativeShape() {
        super(NONAME);
        this.setUpperLeft(new Point(0,0));
        this.setSide(0);
    }

    /** 
     * Returns the String representation of a CreativeShape object
     *
     * @param none
     * @return     a String representation of a CreativeShape object
     */
    
    @Override
    public String toString() {
        return String.format("CreativeShape: %s; \n upperLeft: %s; side: %d",
                getShapeName(), upperLeft.toString(), side);
    }

    /**
     * Draws the CreativeShape object into the group
     *
     * @param group group to add CreativeShape object in
     * @param c     color of CreativeShape object
     * @param fill  whether or not to fill the CreativeShape object
     * @return      none
     */
    
    @Override
    public void draw(Group group, Color c, boolean fill) {
        // creates double array to store points in 
        double[] points = new double[TWELVE];
        points[0] = this.upperLeft.getX();
        points[1] = this.upperLeft.getY();
        points[IND_TWO] = points[0] + this.side;
        points[IND_THREE] = points[1];
        points[IND_FOUR] = points[IND_TWO] + (this.side / HALF);
        points[IND_FIVE] = points[IND_THREE] + this.side;
        points[IND_SIX] = points[IND_TWO];
        points[IND_SEVEN] = points[IND_FIVE] + this.side;
        points[IND_EIGHT] = points[0];
        points[IND_NINE] = points[IND_SEVEN];
        points[IND_TEN] = points[IND_EIGHT] - (this.side / HALF);
        points[IND_ELEVEN] = points[IND_NINE] - this.side;
    
        // creates a polygon based on the points in the double array
        Polygon hexagon = new Polygon(points);
        
        // fill in the hexagon
        if(fill == true) {
            hexagon.setFill(c);
            group.getChildren().add(hexagon);
        }
        // don't fill in the hexagon
        else {            
            hexagon.setFill(null);
            hexagon.setStroke(c);
            group.getChildren().add(hexagon);
        }
    }
    
    /**
     * Draws a honeycomb using recursion of the draw method
     * 
     * @param group group to add honeycomb in
     * @param fill  whether or not to fill the honeycomb
     * @param n     number of hexagons to create
     * @return      none
     */
    
    public void drawHoneyComb(Group group, boolean fill, int n) {
        // base case: if n = 0, return nothing
        if(n == 0) {
            return;
        }
        
        // draw the hexagon
        draw(group, getRandomColor(), fill); 
        
        
        if(n > 1) {
            // recursion: create new CreativeShape objects with the appropriate
            //            upperLeft point then draw honeycomb again with 1 less
            //            hexagon
            CreativeShape bottomMiddle = new CreativeShape(new Point
                                                (this.upperLeft.getX(), 
                                                 this.upperLeft.getY() 
                                                 + (HALF * side)), this.side);
            bottomMiddle.drawHoneyComb(group, fill, n - 1);

            CreativeShape bottomRight = new CreativeShape(new Point
                                               (this.upperLeft.getX() + side 
                                                + (side / HALF), 
                                                this.upperLeft.getY() + side), 
                                                this.side);
            bottomRight.drawHoneyComb(group, fill, n - 1);

            CreativeShape topRight = new CreativeShape(new Point
                                            (this.upperLeft.getX() + side 
                                             + (side / HALF), 
                                             this.upperLeft.getY() - side), 
                                             this.side);
            topRight.drawHoneyComb(group, fill, n - 1);

            CreativeShape topMiddle = new CreativeShape(new Point
                                            (this.upperLeft.getX(), 
                                             this.upperLeft.getY() 
                                             - (HALF * side)), this.side);
            topMiddle.drawHoneyComb(group, fill, n - 1);
        
            CreativeShape topLeft = new CreativeShape(new Point
                                           (this.upperLeft.getX() - side 
                                            - (side / HALF), 
                                            this.upperLeft.getY() - side), 
                                            this.side);
            topLeft.drawHoneyComb(group, fill, n - 1);
        
            CreativeShape bottomLeft = new CreativeShape(new Point
                                              (this.upperLeft.getX() - side 
                                               - (side / HALF), 
                                               this.upperLeft.getY() + side)
                                               , this.side);
            bottomLeft.drawHoneyComb(group, fill, n - 1);
        }
   }
    
}

