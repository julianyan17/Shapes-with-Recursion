/**
 * Author: Julian Wai San Yan
 * Date: 1/26/19
 * File: Fibonacci.java
 */

/**
 * Included below is a method to draw
 * an arc based off the fiobancci sequence.
 */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

/**
 * This class includes at method that will draw an arc based on the Fibonacci
 * sequence given inputs such as the center point, the previou radius, the
 * current radius, the angle at start and the number of arcs.
 */

public class Fibonacci {

    // every arc is a quarter circle
    static final int arcLength = 90;

    private static final int THREE_SIXTY = 360;
    private static final int TWO_SEVENTY = 270;
    private static final int ONE_EIGHTY = 180;
    private static final int NINETY = 90;
    
    /** 
     * Draws an arc based on the fibonacci sequence
     *
     * @param group      group to add arc into
     * @param centerX    x coordinate of 
     * @param centerY    y coordinate of center
     * @param prevRadius previous radius
     * @param currRadius current radius
     * @param startAngle starting angle
     * @param n          number of arcs
     * @return           void
     */

    public static void draw(Group group, int centerX, int centerY,
                            int prevRadius, int currRadius, int startAngle,
                            int n) {
        // base case: if n = 0, return nothing
        if (n == 0) {
            return;
        }

        Arc a = new Arc(centerX, centerY, currRadius, currRadius, 
                        startAngle, arcLength);
        a.setType(ArcType.ROUND);
        a.setFill(null);
        a.setStroke(Color.BLACK);
        group.getChildren().add(a);

        int newCenterX = 0;
        int newCenterY = 0;
        
        // depending on the angle, update the center appropriately
        if(startAngle == THREE_SIXTY) {
            startAngle = 0;
        }
        
        if(startAngle == 0) {
            newCenterX = centerX;
            newCenterY = centerY + prevRadius;
        }

        if(startAngle == NINETY) {
            newCenterX = centerX + prevRadius;
            newCenterY = centerY;
        }

        if(startAngle == ONE_EIGHTY) {
            newCenterX = centerX;
            newCenterY = centerY - prevRadius;
        }

        if(startAngle == TWO_SEVENTY) {
            newCenterX = centerX - prevRadius;
            newCenterY = centerY;

        }
        
        // update the radius
        int currRadiusCopy = currRadius; 
        currRadius = currRadius + prevRadius;
        prevRadius = currRadiusCopy;
        
        // update the angle
        startAngle = startAngle + NINETY;

        // recursion: call draw again but with the updated center, radius and
        //            startAngle and with 1 less arc
        draw(group, newCenterX, newCenterY, prevRadius, currRadius, startAngle, 
             n - 1);
    }

}
