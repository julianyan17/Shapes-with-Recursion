import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.*;

public class TestSpecialShapes extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TestSpecialShapes");
        Group root = new Group();
        Scene scene = new Scene(root, 1900, 960);

        Line8B l;
        l = new Line8B(new Point(600,60), new Point(600,930), "LeftSeparator");
        l.draw(root, Color.LIGHTGRAY, false);
        Text line1text = new Text(
            400, 35, l.toString());
        line1text.setFont(Font.font("Consolas", 12));
        root.getChildren().add(line1text);

        l = new Line8B(new Point(1200,60), new Point(1200,930), "RightSeparator");
        l.draw(root, Color.LIGHTGRAY, false);
        Text line2 = new Text(
                1000, 35, l.toString());
        line2.setFont(Font.font("Consolas", 12));
        root.getChildren().add(line2);
        
        // bullseye

        Circle8B c = new Circle8B(new Point(300, 270), 200, "BullseyeFill");
        c.drawBullsEye(root, true, 19);
        Text circlestring = new Text(
            100, 500, c.toString());
        circlestring.setFont(Font.font("Consolas", 12));
        root.getChildren().add(circlestring);

        c = new Circle8B(new Point(300, 720), 200, "BullseyeFrame");
        c.drawBullsEye(root, false, 19);
        circlestring = new Text(
            100, 940, c.toString());
        circlestring.setFont(Font.font("Consolas", 12));
        root.getChildren().add(circlestring);

        // grid

        Square s = new Square(new Point(900, 270), 25, "GridFill");
        s.drawGrid(root, true, 8);
        Text squarestring = new Text(
            725, 500, s.toString());
        squarestring.setFont(Font.font("Consolas", 12));
        root.getChildren().add(squarestring);

        s = new Square(new Point(900, 720), 25, "GridFrame");
        s.drawGrid(root, false, 8);
        squarestring = new Text(
            725, 940, s.toString());
        squarestring.setFont(Font.font("Consolas", 12));
        root.getChildren().add(squarestring);

        // tri

        Triangle t = new Triangle(
            new Point(1500, 70),
            new Point(1300,470),
            new Point(1700,470), "TriforceFill");
        t.drawTriforce(root, true, 5);
        Text triangle = new Text(
            1230, 500, t.toString());
        triangle.setFont(Font.font("Consolas", 12));
        root.getChildren().add(triangle);

        t = new Triangle(
            new Point(1500,520),
            new Point(1300,920),
            new Point(1700,920), "TriforceFrame");
        t.drawTriforce(root, false, 5);
        triangle = new Text(
            1230, 940, t.toString());
        triangle.setFont(Font.font("Consolas", 12));
        root.getChildren().add(triangle);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
