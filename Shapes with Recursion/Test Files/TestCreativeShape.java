/**
 * Author: Julian Wai San Yan
 * Date: 1/26/19
 * File: TestCreativeShape.java
 */

/**
 * Included below is a main 
 * method that calls the start method and in the start method is multiple
 * CreativeShape objects that are added onto a group in order to be displayed.
 */

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.*;

/**
 * This class calls the drawHoneyComb method from CreativeShape.java and prints
 * out multiple filled and non-filled honeycombs. These honeycombs are made up
 * of multiple hexagons and are printed out through recursion.
 */

public class TestCreativeShape extends Application {

    /**
     * Main method to run the methods
     *
     * @param args the method calls
     * @return     void
     */

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Prints out the group on a window in order to visualize the objects that
     * are added onto the group
     *
     * @param primaryStage stage to be printed out on
     * @return             void
     */

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TestCreativeShape");
        Group root = new Group(); // Pass in "root" to your draw methods
        Scene scene = new Scene(root, 1050, 1000); // Change window size here

        // creates the first CreativeShape object
        CreativeShape h = new CreativeShape(new Point(150, 150), 20, 
                                            "Single Filled Honey Comb");
        // draws single filled honey comb
        h.drawHoneyComb(root, true, 1);
        Text hexagonstring = new Text(
            50, 300, h.toString());
        hexagonstring.setFont(Font.font("Consolas", 12));
        root.getChildren().add(hexagonstring);
        
        // updates the CreativeShape object and draws filled honey comb base
        h = new CreativeShape(new Point(500,150), 20, "Filled Honey Comb Base");
        h.drawHoneyComb(root, true, 2);
        hexagonstring = new Text(
            400, 300, h.toString());
        hexagonstring.setFont(Font.font("Consolas", 12));
        root.getChildren().add(hexagonstring);

        // updates the CreativeShape object and draws multiple filled honey 
        // combs
        h = new CreativeShape(new Point(850,150), 20, 
                              "Multiple Filled Honey Combs");
        h.drawHoneyComb(root, true, 3);
        hexagonstring = new Text(
            750, 300, h.toString());
        hexagonstring.setFont(Font.font("Consolas", 12));
        root.getChildren().add(hexagonstring);

        // draws single honey comb frame      
        h = new CreativeShape(new Point(150,500), 20,
                              "Single Honey Comb Frame");
        h.drawHoneyComb(root, false, 1);
        hexagonstring = new Text(
            50, 650, h.toString());
        hexagonstring.setFont(Font.font("Consolas", 12));
        root.getChildren().add(hexagonstring);
        
        // updates the CreativeShape object and draws honey comb base frame
        h = new CreativeShape(new Point(500,500), 20, "Honey Comb Base Frame");
        h.drawHoneyComb(root, false, 2);
        hexagonstring = new Text(
            400, 650, h.toString());
        hexagonstring.setFont(Font.font("Consolas", 12));
        root.getChildren().add(hexagonstring);

        // updates the CreativeShape object and draws multiple honey comb
        // frames
        h = new CreativeShape(new Point(850,500), 20, 
                              "Multiple Honey Comb Frames");
        h.drawHoneyComb(root, false, 3);
        hexagonstring = new Text(
            750, 650, h.toString());
        hexagonstring.setFont(Font.font("Consolas", 12));
        root.getChildren().add(hexagonstring);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

