/**
 * Author: Julian Wai San Yan
 * Date: 1/26/19
 * File: Square.java
 */

/**
 * Included below are methods
 * to create a Square object, to get the side and upperLeft point of a Square 
 * object, to set the side and upperLeft point of a Square object, to 
 * override the abstract draw method and to draw a grid. 
 */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

import java.util.*;

/** 
 * This class includes methods that allows the creation of Square objects and
 * override the abstract draw method and a method that utilizes recursion to 
 * draw grid. Important instance methods are the side and upperLeft point of the
 * Square objects.
 */

public class Square extends Shape {

    // side and upperLeft point of a Square object
    private int side;
    private Point upperLeft;

    // object with no name
    private static final String NONAME = "NoName";

    /** 
     * Getter that gets the side of a Square object
     *
     * @param none
     * @return     the side point of a Square object
     */

    public int getSide() {
        return this.side;
    }

    /** 
     * Getter that gets the upperLeft point of a Square object
     *
     * @param none
     * @return     the upperLeft point of a Square object
     */

    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Setter that sets the side of a Square object
     * 
     * @param side side of the Square object
     * @return     void
     */

    private void setSide(int side) {
        this.side = side;
    }

    /**
     * Setter that sets the side of a Square object
     * 
     * @param side side of the Square object
     * @return     void
     */

    private void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    /** 
     * Constructor that creates a deep copy of the upperLeft point and side
     * passed in 
     * 
     * @param upperLeft center of the Square object
     * @param side      side of the Square object
     * @return          Square object created
     */

    public Square(Point upperLeft, int side) {
        super(NONAME);
        this.setUpperLeft(new Point(upperLeft));
        this.setSide(side);
    }

    /** 
     * Constructor that creates a deep copy of the upperLeft point, side and
     * name passed in 
     * 
     * @param upperLeft center of the Square object
     * @param side      side of the Square object
     * @param name      name of the Square object
     * @return          Square object created
     */

    public Square(Point upperLeft, int side, String name) {
        super(name);
        this.setUpperLeft(new Point(upperLeft));
        this.setSide(side);
    }

    /** 
     * Copy constructor that creates a deep copy of the Square object passed
     * in
     * 
     * @param c Square object to be copied
     * @return  Square object created
     */

    public Square(Square square) {
        super(NONAME);
        this.setUpperLeft(new Point(square.getUpperLeft()));
        this.setSide(square.getSide());
    }

    /**
     * Default constructor that sets the name to NoName, upperLeft Point to 
     * (0,0) and side to 0
     *
     * @param none
     * @return     Square object created
     */  

    public Square() {
        super(NONAME);
        this.setUpperLeft(new Point(0,0));
        this.setSide(0);
    }
    
    /** 
     * Returns the String representation of a Square object
     *
     * @param none
     * @return     a String representation of a Square object
     */
   
    @Override
    public String toString() {
        return String.format("Square: %s; upperLeft: %s; side: %d",
                    getShapeName(), upperLeft.toString(), side);
    }
    
    /**
     * Draws the Square object into the group
     *
     * @param group group to add Square object in
     * @param c     color of Square object
     * @param fill  whether or not to fill the Square object
     * @return      none
     */
    
    @Override
    public void draw(Group group, Color c, boolean fill) {
        // create a square
        Rectangle square = new Rectangle(upperLeft.getX(), upperLeft.getY(), 
                                    side, side);
        // fill in the square
        if(fill == true) {
            square.setFill(c);
            group.getChildren().add(square);
        }
        // don't fill in the square
        else {            
            square.setFill(null);
            square.setStroke(c);
            group.getChildren().add(square);
        }
    }

    /**
     * Draws a grid using recursion of the draw method
     * 
     * @param group group to add grid in
     * @param fill  whether or not to fill the grid
     * @param n     number of squares to create
     * @return      none
     */
    
    public void drawGrid(Group group, boolean fill, int n) {
        // base case: if n = 0, return nothing
        if(n == 0) { 
            return;
        }
        // draw the square
        draw(group, getRandomColor(), fill);

        if(n > 1) {
            // create a copies of the square, change the upperLeft corner 
            // by the side depending on which square and then draw grid again
            // with 1 less square
            Square topLeft = new Square(new Point(this.upperLeft.getX() 
                           - this.side, this.upperLeft.getY() 
                           - this.side), this.side);
            topLeft.drawGrid(group, fill, n - 1);

            Square topRight = new Square(new Point(this.upperLeft.getX() 
                            + this.side, this.upperLeft.getY() 
                            - this.side), this.side);
            topRight.drawGrid(group, fill, n - 1);


            Square bottomLeft = new Square(new Point(this.upperLeft.getX() 
                              - this.side, this.upperLeft.getY() 
                              + this.side), this.side);
            bottomLeft.drawGrid(group, fill, n - 1);

            Square bottomRight = new Square(new Point(this.upperLeft.getX()
                               + this.side, this.upperLeft.getY() 
                               + this.side), this.side);
            bottomRight.drawGrid(group, fill, n - 1);

        }
    }
}



