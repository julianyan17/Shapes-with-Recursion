/**
 * Author: Julian Wai San Yan
 * Date: 1/26/19
 * File: Triangle.java
 */

/**
 * Included below are methods
 * to create a Triangle object, to get the three points of a Triangle object, 
 * to set the three points of a Tirangle object, to override the abstract draw 
 * method and to draw a triforce. 
 */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

import java.util.*;

/**
 * This class includes methods that allows the creation of Triangle objects, an
 * override of the abstract draw method and a method that utilizes recursion to
 * draw a triforce. Important instance variables are the three points of the 
 * Triangle objects.
 */

public class Triangle extends Shape {

    // the three points of the Triangle
    private Point p1;
    private Point p2;
    private Point p3;

    // object with no name
    private static final String NONAME = "NoName";

    // index of double array
    private static final int IND_TWO = 2;
    private static final int IND_THREE = 3;
    private static final int IND_FOUR = 4; 
    private static final int IND_FIVE = 5;

    // size of double array
    private static final int SIX = 6;

    // divide by half
    private static final int HALF = 2;

    /** 
     * Getter that gets the first point of a Triangle object
     *
     * @param none
     * @return     the first point of a Triangle object
     */

    public Point getP1() {
        return this.p1;
    }
    
    /** 
     * Getter that gets the second point of a Triangle object
     *
     * @param none
     * @return     the second point of a Triangle object
     */

    public Point getP2() {
        return this.p2;
    }

    /** 
     * Getter that gets the third point of a Triangle object
     *
     * @param none
     * @return     the third point of a Triangle object
     */

    public Point getP3() {
        return this.p3;
    }

    /**
     * Setter that sets the first point of a Triangle object
     * 
     * @param p1 first point of the Triangle object
     * @return   void
     */

    private void setP1(Point p1) {
        this.p1 = p1;
    }

    /**
     * Setter that sets the second point of a Triangle object
     * 
     * @param p2 second point of the Triangle object
     * @return   void
     */

    private void setP2(Point p2) {
        this.p2 = p2;
    }
    
    /**
     * Setter that sets the third point of a Triangle object
     * 
     * @param p3 third point of the Triangle object
     * @return   void
     */

    private void setP3(Point p3) {
        this.p3 = p3;
    }

    /** 
     * Constructor that creates a deep copy of the center point and radius
     * passed in 
     * 
     * @param p1 first point of the Triangle object
     * @param p2 second point of the Triangle object
     * @param p3 third point of the Triangle object
     * @return   Triangle object created
     */    

    public Triangle(Point p1, Point p2, Point p3) {
        super(NONAME);
        this.setP1(new Point(p1));
        this.setP2(new Point(p2));
        this.setP3(new Point(p3));
    }
    
   /** 
     * Constructor that creates a deep copy of the center point and radius
     * passed in 
     * 
     * @param p1   first point of the Triangle object
     * @param p2   second point of the Triangle object
     * @param p3   third point of the Triangle object
     * @param name name of the Triangle object
     * @return     Triangle object created
     */    

    public Triangle(Point p1, Point p2, Point p3, String name) {
        super(name);
        this.setP1(new Point(p1));
        this.setP2(new Point(p2));
        this.setP3(new Point(p3));
    }
    
   /** 
     * Copy constructor that creates a deep copy of the Triangle object passed
     * in
     * 
     * @param tri Triangle object to be copied
     * @return    Triangle object created
     */

    public Triangle(Triangle tri) {
        super(NONAME);
        this.setP1(new Point(tri.getP1()));
        this.setP2(new Point(tri.getP2()));
        this.setP3(new Point(tri.getP3()));
    }

   /**
     * Default constructor that sets the name to NoName, p1 to (0,0), p2 to 
     * (0,0) and p3 to (0,0)
     *
     * @param none
     * @return     Triangle object created
     */

    public Triangle() {
        super(NONAME);
        this.setP1(new Point(0,0));
        this.setP2(new Point(0,0));
        this.setP3(new Point(0,0));
    }

    /** 
     * Returns the String representation of a Triangle object
     *
     * @param none
     * @return     a String representation of a Triangle object
     */
    
    @Override
    public String toString() {
        return String.format("Triangle: %s; p1: %s; p2: %s; p3: %s",
                getShapeName(), p1.toString(), p2.toString(), p3.toString());
    }

    /**
     * Draws the Triangle object into the group
     *
     * @param group group to add Triangle object in
     * @param c     color of Triangle object
     * @param fill  whether or not to fill the Triangle object
     * @return      none
     */
    
    @Override
    public void draw(Group group, Color c, boolean fill) {
        // creates double array to store points
        double[] points = new double[SIX];
        points[0] = p1.getX();
        points[1] = p1.getY();
        points[IND_TWO] = p2.getX(); 
        points[IND_THREE] = p2.getY();
        points[IND_FOUR] = p3.getX();
        points[IND_FIVE] = p3.getY();
        
        // creates a polygon based on the points in the double array
        Polygon triangle = new Polygon(points);
        
        // fill in the triangle
        if(fill == true) {
            triangle.setFill(c);
            group.getChildren().add(triangle);
        }
        // don't fill in the triangle
        else {
            triangle.setFill(null);
            triangle.setStroke(c);
            group.getChildren().add(triangle);
        }
    }
    
    /**
     * Draws a triforce using recursion of the draw method
     * 
     * @param group group to add triforce in
     * @param fill  whether or not to fill the trifore
     * @param n     number of triangles to create
     * @return      none
     */

    public void drawTriforce(Group group, boolean fill, int n) {
        // base case: if n = 0, return nothing
        if(n == 0) {
            return;
        }
        
        // draw the triangle
        draw(group, getRandomColor(), fill);

        if(n > 1) {
            // recursion: create new points, add the points to a new Triangle
            //            object and then draw triforce again with 1 less 
            //            triangle
            draw(group, getRandomColor(), fill);

            Point newP1 = new Point((p1.getX() + p2.getX()) / HALF,
                    (p1.getY() + p2.getY()) / HALF);
            Point newP2 = new Point((p2.getX() + p3.getX()) / HALF,
                    (p2.getY() + p3.getY()) / HALF);
            Point newP3 = new Point((p3.getX() + p1.getX()) / HALF,
                    (p3.getY() + p1.getY()) / HALF);
            Triangle newTriangle = new Triangle(newP1, newP2, newP3);
            newTriangle.drawTriforce(group, fill, n - 1);
        }
    }
}








