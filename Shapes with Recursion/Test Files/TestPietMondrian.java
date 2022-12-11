import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.*;

public class TestPietMondrian extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TestPietMondrian");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);
        
        Square s;
        // red
        s = new Square(new Point(50,50), 250);
        s.draw(root, new Color((float)241.0/256, 
                               (float)74.0/256, 
                               (float)50.0/256, 1), true);
        s = new Square(new Point(450,400), 100);
        s.draw(root, new Color((float)241.0/256, 
                               (float)74.0/256, 
                               (float)50.0/256, 1), true);
        // yellow
        s = new Square(new Point(300,50), 150);
        s.draw(root, new Color((float)254.0/256, 
                               (float)216.0/256, 
                               (float)99.0/256, 1), true);
        s = new Square(new Point(300,-100), 150);
        s.draw(root, new Color((float)254.0/256, 
                               (float)216.0/256, 
                               (float)99.0/256, 1), true);
        s = new Square(new Point(-50,400), 100);
        s.draw(root, new Color((float)254.0/256, 
                               (float)216.0/256, 
                               (float)99.0/256, 1), true);
        // black
        s = new Square(new Point(50,300), 150);
        s.draw(root, Color.BLACK, true);
        s = new Square(new Point(200,450), 100);
        s.draw(root, Color.BLACK, true);

        // blue
        s = new Square(new Point(300,400), 150);
        s.draw(root, new Color((float)0.0/256, 
                               (float)64.0/256, 
                               (float)122.0/256, 1), true);

        Line8B l;
        l = new Line8B(new Point(50,0), new Point(50,500));
        l.draw(root, Color.BLACK, false);
        l = new Line8B(new Point(0,50), new Point(450,50));
        l.draw(root, Color.BLACK, false);
        l = new Line8B(new Point(300,0), new Point(300,450));
        l.draw(root, Color.BLACK, false);
        l = new Line8B(new Point(450,0), new Point(450,500));
        l.draw(root, Color.BLACK, false);
        l = new Line8B(new Point(0,200), new Point(50,200));
        l.draw(root, Color.BLACK, false);
        l = new Line8B(new Point(0,400), new Point(50,400));
        l.draw(root, Color.BLACK, false);
        l = new Line8B(new Point(50,450), new Point(450,450));
        l.draw(root, Color.BLACK, false);
        l = new Line8B(new Point(50,300), new Point(450,300));
        l.draw(root, Color.BLACK, false);
        l = new Line8B(new Point(300,200), new Point(450,200));
        l.draw(root, Color.BLACK, false);
        l = new Line8B(new Point(375,200), new Point(375,300));
        l.draw(root, Color.BLACK, false);
        l = new Line8B(new Point(200,300), new Point(200,540));
        l.draw(root, Color.BLACK, false);
        l = new Line8B(new Point(200,400), new Point(500,400));
        l.draw(root, Color.BLACK, false);



        primaryStage.setScene(scene);
        primaryStage.show();
    }
}