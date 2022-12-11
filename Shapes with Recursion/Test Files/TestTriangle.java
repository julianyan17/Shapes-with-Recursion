import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.*;


public class TestTriangle extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TestLines");
        Group root = new Group(); // Pass in "root" to your draw methods
        Scene scene = new Scene(root, 500, 500); // Change window size here

        Point p1 = new Point(0,0);
        Point p2 = new Point(200,0);
        Point p3 = new Point(100,200);

        Triangle t = new Triangle(p1, p2, p3, "hi");
        // t.draw(root, Color.PINK, false);
        t.drawTriforce(root, true, 6);
        System.out.println(t.toString());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

