import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.*;


public class TestMickey extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TestMickey");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);
        
        try {
            test_mickey();
            draw_mickey(root);
        } catch (Exception e) {

            Text exceptiontext = new Text(50,50, 
                "An exception occurred, see terminal for stack trace");
            exceptiontext.setFont(Font.font("Consolas", 13));
            exceptiontext.setFill(Color.RED);
            root.getChildren().add(exceptiontext);

            e.printStackTrace();
        }

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void test_mickey() throws Exception {

        // test Point no arg constructor, should be (0,0)
        Point p = new Point();
        if ( p.getX() != 0 || p.getY() != 0) 
            throw new IllegalStateException(
                "Point no-arg constructor should initialize to (0,0)\n");
        
        // test Circle8B no arg constructor, should be (0,0) with radius=0
        Circle8B c = new Circle8B();
        if (c.getRadius() != 0 ||
            c.getCenter().getX() != 0 || c.getCenter().getY() != 0) 
            throw new IllegalStateException(
                "Circle8B no-arg ctor should initialize to (0,0) w/ radius 0\n");

        // test Circle8B deep copy
        Circle8B copy = new Circle8B(c);
        if (copy.getCenter() == c.getCenter()) 
            throw new IllegalAccessException(
                "Circle8B copy constructor should deep copy center\n");
    }

    public void draw_mickey(Group root) {
        
        Circle8B head = new Circle8B(new Point(250, 250), 100, "Head");
        head.draw(root, Color.BLACK, true);

        Circle8B leftear = new Circle8B(new Point(150, 150), 50, "Left ear");
        leftear.draw(root, Color.BLACK, true);

        Circle8B rightear = new Circle8B(new Point(350, 150), 50, "Right ear");
        rightear.draw(root, Color.BLACK, true);

        Text headstring = new Text(50, 400, head.toString());
        headstring.setFont(Font.font("Consolas", 13));
        root.getChildren().add(headstring);

        Text leftearstring = new Text(50, 420, leftear.toString());
        leftearstring.setFont(Font.font("Consolas", 13));
        root.getChildren().add(leftearstring);

        Text rightearstring = new Text(50, 440, rightear.toString());
        rightearstring.setFont(Font.font("Consolas", 13));
        root.getChildren().add(rightearstring);
    }
}