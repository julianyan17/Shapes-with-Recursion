import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.*;


public class TestSquare extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TestLines");
        Group root = new Group(); // Pass in "root" to your draw methods
        Scene scene = new Scene(root, 500, 500); // Change window size here

        Point upperLeft = new Point(400,250);

        Square s = new Square(upperLeft, 30, "hi");
       // s.draw(root, Color.PINK, false);        
        s.drawGrid(root, false, 1);
        // s.draw(root, Color.PINK, false);
        System.out.println(s.toString());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

