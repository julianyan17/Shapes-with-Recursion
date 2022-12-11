import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.*;


public class TestGoldenRatio extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TestGoldenRatio");
        Group root = new Group();
        Scene scene = new Scene(root, 450, 300);

        Fibonacci.draw(root, 300, 200,
                       1, 1, 180, 12);        

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
